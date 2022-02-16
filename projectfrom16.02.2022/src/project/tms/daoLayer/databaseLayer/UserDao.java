package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.User.Gender;
import project.tms.daoLayer.entityLayer.User.Role;
import project.tms.daoLayer.entityLayer.User.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao extends GenericDao<User> {

    public static final String WHERE_PERSONAL_TRAINER_ID = "WHERE personal_trainer_id = (?)";
    public static final String WHERE_ID = "WHERE id = (?)";
    public static final String WHERE_EMAIL = "WHERE email = (?)";
    private static final String WHERE_EMAIL_AND_PASSWORD = "WHERE email = (?) AND password = (?)";
    public static final String WHERE_FIRST_NAME = "WHERE first_name = (?)";
    public static final String WHERE_LAST_NAME = "WHERE last_name = (?)";
    public static final String WHERE_DATE_OF_BIRTH_LESS = "WHERE date_of_birth < (?)";
    public static final String WHERE_DATE_OF_BIRTH_MORE = "WHERE date_of_birth > (?)";
    public static final String WHERE_GENDER = "WHERE gender = (?)";
    public static final String WHERE_ROLE = "WHERE role = (?)";
    private static final String SAVE_USER = "INSERT INTO gym_schema.\"User\" (email, password, gender, role, first_name, last_name, phone_number, date_of_birth, bank_card) " +
            "VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?))";
    private static final String SELECT_ALL_USERS = "SELECT id, email, password, first_name, last_name, phone_number, gender, date_of_birth, role, bank_card" +
            " FROM gym_schema.\"User\"";
    private static final String SELECT_ALL_USERS_BY_TRAINER_ID = SELECT_ALL_USERS + WHERE_PERSONAL_TRAINER_ID;
    private static final String SELECT_USER_BY_ID = SELECT_ALL_USERS + WHERE_ID;
    private static final String SELECT_USER_BY_EMAIL = SELECT_ALL_USERS + WHERE_EMAIL;
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = SELECT_ALL_USERS + WHERE_EMAIL_AND_PASSWORD;
    private static final String SELECT_USERS_BY_FIRST_NAME = SELECT_ALL_USERS + WHERE_FIRST_NAME;
    private static final String SELECT_USERS_BY_LAST_NAME = SELECT_ALL_USERS + WHERE_LAST_NAME;
    private static final String SELECT_OLDER_USERS = SELECT_ALL_USERS + WHERE_DATE_OF_BIRTH_LESS;
    private static final String SELECT_YOUNGER_USERS = SELECT_ALL_USERS + WHERE_DATE_OF_BIRTH_MORE;
    private static final String SELECT_USERS_BY_GENDER = SELECT_ALL_USERS + WHERE_GENDER;
    private static final String SELECT_USERS_BY_ROLE = SELECT_ALL_USERS + WHERE_ROLE;
    private static final String UPDATE_USER = "UPDATE gym_schema.\"User\" " +
            "SET email = (?), password = (?), first_name = (?), last_name = (?), phone_number = (?), " +
            " gender = (?), date_of_birth = (?), bank_card = (?), role = (?), personal_trainer_id = (?) " +
            WHERE_ID;
    private static final String DELETE_USER_BY_ID = "DELETE FROM gym_schema.\"User\" " + WHERE_ID;
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String GENDER = "gender";
    private static final String ROLE = "role";
    private static final String DATE_OF_BIRTH = "date_of_birth";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String BANK_CARD = "bank_card";
    private static final String PASSWORD = "password";
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserDao();
        }
        return instance;
    }

    public User save(User user) throws DaoException {
        System.out.println(user);
        user.setPassword(DaoUtils.encrypt(user.getPassword()));
        int id = super.save(SAVE_USER, user);
        user.setId(id);
        return user;
    }

    public List<User> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_USERS);
    }

    public Optional<User> findById(Integer id) throws DaoException {
        Optional<User> result = Optional.empty();
        List<User> users = super.findByFields(SELECT_USER_BY_ID, id);
        if (users.size() > Number.ZERO) {
            result = Optional.of(users.get(Number.ZERO));
        }
        return result;
    }

    public Optional<User> findByEmail(String email) throws DaoException {
        Optional<User> result = Optional.empty();
        List<User> users = super.findByFields(SELECT_USER_BY_EMAIL, email);
        if (users.size() > Number.ZERO) {
            result = Optional.of(users.get(Number.ZERO));
        }
        return result;
    }

    public boolean validateUserByEmailAndPassword(String email, String password) throws DaoException {
        String encryptedPassword = DaoUtils.encrypt(password);
        boolean result = false;
        List<User> users = super.findByFields(SELECT_USER_BY_EMAIL_AND_PASSWORD, email, encryptedPassword);
        if (users.size() > Number.ZERO) {
            result = true;
        }
        return result;
    }

    public List<User> findByGender(Gender gender) throws DaoException {
        return super.findByFields(SELECT_USERS_BY_GENDER, gender.toString());
    }

    public List<User> findByRole(Role role) throws DaoException {
        return super.findByFields(SELECT_USERS_BY_ROLE, role.toString());
    }

    public List<User> findByFirstName(String firstName) throws DaoException {
        return super.findByFields(SELECT_USERS_BY_FIRST_NAME, firstName);
    }

    public List<User> findByLastName(String lastName) throws DaoException {
        return super.findByFields(SELECT_USERS_BY_LAST_NAME, lastName);
    }

    public List<User> findUsersOlderThanAge(Integer age) throws DaoException {
        LocalDate date = LocalDate.now().minusYears(age);
        return super.findByFields(SELECT_OLDER_USERS, date);
    }

    public List<User> findUsersYoungerThanAge(Integer age) throws DaoException {
        LocalDate date = LocalDate.now().minusYears(age);
        return super.findByFields(SELECT_YOUNGER_USERS, date);
    }

    public List<User> findWardsByTrainersId(Integer trainersId) throws DaoException {
        return super.findByFields(SELECT_ALL_USERS_BY_TRAINER_ID, trainersId);
    }

    public void update(User user) throws DaoException {
        user.setPassword(DaoUtils.encrypt(user.getPassword()));
        super.updateByField(UPDATE_USER, user, Number.TEN, user.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_USER_BY_ID, id);
    }

    @Override
    protected User mapToEntity(ResultSet resultSet) throws DaoException {
        User user = new User();
        try {
            user.setId(resultSet.getInt(ID));
            user.setEmail(resultSet.getString(EMAIL));
            user.setGender(resultSet.getString(GENDER));
            user.setRole(resultSet.getString(ROLE));
            if (Objects.nonNull(resultSet.getDate(DATE_OF_BIRTH))){
                user.setDateOfBirth(resultSet.getDate(DATE_OF_BIRTH).toLocalDate());
            } else {
                user.setDateOfBirth(null);
            }
            user.getUserData().setFirstName(resultSet.getString(FIRST_NAME));
            user.getUserData().setLastName(resultSet.getString(LAST_NAME));
            user.getUserData().setPhoneNumber(resultSet.getString(PHONE_NUMBER));
            user.getUserData().setBankCard(resultSet.getString(BANK_CARD));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, User user) throws DaoException {
        try {
            ps.setString(Number.ONE, user.getEmail());
            ps.setString(Number.TWO, user.getPassword());
            ps.setString(Number.THREE, user.getGender());
            ps.setString(Number.FOUR, user.getRole());
            ps.setString(Number.FIVE, user.getUserData().getFirstName());
            ps.setString(Number.SIX, user.getUserData().getLastName());
            ps.setString(Number.SEVEN, user.getUserData().getPhoneNumber());
            if (Objects.nonNull(user.getDateOfBirth())) {
                ps.setDate(Number.EIGHT, Date.valueOf(user.getDateOfBirth()));
            } else {
                ps.setDate(Number.EIGHT, null);
            }
            ps.setString(Number.NINE, user.getUserData().getBankCard());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}


