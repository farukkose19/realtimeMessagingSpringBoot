package com.mfarukkose.secretwrite.controllers.Impl;

import com.mfarukkose.secretwrite.controllers.ConversationController;
import com.mfarukkose.secretwrite.models.Conversation;
import com.mfarukkose.secretwrite.models.User;
import com.mfarukkose.secretwrite.services.ConversationService;
import com.mfarukkose.secretwrite.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ConversationControllerImpl implements ConversationController {

    @Autowired
    ConversationService conversationService;

    @Autowired
    CounterService counterService;

    @Override
    public ResponseEntity<List<Conversation>> getMyConversations(Long userId) {
        try {
            return ResponseEntity.ok(conversationService.getConversationList(userId));
        } catch (Exception e) {
            throw new RuntimeException("Error when getting conversation list", e);
        }
    }

    @Override
    public ResponseEntity<Conversation> createOrGetConversation(Conversation conversation) {
        try {
            Conversation conversation1 = conversationService
                    .getConversation(conversation.getCreator(), conversation.getReciever().getId());
            if(conversation1 == null) {
                conversation.setId(counterService.getNext("conversation"));
                return ResponseEntity.ok(conversationService.createConversation(conversation));
            } else {
                return ResponseEntity.ok(conversation1);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error when creating conversation", e);
        }
    }
}
