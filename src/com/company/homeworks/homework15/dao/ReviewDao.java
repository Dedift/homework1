package com.company.homeworks.homework15.dao;

import com.company.homeworks.homework15.JDBC.PropertiesManager;
import com.company.homeworks.homework15.entities.Review;

import java.sql.*;

public final class ReviewDao {

    private ReviewDao() {
        throw new UnsupportedOperationException();
    }

    public static Review saveReview(Review review) {
        Connection connection = null;
        PreparedStatement reviewStatement = null;
        try {
            connection = DriverManager.getConnection(
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_URL_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_USERNAME_KEY),
                    PropertiesManager.getPropertyByKey(DaoUtils.DB_PASS_KEY));
            reviewStatement = connection.prepareStatement(DaoUtils.SQL_SAVE_REVIEW, PreparedStatement.RETURN_GENERATED_KEYS);
            reviewStatement.setString(1, review.getText());
            reviewStatement.setInt(2, review.getRestaurant().getId());
            reviewStatement.executeUpdate();
            ResultSet generatedKeys = reviewStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                review.setId(generatedKeys.getInt(DaoUtils.ID));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtils.closeConnection(connection);
            DaoUtils.closeStatement(reviewStatement);
        }
        return review;
    }
}
