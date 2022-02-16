package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.OrderDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Order.Order;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderService {

    private static OrderService instance;
    private static DaoFactory daoFactory = DaoFactory.getInstance();;
    private static OrderDao orderDao = daoFactory.getOrderDao();

    private OrderService() {
        daoFactory = DaoFactory.getInstance();
        orderDao = daoFactory.getOrderDao();
    }

    public static OrderService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OrderService();
        }
        return instance;
    }

    public void save(Order order) throws ServiceException {
        try {
            orderDao.save(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> findAll() throws ServiceException {
        try {
            return orderDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Order> findById(Integer id) throws ServiceException {
        try {
            return orderDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> findBySeason(String seasons) throws ServiceException {
        try {
            return orderDao.findBySeason(seasons);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> findByPurpose(String purpose) throws ServiceException {
        try {
            return orderDao.findByPurpose(purpose);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> findOrdersWhereCountTrainMore(Integer countTrain) throws ServiceException {
        try {
            return orderDao.findOrdersWhereCountTrainMore(countTrain);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> findOrdersWhereCountTrainLess(Integer countTrain) throws ServiceException {
        try {
            return orderDao.findOrdersWhereCountTrainLess(countTrain);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Order order) throws ServiceException {
        try {
            orderDao.update(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            orderDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


}
