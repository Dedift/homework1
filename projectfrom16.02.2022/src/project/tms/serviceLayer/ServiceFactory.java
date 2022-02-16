package project.tms.serviceLayer;

import java.util.Objects;

public class ServiceFactory {

    private ServiceFactory() {
    }

    private static ServiceFactory instance;

    public static ServiceFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public UserService getUserService() {
        return UserService.getInstance();
    }

    public OrderService getOrderService() {
        return OrderService.getInstance();
    }

    public SubscriptionService getSubscriptionService() {
        return SubscriptionService.getInstance();
    }

    public PersonalTrainerService getPersonalTrainerService() {
        return PersonalTrainerService.getInstance();
    }

    public TrainingDayService getTrainingDayService() {
        return TrainingDayService.getInstance();
    }

    public ReviewService getReviewService() {
        return ReviewService.getInstance();
    }
}
