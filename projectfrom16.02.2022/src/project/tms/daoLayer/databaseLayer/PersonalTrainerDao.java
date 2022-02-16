package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.Train.PersonalTrainer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PersonalTrainerDao extends GenericDao<PersonalTrainer> {

    public static final String WHERE_ID = "WHERE id = (?)";
    public static final String WHERE_FIRST_NAME = "WHERE first_name = (?)";
    public static final String WHERE_LAST_NAME = "WHERE last_name = (?)";
    public static final String WHERE_GENDER = "WHERE gender = (?)";
    public static final String WHERE_DATE_OF_BIRTH_LESS = "WHERE date_of_birth < (?)";
    public static final String WHERE_DATE_OF_BIRTH_MORE = "WHERE date_of_birth > (?)";
    public static final String WHERE_EXPERIENCE_MORE = "WHERE experience > (?)";
    private static final String SAVE_PERSONAL_TRAINER = "INSERT INTO gym_schema.personal_trainer (first_name, last_name, gender, date_of_birth, experience) " +
            "VALUES ((?), (?), (?), (?), (?))";
    private static final String SELECT_ALL_Personal_Trainers = "SELECT id, first_name, last_name, gender, date_of_birth, experience " +
            "FROM gym_schema.personal_trainer";
    private static final String SELECT_PERSONAL_TRAINER_BY_ID = SELECT_ALL_Personal_Trainers +
            WHERE_ID;
    private static final String SELECT_PERSONAL_TRAINERS_BY_FIRST_NAME = SELECT_ALL_Personal_Trainers +
            WHERE_FIRST_NAME;
    private static final String SELECT_PERSONAL_TRAINERS_BY_LAST_NAME = SELECT_ALL_Personal_Trainers +
            WHERE_LAST_NAME;
    private static final String SELECT_PERSONAL_TRAINERS_BY_GENDER = SELECT_ALL_Personal_Trainers +
            WHERE_GENDER;
    private static final String SELECT_OLDER_PERSONAL_TRAINERS = SELECT_ALL_Personal_Trainers +
            WHERE_DATE_OF_BIRTH_LESS;
    private static final String SELECT_YOUNGER_PERSONAL_TRAINERS = SELECT_ALL_Personal_Trainers +
            WHERE_DATE_OF_BIRTH_MORE;
    private static final String SELECT_PERSONAL_TRAINERS_BY_EXPERIENCE_MORE = SELECT_ALL_Personal_Trainers +
            WHERE_EXPERIENCE_MORE;
    private static final String UPDATE_PERSONAL_TRAINER = "UPDATE gym_schema.personal_trainer " +
            "SET first_name = (?), last_name = (?), gender = (?), date_of_birth = (?), experience = (?) " +
            WHERE_ID;
    private static final String DELETE_PERSONAL_TRAINER_BY_ID = "DELETE FROM gym_schema.personal_trainer" +
            WHERE_ID;
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String GENDER = "gender";
    private static final String DATE_OF_BIRTH = "date_of_birth";
    private static final String EXPERIENCE = "experience";
    private static final String ID = "id";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static PersonalTrainerDao instance;

    private PersonalTrainerDao() {
    }

    public static PersonalTrainerDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PersonalTrainerDao();
        }
        return instance;
    }

    public PersonalTrainer save(PersonalTrainer personalTrainer) throws DaoException {
        int id = super.save(SAVE_PERSONAL_TRAINER, personalTrainer);
        personalTrainer.setId(id);
        return personalTrainer;
    }

    public List<PersonalTrainer> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_Personal_Trainers);
    }

    public Optional<PersonalTrainer> findById(Integer id) throws DaoException {
        Optional<PersonalTrainer> result = Optional.empty();
        List<PersonalTrainer> personalTrainers = super.findByFields(SELECT_PERSONAL_TRAINER_BY_ID, id);
        if (personalTrainers.size() > Number.ZERO) {
            result = Optional.of(personalTrainers.get(Number.ZERO));
        }
        return result;
    }

    public List<PersonalTrainer> findByFirstName(String firstName) throws DaoException {
        return super.findByFields(SELECT_PERSONAL_TRAINERS_BY_FIRST_NAME, firstName);
    }

    public List<PersonalTrainer> findByLastName(String lastName) throws DaoException {
        return super.findByFields(SELECT_PERSONAL_TRAINERS_BY_LAST_NAME, lastName);
    }

    public List<PersonalTrainer> findByGender(String gender) throws DaoException {
        return super.findByFields(SELECT_PERSONAL_TRAINERS_BY_GENDER, gender);
    }

    public List<PersonalTrainer> findPersonalTrainersOlderThanAge(Integer age) throws DaoException {
        LocalDate date = LocalDate.now().minusYears(age);
        return super.findByFields(SELECT_OLDER_PERSONAL_TRAINERS, date);
    }

    public List<PersonalTrainer> findPersonalTrainersYoungerThanAge(Integer age) throws DaoException {
        LocalDate date = LocalDate.now().minusYears(age);
        return super.findByFields(SELECT_YOUNGER_PERSONAL_TRAINERS, date);
    }

    public List<PersonalTrainer> findExperienceMore(Integer experience) throws DaoException {
        return super.findByFields(SELECT_PERSONAL_TRAINERS_BY_EXPERIENCE_MORE, experience);
    }

    public void update(PersonalTrainer personalTrainer) throws DaoException {
        super.updateByField(UPDATE_PERSONAL_TRAINER, personalTrainer, Number.SIX, personalTrainer.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_PERSONAL_TRAINER_BY_ID, id);
    }

    @Override
    protected PersonalTrainer mapToEntity(ResultSet resultSet) throws DaoException {
        PersonalTrainer result = new PersonalTrainer();
        try {
            result.setFirstName(resultSet.getString(FIRST_NAME));
            result.setLastName(resultSet.getString(LAST_NAME));
            result.setGender(resultSet.getString(GENDER));
            result.setDateOfBirth(resultSet.getDate(DATE_OF_BIRTH).toLocalDate());
            result.setExperience(resultSet.getInt(EXPERIENCE));
            result.setId(resultSet.getInt(ID));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, PersonalTrainer personalTrainer) throws DaoException {
        try {
            ps.setString(Number.ONE, personalTrainer.getFirstName());
            ps.setString(Number.TWO, personalTrainer.getLastName());
            ps.setString(Number.THREE, personalTrainer.getGender());
            ps.setDate(Number.FOUR, Date.valueOf(personalTrainer.getDateOfBirth()));
            ps.setInt(Number.FIVE, personalTrainer.getExperience());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}