package project.tms.dao;

import project.tms.entities.User.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReviewDao extends GenericDao<Review> {

    private static final String SELECT_ALL_REVIEWS = "SELECT id, text FROM gym_schema.review";
    private static final String SELECT_REVIEW_BY_ID = "SELECT id, text " +
            "FROM gym_schema.review " +
            "WHERE id = (?)";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static ReviewDao instance;

    private ReviewDao() {
    }

    public static ReviewDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ReviewDao();
        }
        return instance;
    }

    public Optional<Review> findById(Integer id) {
        List<Review> reviews = super.findByField(SELECT_REVIEW_BY_ID, id);
        return Optional.ofNullable(reviews.get(0));
    }

    public List<Review> findAll() {
        return super.findAll(SELECT_ALL_REVIEWS);
    }

    @Override
    protected Review mapToEntity(ResultSet resultSet) {
        Review result = new Review();
        try {
            result.setText(resultSet.getString("text"));
            result.setId(resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Review obj) throws SQLException {

    }
}