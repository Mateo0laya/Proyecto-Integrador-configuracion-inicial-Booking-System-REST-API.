package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserServiceMap implements UserService {

    private Map<Integer, User> usersMap = new HashMap<>();
    private List<User> usersList = new ArrayList<>();

    @Override
    public User findById(int id) {
        return usersMap.get(id);
    }

    @Override
    public User save(User user) {
        usersMap.put(user.getId(), user);
        usersList.add(user);
        return user;
    }

    @Override
    public User update(int id, User user) {
        usersMap.put(id, user);
        return user;
    }

    @Override
    public void delete(int id) {
        usersMap.remove(id);
        for (User u : usersList) {
            if (u.getId() == id) {
                usersList.remove(u);
                break;
            }
        }
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }
}
