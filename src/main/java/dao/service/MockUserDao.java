package dao.service;

import dao.User;
import dao.independent.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MockUserDao implements UserDao {

    private List<User> userList;
    private List<User> updated = new ArrayList<>();

    public MockUserDao(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUpdated() {
        return this.updated;
    }

    @Override
    public void add(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User get(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> getAll() {
        return this.userList;
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User user) {
        updated.add(user);
    }
}
