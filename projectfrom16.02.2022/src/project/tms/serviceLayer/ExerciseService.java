package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.ExerciseDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Train.Exercise;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExerciseService {
    private static ExerciseService instance;
    private static DaoFactory daoFactory;
    private static ExerciseDao exerciseDao;

    private ExerciseService() {
        daoFactory = DaoFactory.getInstance();
        exerciseDao = daoFactory.getExerciseDao();
    }

    public static ExerciseService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ExerciseService();
        }
        return instance;
    }

    public void save(Exercise exercise) throws ServiceException {
        try {
            exerciseDao.save(exercise);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Exercise> findAll() throws ServiceException {
        try {
            return exerciseDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Exercise> findById(Integer id) throws ServiceException {
        try {
            return exerciseDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    public List<Exercise> findByTrainDayId(Integer id) throws ServiceException {
        try {
            return exerciseDao.findByTrainDayId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Exercise> findByName(String name) throws ServiceException {
        try {
            return exerciseDao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Exercise exercise) throws ServiceException {
        try {
            exerciseDao.update(exercise);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            exerciseDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
