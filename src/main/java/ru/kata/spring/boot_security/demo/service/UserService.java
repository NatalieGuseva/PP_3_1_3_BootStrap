package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(Long id);

    void saveUser(User existingUser, User user);

    void deleteUser(User user);

    User getUserByFirstname(String name);
}