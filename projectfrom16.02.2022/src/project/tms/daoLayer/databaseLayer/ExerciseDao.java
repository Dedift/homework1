package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.Train.Exercise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExerciseDao extends GenericDao<Exercise> {

    public static final String WHERE_ID = "WHERE id = (?)";
    private static final String WHERE_NAME = "WHERE name = (?)";
    private static final String WHERE_TRAIN_DAY_ID = "WHERE train_day_id = (?)";
    private static final String SAVE_EXERCISE = "INSERT INTO gym_schema.exercise (name) " +
            "VALUES ((?))";
    private static final String SELECT_ALL_EXERCISES = "SELECT e.id, e.name FROM gym_schema.exercise e ";
    private static final String SELECT_EXERCISE_BY_ID = SELECT_ALL_EXERCISES + WHERE_ID;
    private static final String SELECT_EXERCISE_BY_NAME = SELECT_ALL_EXERCISES + WHERE_NAME;
    private static final String SELECT_EXERCISES_BY_TRAINING_DAY_ID = SELECT_ALL_EXERCISES +
            "JOIN gym_schema.Train_day_exercises Tde on e.id = Tde.exercise_id " +
            "JOIN gym_schema.Train_day Td on Td.id = Tde.train_day_id " +
            WHERE_TRAIN_DAY_ID;
    private static final String UPDATE_EXERCISE = "UPDATE gym_schema.exercise " +
            "SET name = (?)" + WHERE_ID;
    private static final String DELETE_EXERCISE_BY_ID = "DELETE FROM gym_schema.exercise WHERE id = (?)";
    private static final String ID = "id";
    public static final String NAME = "name";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static ExerciseDao instance;

    private ExerciseDao() {
    }

    public static ExerciseDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ExerciseDao();
        }
        return instance;
    }

    public Exercise save(Exercise exercise) throws DaoException {
        int id = super.save(SAVE_EXERCISE, exercise);
        exercise.setId(id);
        return exercise;
    }

    public List<Exercise> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_EXERCISES);
    }

    public Optional<Exercise> findById(Integer id) throws DaoException {
        List<Exercise> exercises = super.findByFields(SELECT_EXERCISE_BY_ID, id);
        return Optional.ofNullable(exercises.get(Number.ZERO));
    }

    public List<Exercise> findByTrainDayId(Integer id) throws DaoException {
        return super.findByFields(SELECT_EXERCISES_BY_TRAINING_DAY_ID, id);
    }

    public Optional<Exercise> findByName(String name) throws DaoException {
        List<Exercise> exercises = super.findByFields(SELECT_EXERCISE_BY_NAME, name);
        return Optional.ofNullable(exercises.get(Number.ZERO));
    }

    public void update(Exercise exercise) throws DaoException {
        super.updateByField(UPDATE_EXERCISE, exercise, Number.TWO, exercise.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_EXERCISE_BY_ID, id);
    }

    @Override
    protected Exercise mapToEntity(ResultSet resultSet) throws DaoException {
        Exercise result = new Exercise();
        try {
            result.setName(resultSet.getString(NAME));
            result.setId(resultSet.getInt(ID));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Exercise exercise) throws DaoException {
        try {
            ps.setString(Number.ONE, exercise.getName());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}