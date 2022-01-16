package project.tms.dao;

import java.util.Objects;

public class DaoFactory {


    private DaoFactory() {
    }

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public static UserDao getUserDao() {
        return UserDao.getInstance();
    }

    public static OrderDao getOrderDao() {
        return OrderDao.getInstance();
    }

    public static SubscriptionDao getSubscriptionDao() {
        return SubscriptionDao.getInstance();
    }

    public static PersonalTrainerDao getPersonalTrainerDao() {
        return PersonalTrainerDao.getInstance();
    }

    public static TrainingDayDao getTrainingDayDao() {
        return TrainingDayDao.getInstance();
    }

    public static ReviewDao getReviewDao() {
        return ReviewDao.getInstance();
    }
}
