package com.mfarukkose.secretwrite.repositories;

import com.mfarukkose.secretwrite.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findUserById(Long id);
    List<User> findUsersByNameLike(String name);
}
