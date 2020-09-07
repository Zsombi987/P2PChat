package com.p2pchatproject.p2pchat.model;


import com.fasterxml.jackson.annotation.JsonInclude;

public class StatusDTO {
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public StatusDTO(String status) {
        this.status = status;
    }

    public StatusDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}