package com.p2pchatproject.p2pchat.controller;

import com.p2pchatproject.p2pchat.model.Message;
import com.p2pchatproject.p2pchat.model.MessageDTO;
import com.p2pchatproject.p2pchat.model.StatusDTO;
import com.p2pchatproject.p2pchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MessageService messageService;

    @PostMapping("/message/receive")
    public StatusDTO recieveMessage(@RequestBody MessageDTO messageDTO) {
        Message recieved = messageDTO.getMessage();
        if (recieved.hasAllFields()) {
            messageService.addMessage(messageDTO.getMessage());
            return new StatusDTO("ok");
        } else {
            return new StatusDTO("error", messageDTO.missingFields());
        }
    }
}