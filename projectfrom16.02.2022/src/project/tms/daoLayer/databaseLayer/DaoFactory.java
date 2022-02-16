package project.tms.daoLayer.databaseLayer;

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

    public UserDao getUserDao() {
        return UserDao.getInstance();
    }

    public OrderDao getOrderDao() {
        return OrderDao.getInstance();
    }

    public SubscriptionDao getSubscriptionDao() {
        return SubscriptionDao.getInstance();
    }

    public PersonalTrainerDao getPersonalTrainerDao() {
        return PersonalTrainerDao.getInstance();
    }

    public TrainingDayDao getTrainingDayDao() {
        return TrainingDayDao.getInstance();
    }

    public ReviewDao getReviewDao() {
        return ReviewDao.getInstance();
    }

    public ExerciseDao getExerciseDao(){
        return ExerciseDao.getInstance();
    }
}
