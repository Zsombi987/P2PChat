package com.p2pchatproject.p2pchat.model;

import java.util.Arrays;

public class MessageDTO {
    private Message message;
    private Client client;

    public MessageDTO() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String missingFields() {
        StringBuilder missingFields = new StringBuilder();
        if (this == null) return "Object is empty";
        if (this.message != null) {
            Arrays.asList(message.getClass().getDeclaredFields()).stream().filter(a -> (a == null))
                    .forEach(a -> missingFields.append(message.getClass().getSimpleName() + "." + a.getName() + ", "));
        } else {
            missingFields.append("message, ");
        }
        if (this.client != null) {
            Arrays.asList(client.getClass().getDeclaredFields()).stream().filter(a -> (a == null))
                    .forEach(a -> missingFields.append(client.getClass().getSimpleName() + "." + a.getName() + ", "));
        } else {
            missingFields.append("client, ");
        }
        if (missingFields.toString().contains(","))
            missingFields.delete(missingFields.lastIndexOf(","), missingFields.length());
        return String.format("Missing field(s): %s", missingFields);
    }
}