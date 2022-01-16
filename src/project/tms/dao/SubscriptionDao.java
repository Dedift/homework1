package project.tms.dao;

import project.tms.entities.Order.Subscription;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SubscriptionDao extends GenericDao<Subscription> {

    private static final String SELECT_ALL_SUBSCRIPTIONS = "SELECT id, count_remaining_train, time_of_action, price " +
            "FROM gym_schema.subscription";
    private static final String SELECT_SUBSCRIPTION_BY_ID = "SELECT id, count_remaining_train, time_of_action, price " +
            "FROM gym_schema.subscription " +
            "WHERE id = (?)";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static SubscriptionDao instance;

    private SubscriptionDao() {
    }

    public static SubscriptionDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SubscriptionDao();
        }
        return instance;
    }

    public Optional<Subscription> findById(Integer id) {
        List<Subscription> subscriptions = super.findByField(SELECT_SUBSCRIPTION_BY_ID, id);
        return Optional.ofNullable(subscriptions.get(0));
    }

    public List<Subscription> findAll() {
        return super.findAll(SELECT_ALL_SUBSCRIPTIONS);
    }

    @Override
    protected Subscription mapToEntity(ResultSet resultSet) {
        Subscription result = new Subscription();
        try {
            result.setId(resultSet.getInt("id"));
            result.setPrice(resultSet.getInt("price"));
            result.setCountRemainingTrain(resultSet.getInt("count_remaining_train"));
            if (Objects.nonNull(resultSet.getDate("time_of_action"))) {
                result.setTimeOfAction(resultSet.getDate("time_of_action").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Subscription obj) throws SQLException {

    }
}