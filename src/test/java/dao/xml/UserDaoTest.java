package dao.xml;

import dao.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new GenericXmlApplicationContext("daoxml/applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();

        user.setId("gyumee");
        user.setName("박성철");
        user.setPassword("springno1");

        dao.add(user);

        User user2 = dao.get("gyumee");
        Assert.assertEquals(user2.getName(), user.getName());
        Assert.assertEquals(user2.getPassword(), user.getPassword());

    }
}
