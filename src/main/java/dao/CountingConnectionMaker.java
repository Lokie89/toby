package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {

    private ConnectionMaker connectionMaker;
    private int count;

    public CountingConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        count++;
        return connectionMaker.makeConnection();
    }

    public int getCount() {
        return count;
    }

}
