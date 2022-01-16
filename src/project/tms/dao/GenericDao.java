package project.tms.dao;

import project.tms.dao.Connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> {

    private static final String STRING = "String";
    private static final String INTEGER = "Integer";

    protected List<T> findAll(String sql) {
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
            e.printStackTrace();
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected <V> List<T> findByField(String sql, V value){
        List<T> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            switch (value.getClass().getSimpleName()) {
                case INTEGER:
                    preparedStatement.setInt(1, (Integer) value);
                    break;
                case STRING:
                    preparedStatement.setString(1, (String) value);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(mapToEntity(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected int save(String sql, T item){
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        int result = -1;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mapFromEntity(preparedStatement, item);
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    result = resultSet.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
        return result;
    }

    protected <V> void deleteByField(String sql, V value){
        PreparedStatement preparedStatement = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            switch (value.getClass().getSimpleName()) {
                case INTEGER:
                    preparedStatement.setInt(1, (Integer) value);
                    break;
                case STRING:
                    preparedStatement.setString(1, (String) value);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionPool.closeStatement(preparedStatement);
            connectionPool.closeConnection(connection);
        }
    }

    protected abstract T mapToEntity(ResultSet rs) throws SQLException;

    protected abstract void mapFromEntity(PreparedStatement ps, T obj) throws SQLException;

}