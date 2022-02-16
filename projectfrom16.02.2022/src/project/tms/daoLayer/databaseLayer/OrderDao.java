package project.tms.daoLayer.databaseLayer;

import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;
import project.tms.daoLayer.entityLayer.Order.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderDao extends GenericDao<Order> {

    public static final String WHERE_ID = "WHERE id = (?)";
    public static final String WHERE_SEASON = "WHERE season = (?)";
    public static final String WHERE_PURPOSE = "WHERE purpose = (?)";
    public static final String WHERE_COUNT_TRAIN_MORE = "WHERE count_train > (?)";
    public static final String WHERE_COUNT_TRAIN_LESS = "WHERE count_train < (?)";
    private static final String SAVE_ORDER = "INSERT INTO gym_schema.\"Order\" (purpose, season, count_train, price, user_id) " +
            "VALUES ((?), (?), (?), (?), (?))";
    private static final String SELECT_ALL_ORDERS = "SELECT id, purpose, season, count_train, price FROM gym_schema.\"Order\"";
    private static final String SELECT_ORDER_BY_ID = SELECT_ALL_ORDERS + WHERE_ID;
    private static final String SELECT_ORDERS_BY_SEASON = SELECT_ALL_ORDERS + WHERE_SEASON;
    private static final String SELECT_ORDERS_BY_PURPOSE = SELECT_ALL_ORDERS + WHERE_PURPOSE;
    private static final String SELECT_ORDERS_WHERE_COUNT_TRAIN_MORE = SELECT_ALL_ORDERS + WHERE_COUNT_TRAIN_MORE;
    private static final String SELECT_ORDERS_WHERE_COUNT_TRAIN_LESS = SELECT_ALL_ORDERS + WHERE_COUNT_TRAIN_LESS;
    private static final String UPDATE_ORDER = "UPDATE gym_schema.\"Order\" " +
            "SET purpose = (?), season = (?), count_train = (?), price = (?) " + WHERE_ID;
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM gym_schema.\"Order\"" + WHERE_ID;
    private static final String ID = "id";
    private static final String PURPOSE = "purpose";
    private static final String COUNT_TRAIN = "count_train";
    private static final String SEASON = "season";
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static OrderDao instance;

    private OrderDao() {
    }

    public static OrderDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OrderDao();
        }
        return instance;
    }

    public Order save(Order order) throws DaoException {
        int id = super.save(SAVE_ORDER, order);
        order.setId(id);
        return order;
    }

    public List<Order> findAll() throws DaoException {
        return super.findAll(SELECT_ALL_ORDERS);
    }

    public Optional<Order> findById(Integer id) throws DaoException {
        Optional<Order> result = Optional.empty();
        List<Order> orders = super.findByFields(SELECT_ORDER_BY_ID, id);
        if (orders.size() > Number.ZERO) {
            result = Optional.of(orders.get(Number.ZERO));
        }
        return result;
    }

    public List<Order> findBySeason(String season) throws DaoException {
        return super.findByFields(SELECT_ORDERS_BY_SEASON, season);
    }

    public List<Order> findByPurpose(String purpose) throws DaoException {
        return super.findByFields(SELECT_ORDERS_BY_PURPOSE, purpose);
    }

    public List<Order> findOrdersWhereCountTrainMore(Integer countTrain) throws DaoException {
        return super.findByFields(SELECT_ORDERS_WHERE_COUNT_TRAIN_MORE, countTrain);
    }

    public List<Order> findOrdersWhereCountTrainLess(Integer countTrain) throws DaoException {
        return super.findByFields(SELECT_ORDERS_WHERE_COUNT_TRAIN_LESS, countTrain);
    }

    public void update(Order order) throws DaoException {
        super.updateByField(UPDATE_ORDER, order, Number.SIX, order.getId());
    }

    public void delete(int id) throws DaoException {
        super.deleteByField(DELETE_ORDER_BY_ID, id);
    }

    @Override
    protected Order mapToEntity(ResultSet resultSet) throws DaoException {
        Order result = new Order();
        try {
            result.setId(resultSet.getInt(ID));
            result.setPurpose(resultSet.getString(PURPOSE));
            if (resultSet.getInt(COUNT_TRAIN) > Number.ZERO) {
                result.setCountTrain(resultSet.getInt(COUNT_TRAIN));
            } else {
                result.setSeason(resultSet.getString(SEASON));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Order order) throws DaoException {
        try {
            ps.setString(Number.ONE, order.getPurpose());
            if (Objects.nonNull(order.getSeason())) {
                ps.setString(Number.TWO, order.getSeason());
            }
            ps.setInt(Number.THREE, order.getCountTrain());
            ps.setInt(Number.FOUR, order.getPrice());
            ps.setInt(Number.FIVE, order.getUser().getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}