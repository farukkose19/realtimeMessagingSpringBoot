package com.mfarukkose.secretwrite.services;

import com.mfarukkose.secretwrite.models.Conversation;

import java.util.List;

public interface ConversationService {

    List<Conversation> getConversationList(Long creatorId);

    Conversation createConversation(Conversation conversation);

    Conversation getConversation(Long creatorId, Long receiverId);
}
