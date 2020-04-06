package dao.independent;

import dao.Level;
import dao.User;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class UserService {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int EVENT_MIN_LOGCOUNT_FOR_SILVER = 40;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    public static final int EVENT_MIN_RECOMMEND_FOR_GOLD = 20;

    UserDao userDao;

    UserLevelUpgradePolicy userLevelUpgradePolicy;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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

        TransactionSynchronizationManager.initSynchronization();
        Connection c = DataSourceUtils.getConnection(dataSource);
        c.setAutoCommit(false);

        try {
            List<User> userList = userDao.getAll();
            for (User user : userList) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }
        } catch (Exception e) {
            c.rollback();
            throw e;
        } finally {
            DataSourceUtils.releaseConnection(c, dataSource);
            TransactionSynchronizationManager.unbindResource(this.dataSource);
            TransactionSynchronizationManager.clearSynchronization();
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
    }

}
