package com.p2pchatproject.p2pchat.service;

import com.p2pchatproject.p2pchat.model.Message;
import com.p2pchatproject.p2pchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getAll() {
        return repository.findAll();
    }

    @Override
    public void addMessage(Message message) {
        repository.save(message);
    }
}