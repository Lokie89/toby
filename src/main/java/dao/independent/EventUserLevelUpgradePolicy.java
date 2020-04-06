package dao.independent;

import dao.Level;
import dao.User;

public class EventUserLevelUpgradePolicy implements UserLevelUpgradePolicy {

    UserDao userDao;

    public EventUserLevelUpgradePolicy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC:
                return user.getLogin() >= UserService.EVENT_MIN_LOGCOUNT_FOR_SILVER;
            case SILVER:
                return user.getRecommend() >= UserService.EVENT_MIN_RECOMMEND_FOR_GOLD;
            case GOLD:
                return false;
            default:
                throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }

    @Override
    public void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }
}
