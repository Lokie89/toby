package dao.service;

import dao.User;
import dao.independent.TestUserServiceException;

public class TestUserService extends UserServiceImpl {

    private String id;

    public TestUserService(String id){
        this.id = id;
    }

    @Override
    protected void upgradeLevel(User user){
        if(user.getId().equals(this.id)){
            throw new TestUserServiceException();
        }
        super.upgradeLevel(user);
    }
}
