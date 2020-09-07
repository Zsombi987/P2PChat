package com.p2pchatproject.p2pchat.service;

import com.p2pchatproject.p2pchat.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    User getUser();
    void updateUser(String userName);
}