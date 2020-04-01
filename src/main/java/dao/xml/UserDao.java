package dao.xml;

import dao.User;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private DataSource dataSource;
    private ConnectionMaker connectionMaker;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException {
//        Connection connection = simpleConnectionMaker.makeNewConnection();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");

        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public User get(String id) throws SQLException {
//        Connection connection = simpleConnectionMaker.makeNewConnection();
//        Connection connection = connectionMaker.makeConnection();
        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from users where id = ?");

        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;

        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (user == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return user;
    }

//    public void deleteAll() throws SQLException {
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("delete from users");
//
//        preparedStatement.executeUpdate();
//
//        preparedStatement.close();
//        connection.close();
//    }

    public void deleteAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

//            preparedStatement =
//                    connection.prepareStatement("delete from users");
            StatementStrategy statementStrategy = new DeleteAllStatement();
            preparedStatement = statementStrategy.makePreparedStatement(connection);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

//    public int getCount() throws SQLException {
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("select count(id) from users");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        int count = resultSet.getInt(1);
//
//        preparedStatement.close();
//        connection.close();
//        return count;
//    }

    public int getCount() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement =
                    connection.prepareStatement("select count(id) from users");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {

                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

//    protected abstract Connection getConnection() throws SQLException, ClassNotFoundException;


}