package com.mfarukkose.secretwrite.services.Impl;

import com.mfarukkose.secretwrite.models.User;
import com.mfarukkose.secretwrite.repositories.UserRepository;
import com.mfarukkose.secretwrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean updateSessionId(String sessionId, Long userId) {
        try {
            User user = userRepository.findUserById(userId);
            user.setSessionId(sessionId);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error when updating session", e);
        }
    }

    @Override
    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error when saving user", e);
        }
    }

    @Override
    public List<User> searchUser(String userName) {
        try {
            if(userName == "") {
                return new ArrayList<User>();
            } else {
                return userRepository.findUsersByNameLike(userName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error when updating session", e);
        }
    }

    @Override
    public User getUserById(Long userId) {
        try {
            return userRepository.findUserById(userId);
        } catch (Exception e) {
            throw new RuntimeException("Error when getting user by id", e);
        }
    }
}
