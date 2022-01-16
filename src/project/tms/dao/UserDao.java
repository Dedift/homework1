package project.tms.dao;

import project.tms.entities.User.Gender;
import project.tms.entities.User.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao extends GenericDao<User> {

    private static final String SELECT_ALL_USERS = "SELECT id, email, first_name, last_name, phone_number, gender, date_of_birth" +
            " FROM gym_schema.\"User\"";
    private static final String SELECT_USER_BY_ID = "SELECT id, email, first_name, last_name, phone_number, gender, date_of_birth " +
            "FROM gym_schema.\"User\" " +
            "WHERE id = (?)";
    private static final String SELECT_USERS_BY_FIRSTNAME = "SELECT id, email, first_name, last_name, phone_number, gender, date_of_birth " +
            "FROM gym_schema.\"User\" " +
            "WHERE first_name = (?)";
    private static final String SELECT_USERS_BY_LAST_NAME = "SELECT id, email, first_name, last_name, phone_number, gender, date_of_birth " +
            "FROM gym_schema.\"User\" " +
            "WHERE last_name = (?)";
    private static final String SAVE_USER = "INSERT INTO gym_schema.\"User\" (email, password, gender, role) VALUES ((?), (?), (?), (?))";
    private static final String UPDATE_USER = "UPDATE gym_schema.\"User\" " +
            "SET email = (?), password = (?), first_name = (?), last_name = (?), phone_number = (?), gender = (?), date_of_birth = (?)," +
            " bank_card = (?), role = (?), personal_trainer_id = (?) WHERE id = (?)";
    private static final String DELETE_USER_FROM_ID = "DELETE FROM gym_schema.\"User\" WHERE id = (?)";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> findAll() {
        return super.findAll(SELECT_ALL_USERS);
    }

    public Optional<User> findById(Integer id) {
        Optional<User> result = Optional.empty();
        List<User> users = super.findByField(SELECT_USER_BY_ID, id);
        if (users.size() > 0){
            result = Optional.of(users.get(0));
        }
        return result;
    }

    public List<User> findByFirstName(String firstName) {
        return super.findByField(SELECT_USERS_BY_FIRSTNAME, firstName);
    }

    public List<User> findByLastName(String lastName) {
        return super.findByField(SELECT_USERS_BY_LAST_NAME, lastName);
    }

    public void save(User user) {
        int id = super.save(SAVE_USER, user);
        user.setId(id);
    }

    public void delete(int id) {
        super.deleteByField(DELETE_USER_FROM_ID, id);
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, User user) throws SQLException {
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getGender().toString());
        ps.setString(4, user.getRole().toString());
    }

    @Override
    protected User mapToEntity(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(Gender.valueOf((resultSet.getString("gender")).toUpperCase()));
            user.getUserData().setFirstName(resultSet.getString("first_name"));
            user.getUserData().setLastName(resultSet.getString("last_name"));
            user.getUserData().setPhoneNumber(resultSet.getString("phone_number"));
            user.getUserData().setDate_Of_Birth(resultSet.getDate("date_of_birth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}


