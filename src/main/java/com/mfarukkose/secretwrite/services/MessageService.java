package com.mfarukkose.secretwrite.services;

import com.mfarukkose.secretwrite.models.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getAllMessages();
    public boolean sendMessage(Message message);
    public List<Message> getMessagesFromConversation(Long conversationId);
    public void sendMessageOnlineUser(Message message) throws Exception;
}
