package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }
}
