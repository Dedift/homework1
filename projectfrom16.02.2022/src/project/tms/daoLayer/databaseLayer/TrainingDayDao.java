package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.Connection.ConnectionPool;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.Train.Exercise;
import project.tms.daoLayer.entityLayer.Train.TrainingDay;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TrainingDayDao extends GenericDao<TrainingDay> {

    private static final String WHERE_ID = "WHERE id = (?)";
    private static final String WHERE_USER_ID = "WHERE user_id = (?)";
    private static final String SAVE_TRAINING_DAY = "INSERT INTO gym_schema.train_day (count_sets_per_exercise, count_repetitions_per_set, user_id) " +
            "VALUES ((?), (?), (?))";
    private static final String SAVE_TRAINING_DAY_EXERCISES = "INSERT INTO gym_schema.train_day_exercises (exercise_id, train_day_id) " +
            "VALUES ((?), (?))";
    private static final String SELECT_TRAINING_DAY_BY_ID = "SELECT id, count_sets_per_exercise, count_repetitions_per_set FROM gym_schema.train_day " +
            WHERE_ID;
    private static final String SELECT_TRAINING_DAY_BY_USER_ID = "SELECT id, count_sets_per_exercise, count_repetitions_per_set FROM gym_schema.train_day " +
            WHERE_USER_ID;
    private static final String UPDATE_TRAINING_DAY = "UPDATE gym_schema.train_day " +
            "SET count_sets_per_exercise = (?), count_repetitions_per_set = (?), user_id = (?) " +
            WHERE_ID;
    private static final String DELETE_TRAINING_DAY_BY_ID = "DELETE FROM gym_schema.train_day " +
            WHERE_ID;
    private static final String ID = "id";
    private static final String COUNT_SETS_PER_EXERCISE = "count_sets_per_exercise";
    private static final String COUNT_REPETITIONS_PER_SET = "count_repetitions_per_set";

    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static TrainingDayDao instance;

    private TrainingDayDao() {
    }

    public static TrainingDayDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TrainingDayDao();
        }
        return instance;
    }

    public void save(TrainingDay trainingDay) throws DaoException {
        int id = super.save(SAVE_TRAINING_DAY, trainingDay);
        trainingDay.setId(id);
        List<Exercise> exercises = trainingDay.getExercises();
        for (int i = 0; i < exercises.size(); i++) {
            saveTrainDayExercises(trainingDay, exercises.get(i));
        }
    }
    private static void saveTrainDayExercises(TrainingDay trainingDay, Exercise exercise) throws DaoException {
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            exercise = ExerciseDao.getInstance().save(exercise);
            preparedStatement = connection.prepareStatement(SAVE_TRAINING_DAY_EXERCISES);
            preparedStatement.setInt(1, exercise.getId());
            preparedStatement.setInt(2, trainingDay.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            connectionPool.rollback(connection);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
    }

    public Optional<TrainingDay> findById(Integer id) throws DaoException {
        List<Exercise> byTrainDayId = DaoFactory.getInstance().getExerciseDao().findByTrainDayId(id);
        List<TrainingDay> trainingDays = super.findByFields(SELECT_TRAINING_DAY_BY_ID, id);
        Optional<TrainingDay> trainingDay = Optional.ofNullable(trainingDays.get(Number.ZERO));
        if(trainingDay.isPresent()){
            trainingDay.get().getExercises().addAll(byTrainDayId);
        }
        return trainingDay;
    }

    public List<TrainingDay> findByUserId(Integer id) throws DaoException {
        List<TrainingDay> trainingDays = super.findByFields(SELECT_TRAINING_DAY_BY_USER_ID, id);
        for (int i = 0; i < trainingDays.size(); i ++){
            TrainingDay trainingDay = trainingDays.get(i);
            trainingDay.getExercises().addAll(DaoFactory.getInstance().getExerciseDao().findByTrainDayId(trainingDay.getId()));
        }
        return trainingDays;
    }

    public void update(TrainingDay trainingDay) throws DaoException {
        super.updateByField(UPDATE_TRAINING_DAY, trainingDay, Number.FOUR, trainingDay.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_TRAINING_DAY_BY_ID, id);
    }

    @Override
    protected TrainingDay mapToEntity(ResultSet resultSet) throws DaoException {
        TrainingDay result = new TrainingDay();
        try {
            result.setId(resultSet.getInt(ID));
            result.setCountSetsPerExercise(resultSet.getInt(COUNT_SETS_PER_EXERCISE));
            result.setCountRepetitionsPerSet(resultSet.getInt(COUNT_REPETITIONS_PER_SET));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, TrainingDay trainingDay) throws DaoException {
        try {
            ps.setInt(Number.ONE, trainingDay.getCountSetsPerExercise());
            ps.setInt(Number.TWO, trainingDay.getCountRepetitionsPerSet());
            ps.setInt(Number.THREE, trainingDay.getUser().getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}