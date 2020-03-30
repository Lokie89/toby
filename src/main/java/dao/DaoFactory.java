package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
//        return new UserDao(connectionMaker());
        return UserDao.getInstance(setConnectionMaker());
    }

    @Bean
    public ConnectionMaker setConnectionMaker() {
//        return new DConnectionMaker();
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new DConnectionMaker();
    }
}
