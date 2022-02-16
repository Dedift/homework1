package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.SubscriptionDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Order.Subscription;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SubscriptionService {

    private static SubscriptionService instance;
    private static DaoFactory daoFactory;
    private static SubscriptionDao subscriptionDao;

    private SubscriptionService() {
        daoFactory = DaoFactory.getInstance();
        subscriptionDao = daoFactory.getSubscriptionDao();
    }

    public static SubscriptionService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SubscriptionService();
        }
        return instance;
    }

    public void save(Subscription subscription) throws ServiceException {
        try {
            subscriptionDao.save(subscription);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Subscription> findAll() throws ServiceException {
        try {
            return subscriptionDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Subscription> findById(Integer id) throws ServiceException {
        try {
            return subscriptionDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Subscription subscription) throws ServiceException {
        try {
            subscriptionDao.update(subscription);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            subscriptionDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
