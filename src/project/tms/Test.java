package project.tms;

import project.tms.dao.DaoFactory;
import project.tms.dao.UserDao;
import project.tms.entities.User.User;

import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {

        UserDao userDao = DaoFactory.getUserDao();
        List<User> users = userDao.findAll();
        Optional<User> userDaoById = userDao.findById(1);
        if (userDaoById.isPresent()){
            User user = userDaoById.get();
            userDao.save(user);
        }
        userDao.delete(1);
        System.out.println(users);
        System.out.println(userDaoById);
    }
}
