package com.mfarukkose.secretwrite.controllers.Impl;

import com.mfarukkose.secretwrite.controllers.MessageController;
import com.mfarukkose.secretwrite.handler.ChatWebSocketHandler;
import com.mfarukkose.secretwrite.models.Message;
import com.mfarukkose.secretwrite.services.CounterService;
import com.mfarukkose.secretwrite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.util.*;


@RestController
public class MessageControllerImpl implements MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    CounterService counterService;

    @Override
    public ResponseEntity<List<Message>> getMessageList() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @Override
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        message.setId(counterService.getNext("message"));
        messageService.sendMessage(message);
        return ResponseEntity.ok(message);
    }

    @Override
    public void sendMessageToSocket(@RequestBody Message message) throws Exception {
        messageService.sendMessageOnlineUser(message);
    }
}
