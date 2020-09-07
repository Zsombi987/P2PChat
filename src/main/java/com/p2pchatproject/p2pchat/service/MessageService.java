package com.p2pchatproject.p2pchat.service;

import com.p2pchatproject.p2pchat.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAll();
    void addMessage(Message message);
}