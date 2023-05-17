package com.example.springboot.dao;

import com.example.springboot.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAllUsers();

    void removeUser(Long id);

    void editUser(User user);

    User getUserById(long id);
}
