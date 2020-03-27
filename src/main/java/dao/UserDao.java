package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public /*abstract*/ class UserDao {
//    private SimpleConnectionMaker simpleConnectionMaker;
//
//    public UserDao(SimpleConnectionMaker simpleConnectionMaker){
//        this.simpleConnectionMaker = simpleConnectionMaker;
//    }

    private ConnectionMaker connectionMaker;

    private static UserDao INSTANCE;

//    public UserDao(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }

    private UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public static synchronized UserDao getInstance(ConnectionMaker connectionMaker) {
        if (INSTANCE == null) {
            INSTANCE = new UserDao(connectionMaker); // connectionMaker 을 넣어줄 수 없음.
        }
        return INSTANCE;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
//        Connection connection = simpleConnectionMaker.makeNewConnection();
        Connection connection = connectionMaker.makeConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");

        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
//        Connection connection = simpleConnectionMaker.makeNewConnection();
        Connection connection = connectionMaker.makeConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from users where id = ?");

        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

//    protected abstract Connection getConnection() throws SQLException, ClassNotFoundException;

}