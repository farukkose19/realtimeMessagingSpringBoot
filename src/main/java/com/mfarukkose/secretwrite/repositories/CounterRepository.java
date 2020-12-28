package com.mfarukkose.secretwrite.repositories;

import com.mfarukkose.secretwrite.models.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends MongoRepository<Counter, String> {
    Counter findCounterById(String sequenceId);
}
