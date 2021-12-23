package com.company.homeworks.homework15.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public final class DaoUtils {

    public static final String DB_URL_KEY = "db.url";
    public static final String DB_USERNAME_KEY = "db.username";
    public static final String DB_PASS_KEY = "db.pass";
    public static final String RESTAURANT_NAME = "restaurant_name";
    public static final String DISH_NAME = "dish_name";
    public static final String REVIEW_TEXT = "review_text";
    public static final String REVIEW_ID = "review_id";
    public static final String DISH_ID = "dish_id";
    public static final String RESTAURANT_ID = "restaurant_id";
    public static final String ID = "id";
    public static final String SQL_SAVE_DISH = "INSERT INTO restaurant_schema.dish (name) VALUES (?)";
    public static final String SQL_SELECT_DISH_WITH_THIS_NAME = "SELECT count(name), id AS dish_id " +
            "FROM restaurant_schema.dish GROUP BY id HAVING name = (?)";
    public static final String SQL_SELECT_RESTAURANT_WITH_THIS_NAME = "SELECT count(name), id AS restaurant_id " +
            "FROM restaurant_schema.restaurant " +
            "GROUP BY id HAVING name = (?)";
    public static final String SQL_SELECT_RESTAURANT_WITH_THIS_ID = "SELECT count(id), name AS restaurant_name " +
            "FROM restaurant_schema.restaurant " +
            "GROUP BY name, id HAVING id = (?)";
    public static final String SQL_SAVE_RESTAURANT = "INSERT INTO restaurant_schema.restaurant (name) VALUES (?)";
    public static final String SQL_SAVE_RESTAURANT_DISHES =
            "INSERT INTO restaurant_schema.restaurant_dishes (restaurant_id, dish_id) VALUES (?, ?)";
    public static final String SQL_SELECT_MENU = "SELECT r.name AS restaurant_name, r.id AS restaurant_id," +
            " d.name AS dish_name, d.id AS dish_id " +
            "From restaurant_schema.restaurant_dishes rd " +
            "JOIN restaurant_schema.restaurant r ON rd.restaurant_id = r.id " +
            "JOIN restaurant_schema.dish d ON rd.dish_id = d.id " +
            "WHERE r.id = (?)";
    public static final String SQL_SELECT_REVIEWS = "SELECT r.name AS restaurant_name, r.id AS restaurant_id, " +
            "rev.text AS review_text, rev.id   AS review_id " +
            "FROM restaurant_schema.restaurant r " +
            "JOIN restaurant_schema.review rev ON r.id = rev.restaurant_id " +
            "WHERE r.id = (?)";
    public static final String SQL_SAVE_REVIEW = "INSERT INTO restaurant_schema.review (text, restaurant_id) VALUES (?, ?)";

    private DaoUtils() {
        throw new UnsupportedOperationException();
    }

    public static void closeStatement(Statement anyStatement) {
        if (Objects.nonNull(anyStatement)) {
            try {
                anyStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection anyConnection) {
        if (Objects.nonNull(anyConnection)) {
            try {
                anyConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection anyConnection) {
        if (Objects.nonNull(anyConnection)) {
            try {
                anyConnection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
