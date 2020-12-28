package com.mfarukkose.secretwrite.repositories;

import com.mfarukkose.secretwrite.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findMessagesByConversationId(Long conversationId);
}
