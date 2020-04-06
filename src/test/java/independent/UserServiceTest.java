package independent;


import dao.Level;
import dao.User;
import dao.independent.TestUserService;
import dao.independent.TestUserServiceException;
import dao.independent.UserDao;
import dao.independent.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoxml/independent_applicationContext.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

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
    public void upgradeLevels() {
        userDao.deleteAll();
        for (User user : userList) {
            userDao.add(user);
        }

        userService.upgradeLevels();

//        checkLevel(userList.get(0), Level.BASIC);
//        checkLevel(userList.get(1), Level.SILVER);
//        checkLevel(userList.get(2), Level.SILVER);
//        checkLevel(userList.get(3), Level.GOLD);
//        checkLevel(userList.get(4), Level.GOLD);

        checkLevelUpgraded(userList.get(0), true);
        checkLevelUpgraded(userList.get(1), true);
        checkLevelUpgraded(userList.get(2), true);
        checkLevelUpgraded(userList.get(3), true);
        checkLevelUpgraded(userList.get(4), false);
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

        Assert.assertEquals(userWithLevelRead.getLevel(), userWithLevel.getLevel());
        Assert.assertEquals(userWithOutLevelRead.getLevel(), userWithoutLevel.getLevel());
    }

    //    private void checkLevel(User user, Level expectedLevel) {
//        User userUpdate = userDao.get(user.getId());
//        Assert.assertEquals(userUpdate.getLevel(), expectedLevel);
//    }
    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            Assert.assertEquals(userUpdate.getLevel(), user.getLevel().nextLevel());
        } else {
            Assert.assertEquals(userUpdate.getLevel(), user.getLevel());
        }
    }


    @Test
    public void bean() {
        Assert.assertNotNull(this.userService);
    }

    @Test
    public void upgradeAllOrNothing() {
        UserService testUserService = new TestUserService(userList.get(3).getId());
        testUserService.setUserDao(this.userDao);
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
