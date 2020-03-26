package dao;

import java.sql.*;

public /*abstract*/ class UserDao {
//    private SimpleConnectionMaker simpleConnectionMaker;
//
//    public UserDao(SimpleConnectionMaker simpleConnectionMaker){
//        this.simpleConnectionMaker = simpleConnectionMaker;
//    }

    private ConnectionMaker connectionMaker;

    public UserDao(){
        connectionMaker = new DConnectionMaker();
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