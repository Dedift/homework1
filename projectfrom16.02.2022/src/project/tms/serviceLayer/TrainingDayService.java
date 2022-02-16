package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.TrainingDayDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Train.TrainingDay;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TrainingDayService {

    private static TrainingDayService instance;
    private static DaoFactory daoFactory;
    private static TrainingDayDao trainingDayDao;

    private TrainingDayService() {
        daoFactory = DaoFactory.getInstance();
        trainingDayDao = daoFactory.getTrainingDayDao();
    }

    public static TrainingDayService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TrainingDayService();
        }
        return instance;
    }

    public void save(TrainingDay trainingDay) throws ServiceException {
        try {
            trainingDayDao.save(trainingDay);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<TrainingDay> findById(Integer id) throws ServiceException {
        try {
            return trainingDayDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<TrainingDay> findByUserId(Integer id) throws ServiceException {
        try {
            return trainingDayDao.findByUserId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(TrainingDay trainingDay) throws ServiceException {
        try {
            trainingDayDao.update(trainingDay);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            trainingDayDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
