package com.company.homeworks.homework15.dao;

import com.company.homeworks.homework15.JDBC.PropertiesManager;
import com.company.homeworks.homework15.entities.Dish;

import java.sql.*;

public final class DishDao {

    private DishDao() {
        throw new UnsupportedOperationException();
    }

    public static Dish saveDish(Dish dish) {
        Connection connection = null;
        PreparedStatement dishStatement = null;
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            dishStatement = connection.prepareStatement(DaoUtils.SQL_SELECT_DISH_WITH_THIS_NAME);
            dishStatement.setString(1, dish.getName());
            ResultSet dishResultSet = dishStatement.executeQuery();
            if (dishResultSet.next()) {
                dish.setId(dishResultSet.getInt(DaoUtils.DISH_ID));
            } else {
                dishStatement = connection.prepareStatement(DaoUtils.SQL_SAVE_DISH, PreparedStatement.RETURN_GENERATED_KEYS);
                dishStatement.setString(1, dish.getName());
                dishStatement.executeUpdate();
                ResultSet dishGeneratedKeys = dishStatement.getGeneratedKeys();
                if (dishGeneratedKeys.next()) {
                    dish.setId(dishGeneratedKeys.getInt(DaoUtils.ID));
                }
            }
            connection.commit();
        } catch (SQLException throwables) {
            DaoUtils.rollback(connection);
        } finally {
            DaoUtils.closeStatement(dishStatement);
            DaoUtils.closeConnection(connection);
        }
        return dish;
    }
}
