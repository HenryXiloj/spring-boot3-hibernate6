package com.henry.service;

import com.henry.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    Integer getSum(int a, int b);
}
