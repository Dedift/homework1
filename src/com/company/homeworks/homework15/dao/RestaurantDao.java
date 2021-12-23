package com.company.homeworks.homework15.dao;

import com.company.homeworks.homework15.JDBC.PropertiesManager;
import com.company.homeworks.homework15.entities.Dish;
import com.company.homeworks.homework15.entities.Restaurant;
import com.company.homeworks.homework15.entities.Review;

import java.sql.*;
import java.util.*;

public final class RestaurantDao {

    private RestaurantDao() {
        throw new UnsupportedOperationException();
    }

    public static Restaurant saveRestaurant(Restaurant restaurant) {
        Connection connection = null;
        PreparedStatement restaurantStatement = null;
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            restaurantStatement = connection.prepareStatement(DaoUtils.SQL_SELECT_RESTAURANT_WITH_THIS_NAME);
            restaurantStatement.setString(1, restaurant.getName());
            ResultSet restaurantResultSet = restaurantStatement.executeQuery();
            if (restaurantResultSet.next()) {
                restaurant.setId(restaurantResultSet.getInt(DaoUtils.RESTAURANT_ID));
            } else {
                restaurantStatement = connection.prepareStatement(DaoUtils.SQL_SAVE_RESTAURANT, PreparedStatement.RETURN_GENERATED_KEYS);
                restaurantStatement.setString(1, restaurant.getName());
                restaurantStatement.executeUpdate();
                ResultSet generatedKeys = restaurantStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    restaurant.setId(generatedKeys.getInt(DaoUtils.ID));
                }
            }
            connection.commit();
        } catch (SQLException throwables) {
            DaoUtils.rollback(connection);
        } finally {
            DaoUtils.closeStatement(restaurantStatement);
            DaoUtils.closeConnection(connection);
        }
        return restaurant;
    }

    public static Restaurant saveDishOnRestaurant(Restaurant restaurant, Dish dish) {
        Connection connection = null;
        PreparedStatement restaurantStatement = null;
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Dish savedDish = DishDao.saveDish(dish);
            restaurant = RestaurantDao.saveRestaurant(restaurant);
            restaurantStatement = connection.prepareStatement(DaoUtils.SQL_SAVE_RESTAURANT_DISHES);
            restaurantStatement.setInt(1, restaurant.getId());
            restaurantStatement.setInt(2, savedDish.getId());
            restaurantStatement.executeUpdate();
            restaurant.getMenu().add(savedDish);
            connection.commit();
        } catch (SQLException throwables) {
            DaoUtils.rollback(connection);
        } finally {
            DaoUtils.closeStatement(restaurantStatement);
            DaoUtils.closeConnection(connection);
        }
        return restaurant;
    }

    public static Optional<Restaurant> getRestaurantWithMenuAndReviews(int id) {
        Connection connection = null;
        PreparedStatement restaurantStatement = null;
        Optional<Restaurant> result = Optional.empty();
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            restaurantStatement = connection.prepareStatement(DaoUtils.SQL_SELECT_RESTAURANT_WITH_THIS_ID);
            restaurantStatement.setInt(1, id);
            ResultSet restaurantResultSet = restaurantStatement.executeQuery();
            if (restaurantResultSet.next()) {
                Optional<Set<Dish>> menu = getMenu(id);
                Optional<List<Review>> reviews = getReviews(id);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(id);
                restaurant.setName(restaurantResultSet.getString(DaoUtils.RESTAURANT_NAME));
                if (reviews.isPresent()) {
                    List<Review> reviews1 = reviews.get();
                    restaurant.getReviews().addAll(reviews1);
                }
                if (menu.isPresent()) {
                    Set<Dish> dishes = menu.get();
                    restaurant.getMenu().addAll(dishes);
                }
                result = Optional.of(restaurant);
            }
            connection.commit();
        } catch (SQLException throwables) {
            DaoUtils.rollback(connection);
        } finally {
            DaoUtils.closeConnection(connection);
        }
        return result;
    }

    public static Optional<Set<Dish>> getMenu(int restaurant_id) {
        Connection connection = null;
        PreparedStatement dishStatement = null;
        Optional<Set<Dish>> result = Optional.empty();
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            dishStatement = connection.prepareStatement(DaoUtils.SQL_SELECT_MENU);
            dishStatement.setInt(1, restaurant_id);
            ResultSet resultSet = dishStatement.executeQuery();
            Set<Dish> dishes = new HashSet<>();
            while (resultSet.next()) {
                Dish dish = new Dish(resultSet.getString(DaoUtils.DISH_NAME));
                dish.setId(resultSet.getInt(DaoUtils.DISH_ID));
                dishes.add(dish);
            }
            result = Optional.ofNullable(dishes);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtils.closeStatement(dishStatement);
            DaoUtils.closeConnection(connection);
        }
        return result;
    }

    public static Optional<List<Review>> getReviews(int restaurant_id) {
        Connection connection = null;
        PreparedStatement reviewStatement = null;
        Optional<List<Review>> result = Optional.empty();
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            reviewStatement = connection.prepareStatement(DaoUtils.SQL_SELECT_REVIEWS);
            reviewStatement.setInt(1, restaurant_id);
            ResultSet resultSet = reviewStatement.executeQuery();
            List<Review> reviews = new LinkedList<>();
            Restaurant restaurant = new Restaurant();
            while (resultSet.next()) {
                restaurant.setName(resultSet.getString(DaoUtils.RESTAURANT_NAME));
                restaurant.setId(resultSet.getInt(DaoUtils.RESTAURANT_ID));
                Review review = new Review(resultSet.getString(DaoUtils.REVIEW_TEXT), restaurant);
                review.setId(resultSet.getInt(DaoUtils.REVIEW_ID));
                reviews.add(review);
            }
            result = Optional.ofNullable(reviews);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtils.closeStatement(reviewStatement);
            DaoUtils.closeConnection(connection);
        }
        return result;
    }
}