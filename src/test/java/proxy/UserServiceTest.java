package proxy;

import dao.Level;
import dao.User;
import dao.independent.TestUserServiceException;
import dao.independent.UserDao;
import dao.service.UserService;
import dao.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/proxy/FactoryBeanTest-context.xml")
public class UserServiceTest {

    //    @Autowired
//    ApplicationContext context;
//
//    @Autowired
//    MailSender mailSender;
//
//    @Autowired
//    DataSource dataSource;
//
    @Autowired
    UserDao userDao;
//
//    @Autowired
//    PlatformTransactionManager transactionManager;
//

    @Autowired
    UserService userService;

    @Qualifier("testUserService")
    @Autowired
    UserService testUserService;

    List<User> users;


    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, dao.independent.UserService.MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, dao.independent.UserService.MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, dao.independent.UserService.MIN_RECOMMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, dao.independent.UserService.MIN_RECOMMEND_FOR_GOLD),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }


    @Test
    public void upgradeAllOrNothing() throws Exception {
//        TestUserService testUserService = new TestUserService(users.get(3).getId());
//        testUserService.setUserDao(userDao);
//        testUserService.setMailSender(mailSender);

//        TxProxyFactoryBean txProxyFactoryBean = context.getBean("&userService", TxProxyFactoryBean.class);
//        ProxyFactoryBean txProxyFactoryBean = context.getBean("&userService", ProxyFactoryBean.class);
//        txProxyFactoryBean.setTarget(testUserService);
//        UserService txUserService = (UserService) txProxyFactoryBean.getObject();

        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }
        try {
            this.testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (TestUserServiceException e) {

        }
        checkLevelUpgraded(users.get(1), false);
    }

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertEquals(userUpdate.getLevel(), user.getLevel().nextLevel());
        } else {
            assertEquals(userUpdate.getLevel(), user.getLevel());
        }
    }

    static class TestUserServiceImpl extends UserServiceImpl {
        private String id = "madnite1";

        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) {
                throw new TestUserServiceException();
            }
            super.upgradeLevel(user);
        }
    }

    @Test
    public void advisorAutoProxyCreator() {
        assertEquals(is(testUserService), is(java.lang.reflect.Proxy.class));
    }

}
