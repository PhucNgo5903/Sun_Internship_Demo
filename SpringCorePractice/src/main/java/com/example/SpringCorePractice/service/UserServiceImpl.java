package com.example.SpringCorePractice.service;

import com.example.SpringCorePractice.dao.UserDAO;
import com.example.SpringCorePractice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void createUser(String name, String email) {
        User user = new User(name, email);
        userDAO.save(user);
    }
}
