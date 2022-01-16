package project.tms.dao;//package by.by.tms.dao;


import project.tms.entities.Train.TrainingDay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class TrainingDayDao extends GenericDao<TrainingDay> {

    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static TrainingDayDao instance;

    private TrainingDayDao() {
    }

    public static TrainingDayDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TrainingDayDao();
        }
        return instance;
    }

    @Override
    protected TrainingDay mapToEntity(ResultSet rs){
        return null;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, TrainingDay obj){

    }
}