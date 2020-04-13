package service;


import dao.Level;
import dao.User;
import dao.independent.MockMailSender;
import dao.independent.TestUserServiceException;
import dao.independent.UserDao;
import dao.independent.UserService;
import dao.service.MockUserDao;
import dao.service.TestUserService;
import dao.service.UserServiceImpl;
import dao.service.UserServiceTx;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import proxy.TransactionHandler;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoxml/service_applicationContext.xml")
public class UserServiceTest {

    @Autowired
    MailSender mailSender;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserServiceTx userServiceTx;

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
    public void bean() {
        assertNotNull(this.userServiceImpl);
        assertNotNull(this.userDao);
        assertNotNull(this.userServiceTx);
        assertNotNull(this.mailSender);
        assertNotNull(this.dataSource);
        assertNotNull(this.transactionManager);
    }

//    @Test
//    @DirtiesContext
//    public void upgradeLevels() throws Exception {
//        userDao.deleteAll();
//        for (User user : userList) {
//            userDao.add(user);
//        }
//
//        MockMailSender mockMailSender = new MockMailSender();
//        userServiceImpl.setMailSender(mockMailSender);
//
//        userServiceImpl.upgradeLevels();
//
////        checkLevel(userList.get(0), Level.BASIC);
////        checkLevel(userList.get(1), Level.SILVER);
////        checkLevel(userList.get(2), Level.SILVER);
////        checkLevel(userList.get(3), Level.GOLD);
////        checkLevel(userList.get(4), Level.GOLD);
//
//        checkLevelUpgraded(userList.get(0), false);
//        checkLevelUpgraded(userList.get(1), true);
//        checkLevelUpgraded(userList.get(2), false);
//        checkLevelUpgraded(userList.get(3), true);
//        checkLevelUpgraded(userList.get(4), false);
//
//        List<String> request = mockMailSender.getRequests();
//        assertEquals(request.size(), 2);
//        assertEquals(request.get(0), userList.get(1).getEmail());
//        assertEquals(request.get(1), userList.get(3).getEmail());
//    }

    @Test
    public void upgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        MockUserDao mockUserDao = new MockUserDao(this.userList);
        userServiceImpl.setUserDao(mockUserDao);

        MockMailSender mockMailSender = new MockMailSender();
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        List<User> updated = mockUserDao.getUpdated();
        assertEquals(updated.size(), 2);
        checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER);
        checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);

        List<String> request = mockMailSender.getRequests();
        assertEquals(request.size(), 2);
        assertEquals(request.get(0), userList.get(1).getEmail());
        assertEquals(request.get(1), userList.get(3).getEmail());
    }

    private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
        assertEquals(updated.getId(), expectedId);
        assertEquals(updated.getLevel(), expectedLevel);
    }

    @Test
    public void add() {
        userDao.deleteAll();
        User userWithLevel = userList.get(4);
        User userWithoutLevel = userList.get(0);
        userWithoutLevel.setLevel(null);

        userServiceImpl.add(userWithLevel);
        userServiceImpl.add(userWithoutLevel);

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
    public void upgradeAllOrNothing() throws Exception {
        TestUserService testUserService = new TestUserService(userList.get(3).getId());
        testUserService.setUserDao(this.userDao);
        testUserService.setMailSender(this.mailSender);


        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(testUserService);
        txHandler.setTransactionManager(transactionManager);
        txHandler.setPattern("upgradeLevels");

        dao.service.UserService txUserService = (dao.service.UserService) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{dao.service.UserService.class},
                txHandler
        );

//        UserServiceTx userServiceTx = new UserServiceTx();
//        userServiceTx.setTransactionManager(this.transactionManager);
//        userServiceTx.setUserService(testUserService);

        userDao.deleteAll();
        for (User user : userList) {
            userDao.add(user);
        }
        try {
            txUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (TestUserServiceException e) {

        }
        checkLevelUpgraded(userList.get(1), false);
    }


    @Test
    public void mockUpgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.getAll()).thenReturn(this.userList);
        userServiceImpl.setUserDao(mockUserDao);

        MailSender mockMailSender = mock(MailSender.class);
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao).update(userList.get(1));
        assertEquals(userList.get(1).getLevel(), Level.SILVER);
        verify(mockUserDao).update(userList.get(3));
        assertEquals(userList.get(3).getLevel(), Level.GOLD);

        ArgumentCaptor<SimpleMailMessage> mailMessageArg =
                ArgumentCaptor.forClass(SimpleMailMessage.class);

        verify(mockMailSender, times(2)).send(mailMessageArg.capture());
        List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
        assertEquals(mailMessages.get(0).getTo()[0], userList.get(1).getEmail());
        assertEquals(mailMessages.get(1).getTo()[0], userList.get(3).getEmail());
    }
}
