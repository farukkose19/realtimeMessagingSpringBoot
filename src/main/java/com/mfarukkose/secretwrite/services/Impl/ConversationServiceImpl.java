package com.mfarukkose.secretwrite.services.Impl;

import com.mfarukkose.secretwrite.models.Conversation;
import com.mfarukkose.secretwrite.repositories.ConversationRepository;
import com.mfarukkose.secretwrite.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    @Override
    public List<Conversation> getConversationList(Long creatorId) {
        try {
            return conversationRepository.getConversationsByCreator(creatorId);
        }
        catch (Exception e) {
            throw new RuntimeException("Error when getting conversation list", e);
        }
    }

    @Override
    public Conversation createConversation(Conversation conversation) {
        try {
            return conversationRepository.save(conversation);
        }
        catch (Exception e) {
            throw new RuntimeException("Error when creating conversation", e);
        }
    }

    @Override
    public Conversation getConversation(Long creatorId, Long receiverId) {
        try {
            return conversationRepository.getConversationsByCreatorAndReciever_Id(creatorId, receiverId);
        }
        catch (Exception e) {
            throw new RuntimeException("Error when getting conversation", e);
        }
    }
}
