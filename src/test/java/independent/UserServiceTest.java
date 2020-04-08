package independent;


import dao.Level;
import dao.User;
import dao.independent.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoxml/independent_applicationContext.xml")
public class UserServiceTest {

    @Autowired
    MailSender mailSender;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Autowired
    PlatformTransactionManager transactionManager;

    List<User> userList;

    @Before
    public void setUp() {
        userList = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, UserService.MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, UserService.MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, UserService.MIN_RECOMMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, UserService.MIN_RECOMMEND_FOR_GOLD),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    @DirtiesContext
    public void upgradeLevels() throws Exception {
        userDao.deleteAll();
        for (User user : userList) {
            userDao.add(user);
        }

        MockMailSender mockMailSender = new MockMailSender();
        userService.setMailSender(mockMailSender);

        userService.upgradeLevels();

//        checkLevel(userList.get(0), Level.BASIC);
//        checkLevel(userList.get(1), Level.SILVER);
//        checkLevel(userList.get(2), Level.SILVER);
//        checkLevel(userList.get(3), Level.GOLD);
//        checkLevel(userList.get(4), Level.GOLD);

        checkLevelUpgraded(userList.get(0), false);
        checkLevelUpgraded(userList.get(1), true);
        checkLevelUpgraded(userList.get(2), false);
        checkLevelUpgraded(userList.get(3), true);
        checkLevelUpgraded(userList.get(4), false);

        List<String> request = mockMailSender.getRequests();
        assertEquals(request.size(), 2);
        assertEquals(request.get(0), userList.get(1).getEmail());
        assertEquals(request.get(1), userList.get(3).getEmail());
    }

    @Test
    public void add() {
        userDao.deleteAll();
        User userWithLevel = userList.get(4);
        User userWithoutLevel = userList.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithOutLevelRead = userDao.get(userWithoutLevel.getId());

        assertEquals(userWithLevelRead.getLevel(), userWithLevel.getLevel());
        assertEquals(userWithOutLevelRead.getLevel(), userWithoutLevel.getLevel());
    }

    //    private void checkLevel(User user, Level expectedLevel) {
//        User userUpdate = userDao.get(user.getId());
//        assertEquals(userUpdate.getLevel(), expectedLevel);
//    }
    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertEquals(userUpdate.getLevel(), user.getLevel().nextLevel());
        } else {
            assertEquals(userUpdate.getLevel(), user.getLevel());
        }
    }


    @Test
    public void bean() {
        Assert.assertNotNull(this.userService);
    }

    @Test
    public void upgradeAllOrNothing() throws Exception {
        UserService testUserService = new TestUserService(userList.get(3).getId());
        testUserService.setUserDao(this.userDao);
        testUserService.setDataSource(this.dataSource);
        testUserService.setTransactionManager(this.transactionManager);
        testUserService.setMailSender(this.mailSender);
        userDao.deleteAll();
        for (User user : userList) {
            userDao.add(user);
        }
        try {
            testUserService.upgradeLevels();
            fail();
        } catch (TestUserServiceException e) {

        }
        checkLevelUpgraded(userList.get(1), false);
    }


}
