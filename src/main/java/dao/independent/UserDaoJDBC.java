package dao.independent;

import dao.Level;
import dao.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoJDBC implements UserDao {

    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;

    private SqlService sqlService;

    public void setSqlService(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    //    private String sqlAdd;
//
//    public void setSqlAdd(String sqlAdd) {
//        this.sqlAdd = sqlAdd;
//    }
//    private Map<String, String> sqlMap;
//
//    public void setSqlMap(Map<String, String> sqlMap) {
//        this.sqlMap = sqlMap;
//    }

    private RowMapper<User> userMapper =
            new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setLevel(Level.valueOf(rs.getInt("level")));
                    user.setLogin(rs.getInt("login"));
                    user.setRecommend(rs.getInt("recommend"));
                    return user;
                }
            };


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

//    @Override
//    public void add(User user) {
//        this.jdbcTemplate.update("insert into users(id, name, password, level, login ,recommend) " +
//                        "values(?, ?, ?, ?, ?, ?)", user.getId(), user.getName(), user.getPassword(),
//                user.getLevel().intValue(), user.getLogin(), user.getRecommend());
//    }

//    @Override
//    public void add(User user) {
//        this.jdbcTemplate.update(this.sqlMap.get("add"), user.getId(), user.getName(), user.getPassword(),
//                user.getLevel().intValue(), user.getLogin(), user.getRecommend());
//    }

    @Override
    public void add(User user) {
        this.jdbcTemplate.update(this.sqlService.getSql("userAdd"), user.getId(), user.getName(), user.getPassword(),
                user.getLevel().intValue(), user.getLogin(), user.getRecommend());
    }

    //    @Override
//    public User get(String id) {
//        return this.jdbcTemplate.queryForObject("select * from users where id = ? ",
//                new Object[]{id}, this.userMapper);
//    }
//    @Override
//    public User get(String id) {
//        return this.jdbcTemplate.queryForObject(sqlMap.get("get"),
//                new Object[]{id}, this.userMapper);
//    }
    @Override
    public User get(String id) {
        return this.jdbcTemplate.queryForObject(this.sqlService.getSql("userGet"),
                new Object[]{id}, this.userMapper);
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id", this.userMapper);
    }

    @Override
    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    @Override
    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(id) from users", Integer.class);
    }

    @Override
    public void update(User user) {
        this.jdbcTemplate.update("update users set name = ?, password = ?, level = ?, login = ?, recommend = ? where id = ?",
                user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getId());
    }
}
