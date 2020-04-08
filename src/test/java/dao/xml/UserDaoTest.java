package dao.xml;

import dao.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        assertEquals(dao.getCount(), 0);

        dao.add(user1);
        dao.add(user2);

        User getUser1 = dao.get(user1.getId());
        assertEquals(getUser1.getName(), user1.getName());
        assertEquals(getUser1.getPassword(), user1.getPassword());

        User getUser2 = dao.get(user2.getId());
        assertEquals(getUser2.getName(), user2.getName());
        assertEquals(getUser2.getPassword(), user2.getPassword());
    }

    @Test
    public void count() throws SQLException {
        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        dao.deleteAll();
        assertEquals(dao.getCount(), 0);

        dao.add(user1);
        assertEquals(dao.getCount(), 1);
        dao.add(user2);
        assertEquals(dao.getCount(), 2);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {

        dao.deleteAll();
        assertEquals(dao.getCount(), 0);

        dao.get("unknown_id");
    }

    @Test
    public void getAll() throws SQLException {

        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박에이", "springno3");
        dao.deleteAll();

        dao.add(user1);
        List<User> users1 = dao.getAll();
        assertEquals(users1.size(), 1);
        checkSameUser(user1, users1.get(0));

        dao.add(user2);
        List<User> users2 = dao.getAll();
        assertEquals(users2.size(), 2);
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));

        dao.add(user3);
        List<User> users3 = dao.getAll();
        assertEquals(users3.size(), 3);
        checkSameUser(user3, users3.get(0));
        checkSameUser(user1, users3.get(1));
        checkSameUser(user2, users3.get(2));

    }

    private void checkSameUser(User user1, User user2) {
        assertEquals(user1.getId(), user2.getId());
        assertEquals(user1.getName(), user2.getName());
        assertEquals(user1.getPassword(), user2.getPassword());
    }
}
