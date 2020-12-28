package com.mfarukkose.secretwrite.models;

import org.springframework.data.annotation.Id;
import java.util.Comparator;

public class Message {

    @Id
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Long conversationId;
    private String message;
    private String date;
    private boolean isReaded;

    public Message() {
    }

    public Message(Long id, Long senderId, Long receiverId, Long conversationId, String message, String date, boolean isReaded) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.conversationId = conversationId;
        this.message = message;
        this.date = date;
        this.isReaded = isReaded;
    }

    public static Comparator<Message> idComparator = new Comparator<Message>() {
        public int compare(Message m1, Message m2) {
            return m1.getId().compareTo(m2.getId());
        }};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReaded() {
        return isReaded;
    }

    public void setReaded(boolean readed) {
        isReaded = readed;
    }
}
