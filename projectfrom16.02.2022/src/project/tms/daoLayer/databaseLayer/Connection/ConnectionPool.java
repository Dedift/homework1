package project.tms.daoLayer.databaseLayer.Connection;


import project.tms.daoLayer.databaseLayer.daoException.DaoException;
import project.tms.daoLayer.entityLayer.Number;

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
    private static Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> connectionPool;

    private ConnectionPool() {
        connectionPool = new LinkedBlockingDeque<>();
        while (connectionPool.size() < Number.SIX) {
            try {
                connectionPool.offer((ProxyConnection) DriverManager.getConnection(
                        PropertiesManager.getPropertyByKey(DB_URL_KEY),
                        PropertiesManager.getPropertyByKey(DB_USERNAME_KEY),
                        PropertiesManager.getPropertyByKey(DB_PASS_KEY)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (Objects.isNull(localInstance)) {
            lock.lock();
            localInstance = instance;
            if (Objects.isNull(localInstance)) {
                instance = localInstance = new ConnectionPool();
            }
        }
        return instance;
    }

    public ProxyConnection getConnection() throws DaoException {
        try {
            return connectionPool.take();
        } catch (InterruptedException e) {
            throw new DaoException(e);
        }
    }

    public void addConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            connectionPool.offer((ProxyConnection) connection);
        }
    }

    public void destroy() throws DaoException {
        for (ProxyConnection connection : connectionPool) {
            try {
                connection.closeConnection();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    public void closeStatement(Statement anyStatement) throws DaoException {
        if (Objects.nonNull(anyStatement)) {
            try {
                anyStatement.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    public void closeConnection(Connection connection) throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void rollback(Connection anyConnection) throws DaoException {
        if (Objects.nonNull(anyConnection)) {
            try {
                anyConnection.rollback();
                anyConnection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }
}