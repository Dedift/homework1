package project.tms.dao;

import project.tms.entities.Train.PersonalTrainer;
import project.tms.entities.User.Gender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PersonalTrainerDao extends GenericDao<PersonalTrainer> {

    private static final String SELECT_ALL_PersonalTrainers = "SELECT id, firstname, lastname, gender, date_of_birth, experience FROM gym_schema.personal_trainer";
    private static final String SELECT_PERSONAL_TRAINER_BY_ID = "SELECT id, firstname, lastname, gender, date_of_birth, experience " +
            "FROM gym_schema.personal_trainer " +
            "WHERE id = (?)";
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

    public Optional<PersonalTrainer> findById(Integer id) {
        List<PersonalTrainer> personalTrainers = super.findByField(SELECT_PERSONAL_TRAINER_BY_ID, id);
        return Optional.ofNullable(personalTrainers.get(0));
    }

    public List<PersonalTrainer> findAll() {
        return super.findAll(SELECT_ALL_PersonalTrainers);
    }

    @Override
    protected PersonalTrainer mapToEntity(ResultSet resultSet) {
        PersonalTrainer result = new PersonalTrainer();
        try {
            result.setFirstName(resultSet.getString("firstname"));
            result.setLastName(resultSet.getString("lastname"));
            result.setGender(Gender.valueOf((resultSet.getString("gender").toUpperCase())));
            result.setDateOfBirth(resultSet.getDate("date_of_birth"));
            result.setExperience(resultSet.getInt("experience"));
            result.setId(resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, PersonalTrainer obj) throws SQLException {

    }
}