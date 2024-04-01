package com.geektext.user;

import java.util.List;

public interface UserDAO {
    void registerUser(User user);
    List<User> findAllUsers();
    boolean existsUserWithId(Integer id);
    List<User> getUserByUsername(String username);
    void updateUser(User user);
}
