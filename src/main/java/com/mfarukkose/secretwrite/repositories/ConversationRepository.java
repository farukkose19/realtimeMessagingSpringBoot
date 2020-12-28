package com.mfarukkose.secretwrite.repositories;

import com.mfarukkose.secretwrite.models.Conversation;
import com.mfarukkose.secretwrite.models.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends MongoRepository<Conversation, Long> {

    List<Conversation> getConversationsByCreator(Long creatorId);
    Conversation getConversationsByCreatorAndReciever_Id(Long creatorId, Long receiverId);

}
