package dao.xml;

import dao.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoxml/test_applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao dao;
//    @Autowired
//    private ApplicationContext context;


    @Before
    public void setUp() {
//        ApplicationContext context = new GenericXmlApplicationContext("daoxml/applicationContext.xml");
//        dao = context.getBean("userDao", UserDao.class);
//        System.out.println(this.context);
//        System.out.println(this);
        // test
//        DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost:3306/testtoby", "root", "1111", true);
//        dao.setDataSource(dataSource);
    }

    @Test
    public void addAndGet() throws SQLException {

        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");

        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.add(user1);
        dao.add(user2);

        User getUser1 = dao.get(user1.getId());
        Assert.assertEquals(getUser1.getName(), user1.getName());
        Assert.assertEquals(getUser1.getPassword(), user1.getPassword());

        User getUser2 = dao.get(user2.getId());
        Assert.assertEquals(getUser2.getName(), user2.getName());
        Assert.assertEquals(getUser2.getPassword(), user2.getPassword());
    }

    @Test
    public void count() throws SQLException {
        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.add(user1);
        Assert.assertEquals(dao.getCount(), 1);
        dao.add(user2);
        Assert.assertEquals(dao.getCount(), 2);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {

        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.get("unknown_id");
    }
}
