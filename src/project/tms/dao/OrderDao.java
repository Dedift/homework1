package project.tms.dao;

import project.tms.entities.Order.Order;
import project.tms.entities.Order.Season;
import project.tms.entities.Train.Purpose;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderDao extends GenericDao<Order> {

    private static final String SELECT_ALL_ORDERS = "SELECT id, purpose, season, count_train FROM gym_schema.\"Order\"";
    private static final String SELECT_ORDER_BY_ID = "SELECT id, purpose, season, count_train " +
            "FROM gym_schema.\"Order\" " +
            "WHERE id = (?)";
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

    public Optional<Order> findById(Integer id) {
        List<Order> orders = super.findByField(SELECT_ORDER_BY_ID, id);
        return Optional.ofNullable(orders.get(0));
    }

    public List<Order> findAll() {
        return super.findAll(SELECT_ALL_ORDERS);
    }

    @Override
    protected Order mapToEntity(ResultSet resultSet) {
        Order result = new Order();
        try {
            result.setId(resultSet.getInt("id"));
            result.setPurpose(Purpose.valueOf((resultSet.getString("purpose")).toUpperCase()));
            if (resultSet.getInt("count_train") > 0) {
                result.setCountTrain(resultSet.getInt("count_train"));
            } else {
                result.setSeason(Season.valueOf((resultSet.getString("season")).toUpperCase()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void mapFromEntity(PreparedStatement ps, Order obj) throws SQLException {

    }
}