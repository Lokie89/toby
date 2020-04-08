package dao.service;

import dao.User;

public interface UserService {
    void add (User user);
    void upgradeLevels();
}
