package com.henry.service.impl;

import com.henry.model.User;
import com.henry.repository.UserRepository;
import com.henry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Integer getSum(int a, int b) {
        return userRepository.getSum(a,b);
    }
}
