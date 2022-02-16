package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.Connection.ConnectionPool;
import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> {

    private static final String INTEGER = "Integer";
    private static final String STRING = "String";
    private static final String LOCAL_DATE = "LocalDate";
    private static final String ID = "id";

    protected int save(String sql, T entity) throws DaoException {
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        int result = -Number.ONE ;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mapFromEntity(preparedStatement, entity);
            if (preparedStatement.executeUpdate() > Number.ZERO) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    result = resultSet.getInt(ID);
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected List<T> findAll(String sql) throws DaoException {
        List<T> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected <V> List<T> findByFields(String sql, V... values) throws DaoException {
        List<T> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= values.length; i++) {
                V value = values[i-1];
                switch (value.getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i, (Integer) value);
                        break;
                    case STRING:
                        preparedStatement.setString(i, (String) value);
                        break;
                    case LOCAL_DATE:
                        preparedStatement.setDate(i, Date.valueOf((LocalDate) value));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(mapToEntity(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected <V> void updateByField(String sql, T entity, int parameterIndex, V value) throws DaoException {
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            switch (value.getClass().getSimpleName()) {
                case INTEGER:
                    preparedStatement.setInt(parameterIndex, (Integer) value);
                    break;
                case STRING:
                    preparedStatement.setString(parameterIndex, (String) value);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            mapFromEntity(preparedStatement, entity);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
    }

    protected <V> void deleteByField(String sql, V value) throws DaoException {
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            switch (value.getClass().getSimpleName()) {
                case INTEGER:
                    preparedStatement.setInt(Number.ONE, (Integer) value);
                    break;
                case STRING:
                    preparedStatement.setString(Number.ONE, (String) value);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
    }

    protected abstract T mapToEntity(ResultSet rs) throws DaoException;

    protected abstract void mapFromEntity(PreparedStatement ps, T entity) throws DaoException;
}