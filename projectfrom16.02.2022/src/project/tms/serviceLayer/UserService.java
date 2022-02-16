package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.UserDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.User.Gender;
import project.tms.daoLayer.entityLayer.User.Role;
import project.tms.daoLayer.entityLayer.User.User;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserService {

    private static UserService instance;
    private static DaoFactory daoFactory;
    private static UserDao userDao;

    private UserService() {
        daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.getUserDao();
    }

    public static UserService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserService();
        }
        return instance;
    }

    public void save(User user) throws DaoException {
        userDao.save(user);
    }

    public List<User> findAll() throws DaoException {
        return userDao.findAll();
    }

    public Optional<User> findById(Integer id) throws ServiceException {
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> findByEmail(String email) throws ServiceException {
        try {
            return userDao.findByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean validateUserByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            return userDao.validateUserByEmailAndPassword(email, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findByGender(Gender gender) throws ServiceException {
        try {
            return userDao.findByGender(gender);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findByRole(Role role) throws ServiceException {
        try {
            return userDao.findByRole(role);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findByFirstName(String firstName) throws ServiceException {
        try {
            return userDao.findByFirstName(firstName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findByLastName(String lastName) throws ServiceException {
        try {
            return userDao.findByLastName(lastName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findUsersOlderThanAge(Integer age) throws ServiceException {
        try {
            return userDao.findUsersOlderThanAge(age);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findUsersYoungerThanAge(Integer age) throws ServiceException {
        try {
            return userDao.findUsersYoungerThanAge(age);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findWardsByTrainersId(Integer trainersId) throws ServiceException {
        try {
            return userDao.findWardsByTrainersId(trainersId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(User user) throws ServiceException {
        try {
            userDao.update(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            userDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
