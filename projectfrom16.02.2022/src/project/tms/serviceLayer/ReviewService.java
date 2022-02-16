package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.ReviewDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.User.Review;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReviewService {

    private static ReviewService instance;
    private static DaoFactory daoFactory;
    private static ReviewDao reviewDao;

    private ReviewService() {
        daoFactory = DaoFactory.getInstance();
        reviewDao = daoFactory.getReviewDao();
    }

    public static ReviewService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ReviewService();
        }
        return instance;
    }

    public void save(Review review) throws ServiceException {
        try {
            reviewDao.save(review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Review> findAll() throws ServiceException {
        try {
            return reviewDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Review> findById(Integer id) throws ServiceException {
        try {
            return reviewDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Review review) throws ServiceException {
        try {
            reviewDao.update(review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            reviewDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
