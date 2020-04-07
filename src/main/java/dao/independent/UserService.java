package dao.independent;

import dao.Level;
import dao.User;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;

public class UserService {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int EVENT_MIN_LOGCOUNT_FOR_SILVER = 40;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    public static final int EVENT_MIN_RECOMMEND_FOR_GOLD = 20;

    UserDao userDao;

    UserLevelUpgradePolicy userLevelUpgradePolicy;

    PlatformTransactionManager transactionManager;

    private MailSender mailSender;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy userLevelUpgradePolicy) {
        this.userLevelUpgradePolicy = userLevelUpgradePolicy;
    }

    public void upgradeLevels() throws Exception {
//        List<User> userList = userDao.getAll();
//        for (User user : userList) {
//            boolean changed = false;
//            if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
//                user.setLevel(Level.SILVER);
//                changed = true;
//            }
//            if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
//                user.setLevel(Level.GOLD);
//                changed = true;
//            }
//            if (changed) {
//                userDao.update(user);
//            }

//            if (canUpgradeLevel(user)) {
//                upgradeLevel(user);
//            }
//            if (userLevelUpgradePolicy.canUpgradeLevel(user)) {
//                userLevelUpgradePolicy.upgradeLevel(user);
//            }
//            if (canUpgradeLevel(user)) {
//                upgradeLevel(user);
//            }
//        }

//        TransactionSynchronizationManager.initSynchronization();
//        Connection c = DataSourceUtils.getConnection(dataSource);
//        c.setAutoCommit(false);
//
//        try {
//            List<User> userList = userDao.getAll();
//            for (User user : userList) {
//                if (canUpgradeLevel(user)) {
//                    upgradeLevel(user);
//                }
//            }
//            c.commit();
//        } catch (Exception e) {
//            c.rollback();
//            throw e;
//        } finally {
//            DataSourceUtils.releaseConnection(c, dataSource);
//            TransactionSynchronizationManager.unbindResource(this.dataSource);
//            TransactionSynchronizationManager.clearSynchronization();
//        }

//        PlatformTransactionManager transactionManager =
//                new DataSourceTransactionManager(dataSource);

        TransactionStatus status =
                this.transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
//            List<User> userList = userDao.getAll();
//            for (User user : userList) {
//                if (canUpgradeLevel(user)) {
//                    upgradeLevel(user);
//                }
//            }
            upgradeLevelsInternal();
            this.transactionManager.commit(status);
        } catch (RuntimeException e) {
            this.transactionManager.rollback(status);
            throw e;
        }
    }

    private void upgradeLevelsInternal(){
        List<User> userList = userDao.getAll();
        for (User user : userList) {
            if (canUpgradeLevel(user)) {
                upgradeLevel(user);
            }
        }
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }

    private boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC:
                return user.getLogin() >= UserService.MIN_LOGCOUNT_FOR_SILVER;
            case SILVER:
                return user.getRecommend() >= UserService.MIN_RECOMMEND_FOR_GOLD;
            case GOLD:
                return false;
            default:
                throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }

    protected void upgradeLevel(User user) {
//        if (user.getLevel() == Level.BASIC) {
//            user.setLevel(Level.SILVER);
//        } else if (user.getLevel() == Level.SILVER) {
//            user.setLevel(Level.GOLD);
//        }
//        userDao.update(user);

        user.upgradeLevel();
        userDao.update(user);
        sendUpgradeEMail(user);
    }

    private void sendUpgradeEMail(User user) {
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "mail.ksug.org");
//        Session session = Session.getInstance(props);
//        MimeMessage message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress("useradmin@ksug.org"));
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(user.getEmail()));
//            message.setText("사용자 님의 등급이 " + user.getLevel().name() + " 로 업그레이드 되었습니다.");
//            Transport.send(message);
//        } catch (AddressException e) {
//            throw new RuntimeException(e);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("useradmin@ksug.org");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText("사용자 님의 등급이 " + user.getLevel().name() + " 로 업그레이드 되었습니다.");

        mailSender.send(mailMessage);

    }

}
