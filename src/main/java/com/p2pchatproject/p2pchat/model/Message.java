package com.p2pchatproject.p2pchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String text;
//    private long timeStamp;

    public Message() {
    }

    public Message(String userName, String text, long timeStamp) {
        this.userName = userName;
        this.text = text;
//        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

//    public long getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(long timeStamp) {
//        this.timeStamp = timeStamp;
//    }

    public boolean hasAllFields(){
        if (!this.getText().isEmpty() &&
        this.getId() != null &&
        !this.getUserName().isEmpty()) {
            return true;
        }
        else return false;
    }
}