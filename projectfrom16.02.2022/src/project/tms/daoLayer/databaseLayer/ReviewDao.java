package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.User.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReviewDao extends GenericDao<Review> {

    public static final String WHERE_ID = "WHERE id = (?)";
    private static final String SAVE_REVIEW = "INSERT INTO gym_schema.review (text, user_id) " +
            "VALUES ((?), (?))";
    private static final String SELECT_ALL_REVIEWS = "SELECT id, text FROM gym_schema.review";
    private static final String SELECT_REVIEW_BY_ID = SELECT_ALL_REVIEWS + WHERE_ID;
    private static final String UPDATE_REVIEW = "UPDATE gym_schema.review " +
            "SET text = (?)" + WHERE_ID;
    private static final String DELETE_REVIEW_BY_ID = "DELETE FROM gym_schema.review WHERE id = (?)";
    private static final String TEXT = "text";
    private static final String ID = "id";
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

    public Review save(Review review) throws DaoException {
        int id = super.save(SAVE_REVIEW, review);
        review.setId(id);
        return review;
    }

    public List<Review> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_REVIEWS);
    }

    public Optional<Review> findById(Integer id) throws DaoException {
        List<Review> reviews = super.findByFields(SELECT_REVIEW_BY_ID, id);
        return Optional.ofNullable(reviews.get(Number.ZERO));
    }

    public void update(Review review) throws DaoException {
        super.updateByField(UPDATE_REVIEW, review, Number.THREE, review.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_REVIEW_BY_ID, id);
    }

    @Override
    protected Review mapToEntity(ResultSet resultSet) throws DaoException {
        Review result = new Review();
        try {
            result.setText(resultSet.getString(TEXT));
            result.setId(resultSet.getInt(ID));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Review review) throws DaoException {
        try {
            ps.setString(Number.ONE, review.getText());
            ps.setInt(Number.TWO, review.getUser().getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}