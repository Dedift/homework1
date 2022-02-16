package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.Order.Subscription;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SubscriptionDao extends GenericDao<Subscription> {

    public static final String WHERE_ID = "WHERE id = (?)";
    private static final String SAVE_SUBSCRIPTION = "INSERT INTO gym_schema.subscription (count_remaining_train, time_of_action, user_id) " +
            "VALUES ((?), (?))";
    private static final String SELECT_ALL_SUBSCRIPTIONS = "SELECT id, count_remaining_train, time_of_action " +
            "FROM gym_schema.subscription";
    private static final String SELECT_SUBSCRIPTION_BY_ID = SELECT_ALL_SUBSCRIPTIONS +
            WHERE_ID;
    private static final String UPDATE_SUBSCRIPTION = "UPDATE gym_schema.subscription " +
            "SET count_remaining_train = (?), time_of_action = (?), user_id = (?)" +
            WHERE_ID;
    private static final String DELETE_SUBSCRIPTION_BY_ID = "DELETE FROM gym_schema.subscription" +
            WHERE_ID;
    private static final String ID = "id";
    private static final String COUNT_REMAINING_TRAIN = "count_remaining_train";
    private static final String TIME_OF_ACTION = "time_of_action";
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

    public Subscription save(Subscription subscription) throws DaoException {
        int id = super.save(SAVE_SUBSCRIPTION, subscription);
        subscription.setId(id);
        return subscription;
    }

    public List<Subscription> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_SUBSCRIPTIONS);
    }

    public Optional<Subscription> findById(Integer id) throws DaoException {
        List<Subscription> subscriptions = super.findByFields(SELECT_SUBSCRIPTION_BY_ID, id);
        return Optional.ofNullable(subscriptions.get(Number.ZERO));
    }

    public void update(Subscription subscription) throws DaoException {
        super.updateByField(UPDATE_SUBSCRIPTION, subscription, Number.FOUR, subscription.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_SUBSCRIPTION_BY_ID, id);
    }

    @Override
    protected Subscription mapToEntity(ResultSet resultSet) throws DaoException {
        Subscription result = new Subscription();
        try {
            result.setId(resultSet.getInt(ID));
            result.setCountRemainingTrain(resultSet.getInt(COUNT_REMAINING_TRAIN));
            if (Objects.nonNull(resultSet.getDate(TIME_OF_ACTION))) {
                result.setTimeOfAction(resultSet.getDate(TIME_OF_ACTION).toLocalDate());
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Subscription subscription) throws DaoException {
        try {
            ps.setInt(Number.ONE, subscription.getCountRemainingTrain());
            ps.setDate(Number.TWO, Date.valueOf(subscription.getTimeOfAction()));
            ps.setInt(Number.THREE, subscription.getUser().getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}