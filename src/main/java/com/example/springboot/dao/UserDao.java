package com.example.springboot.dao;


import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAll();
    User getById(long id);
    void update(User user);
    void delete(long id);
}
