package com.mfarukkose.secretwrite.handler;

import com.google.gson.Gson;
import com.mfarukkose.secretwrite.models.Conversation;
import com.mfarukkose.secretwrite.models.Message;
import com.mfarukkose.secretwrite.models.User;
import com.mfarukkose.secretwrite.services.CounterService;
import com.mfarukkose.secretwrite.services.MessageService;
import com.mfarukkose.secretwrite.services.UserService;
import com.mfarukkose.secretwrite.services.WebSocketSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    WebSocketSessionService webSocketSessionService;

    @Autowired
    CounterService counterService;

    public static List<WebSocketSession> webSocketSessionList = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Gson gson = new Gson();
        Conversation conversation = gson.fromJson(session.getHandshakeHeaders().get("conversation").get(0), Conversation.class);
        userService.updateSessionId(session.getId(), conversation.getCreator());
        //webSocketSessionService.saveWebSocketSession(session);
        webSocketSessionList.add(session);
        session.sendMessage(new TextMessage(gson.toJson(messageService.getMessagesFromConversation(conversation.getId()))));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Gson gson = new Gson();
        String jsonMessage = message.getPayload();
        Message message1 = gson.fromJson(jsonMessage, Message.class);
        if(message1.getId() == null)
        message1.setId( counterService.getNext("message"));
        messageService.sendMessage(message1);

        System.out.println(message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // webSocketSessions.remove(session);
    }



}
