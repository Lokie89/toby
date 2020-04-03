package dao.xml;

import com.mysql.jdbc.MysqlErrorNumbers;
import dao.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userMapper =
            new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            };


//    private DataSource dataSource;
//    private ConnectionMaker connectionMaker;

    private JdbcContext jdbcContext;

//    public void setJdbcContext(JdbcContext jdbcContext) {
//        this.jdbcContext = jdbcContext;
//    }

    public void setDataSource(DataSource dataSource) {
//        this.jdbcContext = new JdbcContext();
//        this.jdbcContext.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.dataSource = dataSource;
    }

//    public void setConnectionMaker(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }

//    public void add(User user) throws SQLException {
////        Connection connection = simpleConnectionMaker.makeNewConnection();
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
//
//        preparedStatement.setString(1, user.getId());
//        preparedStatement.setString(2, user.getName());
//        preparedStatement.setString(3, user.getPassword());
//
//        preparedStatement.execute();
//        preparedStatement.close();
//        connection.close();
//    }

//    public void add(User user) throws SQLException {
//        StatementStrategy stmt = new AddStatement(user);
//        jdbcContext.workWithStatementStrategy(stmt);
//    }

//    public void add(User user) /*throws SQLException*/ {
////        this.jdbcContext.executeSql(user,"insert into users(id, name, password) values(?, ?, ?)");
//        this.jdbcTemplate.update("insert into users(id, name, password) values(?, ?, ?)",
//                user.getId(), user.getName(), user.getPassword());
//    }

//    public void add(User user) throws DuplicateUserIdException {
//        try {
//            this.jdbcContext.executeSql(user, "insert into users(id, name, password) values(?, ?, ?)");
//        } catch (SQLException e) {
//            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
//                throw new DuplicateUserIdException(e); // 예외 전환
//            } else {
//                throw new RuntimeException(e); // 예외 포장
//            }
//        }
//    }

    public void add(User user) throws DuplicateUserIdException {
        try {
            this.jdbcContext.executeSql(user, "insert into users(id, name, password) values(?, ?, ?)");
        } catch (SQLException e) {
            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
                throw new DuplicateUserIdException(e); // 예외 전환
            } else {
                throw new RuntimeException(e); // 예외 포장
            }
        }
    }

//    public User get(String id) throws SQLException {
////        Connection connection = simpleConnectionMaker.makeNewConnection();
////        Connection connection = connectionMaker.makeConnection();
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("select * from users where id = ?");
//
//        preparedStatement.setString(1, id);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        User user = null;
//
//        if (resultSet.next()) {
//            user = new User();
//            user.setId(resultSet.getString("id"));
//            user.setName(resultSet.getString("name"));
//            user.setPassword(resultSet.getString("password"));
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//        if (user == null) {
//            throw new EmptyResultDataAccessException(1);
//        }
//        return user;
//    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ? ",
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                });
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

//    public void deleteAll() throws SQLException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = dataSource.getConnection();
//
////            preparedStatement =
////                    connection.prepareStatement("delete from users");
//            StatementStrategy statementStrategy = new DeleteAllStatement();
//            preparedStatement = statementStrategy.makePreparedStatement(connection);
//            preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//
//                }
//            }
//        }
//    }

//    public void deleteAll() throws SQLException {
//        StatementStrategy stmt = new DeleteAllStatement();
//        jdbcContext.workWithStatementStrategy(stmt);
//    }

//    public void deleteAll() throws SQLException{
//        StatementStrategy stmt = new StatementStrategy() {
//            @Override
//            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
//                return c.prepareStatement("delete from users");
//            }
//        };
//        jdbcContext.workWithStatementStrategy(stmt);
//    }

//    public void deleteAll() throws SQLException{
//        this.jdbcTemplate.update(
//                new PreparedStatementCreator() {
//                    @Override
//                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                        return con.prepareStatement("delete from users");
//                    }
//                }
//        );
//    }

    public void deleteAll() {
//        this.jdbcContext.executeSql("delete from users");
        this.jdbcTemplate.update("delete from users");
    }
//
//    private void executeSql(final String query) throws SQLException {
//        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
//            @Override
//            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
//                return c.prepareStatement(query);
//            }
//        });
//    }

//    private void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
//        Connection c = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            c = dataSource.getConnection();
//            preparedStatement = stmt.makePreparedStatement(c);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//
//                }
//            }
//            if (c != null) {
//                try {
//                    c.close();
//                } catch (SQLException e) {
//
//                }
//            }
//        }
//    }

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

//    public int getCount() throws SQLException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = dataSource.getConnection();
//            preparedStatement =
//                    connection.prepareStatement("select count(id) from users");
//            resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            return resultSet.getInt(1);
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//
//                }
//            }
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//
//                }
//            }
//        }
//    }

//    public int getCount(){
//        return this.jdbcTemplate.query(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                return con.prepareStatement("select count(id) from users");
//            }
//        }, new ResultSetExtractor<Integer>() {
//            @Override
//            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
//                rs.next();
//                return rs.getInt(1);
//            }
//        });
//    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(id) from users", Integer.class);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id", this.userMapper);

    }


//    protected abstract Connection getConnection() throws SQLException, ClassNotFoundException;


}