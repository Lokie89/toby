package independent;

import dao.Level;
import dao.User;
import dao.independent.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoxml/independent_applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserDao dao;

//    @Autowired
//    private DataSource dataSource;


    User user1;
    User user2;
    User user3;

    private void checkSameUser(User user1, User user2) {
        Assert.assertEquals(user1.getId(), user2.getId());
        Assert.assertEquals(user1.getName(), user2.getName());
        Assert.assertEquals(user1.getPassword(), user2.getPassword());
        Assert.assertEquals(user1.getLevel(), user2.getLevel());
        Assert.assertEquals(user1.getLogin(), user2.getLogin());
        Assert.assertEquals(user1.getRecommend(), user2.getRecommend());
    }

    @Before
    public void setUp() {
        this.user1 = new User("gyumee", "박성철", "springno1", Level.BASIC, 1, 0);
        this.user2 = new User("leegw700", "이길원", "springno2", Level.SILVER, 55, 10);
        this.user3 = new User("bumjin", "박범진", "springno3", Level.GOLD, 100, 40);
    }

    @Test
    public void addAndGet() {

        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.add(user1);
        dao.add(user2);
        dao.add(user3);

        User getUser1 = dao.get(user1.getId());
        checkSameUser(getUser1, user1);

        User getUser2 = dao.get(user2.getId());
        checkSameUser(getUser2, user2);
    }

    @Test
    public void count() {
        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.add(user1);
        Assert.assertEquals(dao.getCount(), 1);
        dao.add(user2);
        Assert.assertEquals(dao.getCount(), 2);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() {

        dao.deleteAll();
        Assert.assertEquals(dao.getCount(), 0);

        dao.get("unknown_id");
    }

    @Test
    public void getAll() {

        dao.deleteAll();

        dao.add(user1);
        List<User> users1 = dao.getAll();
        Assert.assertEquals(users1.size(), 1);
        checkSameUser(user1, users1.get(0));

        dao.add(user2);
        List<User> users2 = dao.getAll();
        Assert.assertEquals(users2.size(), 2);
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));

        dao.add(user3);
        List<User> users3 = dao.getAll();
        Assert.assertEquals(users3.size(), 3);
        checkSameUser(user3, users3.get(0));
        checkSameUser(user1, users3.get(1));
        checkSameUser(user2, users3.get(2));

    }

    @Test(expected = DataAccessException.class)
    public void duplicateKey() {
        dao.deleteAll();

        dao.add(user1);
        dao.add(user1);
    }

    @Test
    public void update() {
        dao.deleteAll();

        dao.add(user1);
        dao.add(user2);

        user1.setName("오민규");
        user1.setPassword("springno6");
        user1.setLevel(Level.GOLD);
        user1.setLogin(1000);
        user1.setRecommend(999);

        dao.update(user1);

        User user1update = dao.get(user1.getId());
        checkSameUser(user1, user1update);
        User user2same = dao.get(user2.getId());
        checkSameUser(user2, user2same);
    }

//    @Test
//    public void sqlExceptionTranslate() {
//        dao.deleteAll();
//        try {
//            dao.add(user1);
//            dao.add(user1);
//        } catch (DuplicateKeyException ex) {
//            SQLException sqlException = (SQLException) ex.getRootCause();
//            SQLExceptionTranslator set =
//                    new SQLErrorCodeSQLExceptionTranslator(this.dataSource);
//            Assert.assertEquals(set.translate(null, null, sqlException), DuplicateKeyException.class);
//        }
//    }
}
