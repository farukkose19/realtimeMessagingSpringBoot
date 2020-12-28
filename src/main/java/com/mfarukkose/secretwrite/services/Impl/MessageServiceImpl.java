package com.mfarukkose.secretwrite.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mfarukkose.secretwrite.handler.ChatWebSocketHandler;
import com.mfarukkose.secretwrite.models.Message;
import com.mfarukkose.secretwrite.models.User;
import com.mfarukkose.secretwrite.repositories.MessageRepository;
import com.mfarukkose.secretwrite.services.MessageService;
import com.mfarukkose.secretwrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserService userService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public boolean sendMessage(Message message) {
        try {
            String json = new ObjectMapper().writeValueAsString(message);
            kafkaTemplate.send("usertopic", message.getId().toString(), json);
            return true;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error when parsing json", e);
        }
    }

    @Override
    public List<Message> getMessagesFromConversation(Long conversationId) {
        try {
            return messageRepository.findMessagesByConversationId(conversationId);
        } catch (Exception e) {
            throw new RuntimeException("Error when getting messages by conversation Id", e);
        }
    }

    @Override
    public void sendMessageOnlineUser(Message message) throws Exception {
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        Gson gson = new Gson();
        User receiver = userService.getUserById(message.getReceiverId());
        // WebSocketSession session = webSocketSessionService.getWebSocketSession(receiver.getSessionId());
        WebSocketSession session = ChatWebSocketHandler.webSocketSessionList.stream().filter(s -> s.getId().equals(receiver.getSessionId())).findFirst().orElse(null);
        assert session != null;
        session.sendMessage(new TextMessage(gson.toJson(messageList)));
    }
}
