package com.p2pchatproject.p2pchat.controller;

import com.p2pchatproject.p2pchat.model.Message;
import com.p2pchatproject.p2pchat.model.User;
import com.p2pchatproject.p2pchat.service.MessageService;
import com.p2pchatproject.p2pchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private UserService userService;
    private MessageService messageService;

    @Autowired
    public MainController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        if (userService.getUser() != null) {
            model.addAttribute("user", userService.getUser());
            model.addAttribute("message", new Message());
            return "index";
        }
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        if (userService.getUser() != null) {
            return "register";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/message")
    public String saveMessage(Model model) {
        model.addAttribute("user", userService.getUser());
        model.addAttribute("messages", messageService.getAll());
        return "message";
    }

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute Message message, Model model) {
        message.setUserName(userService.getUser().getName());
        messageService.addMessage(message);
        return "redirect:/message";
    }

    @PostMapping("/update")
    public String update(@RequestParam String name) {
        if (userService.getUser() != null) {
            userService.updateUser(name);
            return "redirect:/message";
        } else {
            return "redirect:/register";
        }
    }

    @GetMapping("/refresh")
    public String refresh() {
        return "redirect:/message";
    }
}