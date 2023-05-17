package com.example.springboot.services;

import com.example.springboot.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();

    void removeUser(Long id);

    void editUser(User user);

    User getUserById(long id);

}
