package project.tms.serviceLayer;

import project.tms.daoLayer.databaseLayer.DaoFactory;
import project.tms.daoLayer.databaseLayer.PersonalTrainerDao;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Train.PersonalTrainer;
import project.tms.serviceLayer.ServiceException.ServiceException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PersonalTrainerService {

    private static PersonalTrainerService instance;
    private static DaoFactory daoFactory;
    private static PersonalTrainerDao personalTrainerDao;

    private PersonalTrainerService() {
        daoFactory = DaoFactory.getInstance();
        personalTrainerDao = daoFactory.getPersonalTrainerDao();
    }

    public static PersonalTrainerService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PersonalTrainerService();
        }
        return instance;
    }

    public void save(PersonalTrainer personalTrainer) throws ServiceException {
        try {
            personalTrainerDao.save(personalTrainer);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findAll() throws ServiceException {
        try {
            return personalTrainerDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<PersonalTrainer> findById(Integer id) throws ServiceException {
        try {
            return personalTrainerDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findByFirstName(String firstName) throws ServiceException {
        try {
            return personalTrainerDao.findByFirstName(firstName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findByLastName(String lastName) throws ServiceException {
        try {
            return personalTrainerDao.findByLastName(lastName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findByGender(String gender) throws ServiceException {
        try {
            return personalTrainerDao.findByGender(gender);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findPersonalTrainersOlderThanAge(Integer age) throws ServiceException {
        try {
            return personalTrainerDao.findPersonalTrainersOlderThanAge(age);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findPersonalTrainersYoungerThanAge(Integer age) throws ServiceException {
        try {
            return personalTrainerDao.findPersonalTrainersYoungerThanAge(age);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<PersonalTrainer> findExperienceMore(Integer experience) throws ServiceException {
        try {
            return personalTrainerDao.findExperienceMore(experience);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(PersonalTrainer personalTrainer) throws ServiceException {
        try {
            personalTrainerDao.update(personalTrainer);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            personalTrainerDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
