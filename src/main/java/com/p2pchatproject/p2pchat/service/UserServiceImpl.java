package com.p2pchatproject.p2pchat.service;

import com.p2pchatproject.p2pchat.model.User;
import com.p2pchatproject.p2pchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public void addUser(User user) {
        repository.save(user);
    }

    public void updateUser(String userName) {
        User user = repository.findAll().get(0);
        user.setName(userName);
        repository.save(user);
    }

    @Override
    public User getUser() {
        if (repository.findAll().size() > 0) {
            return repository.findAll().get(0);
        }
        return null;
    }
}