package dao.xml;

import dao.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ApplicationContext context = new GenericXmlApplicationContext("daoxml/applicationContext.xml");
//        UserDao dao = context.getBean("userDao", UserDao.class);
//
//        User user = new User();
//        user.setId("white");
//        user.setName("백기선");
//        user.setPassword("married");
//
//        dao.add(user);
//
//        System.out.println(user.getId() + " 등록");
//
//        User user2 = dao.get(user.getId());
//        if (!user.getName().equals(user2.getName())) {
//            System.out.println("테스트 실패 (name)");
//        } else if (!user.getPassword().equals(user2.getPassword())) {
//            System.out.println("테스트 실패 (password)");
//        } else {
//            System.out.println("테스트 성공");
//        }
    }
}
