package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

    User findById(int id);

    User save(User user);

    User update(int id, User user);

    void delete(int id);

    List<User> findAll();
}
