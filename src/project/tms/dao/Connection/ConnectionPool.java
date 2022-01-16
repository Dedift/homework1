package project.tms.dao.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    public static final String DB_URL_KEY = "db.url";
    public static final String DB_USERNAME_KEY = "db.username";
    public static final String DB_PASS_KEY = "db.pass";
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static final int SIX_CONNECTIONS = 6;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionPool;

    private ConnectionPool() {
        connectionPool = new LinkedBlockingDeque<>();
        try {
            while (connectionPool.size() < SIX_CONNECTIONS) {
                connectionPool.add(DriverManager.getConnection(
                        PropertiesManager.getPropertyByKey(DB_URL_KEY),
                        PropertiesManager.getPropertyByKey(DB_USERNAME_KEY),
                        PropertiesManager.getPropertyByKey(DB_PASS_KEY)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        lock.lock();
        if (connectionPool.size() == 0) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
        return connectionPool.poll();
    }

    public void closeConnection(Connection connection) {
        lock.lock();
        if (Objects.nonNull(connection)) {
            connectionPool.add(connection);
        }
        condition.signalAll();
        lock.unlock();
    }

    public void closeStatement(Statement anyStatement) {
        if (Objects.nonNull(anyStatement)) {
            try {
                anyStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}