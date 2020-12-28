package com.mfarukkose.secretwrite.services;

import com.mfarukkose.secretwrite.models.User;

import java.util.List;

public interface UserService {

    public boolean updateSessionId(String sessionId, Long userId);
    public boolean saveUser(User user);
    public List<User> searchUser(String userName);
    public User getUserById(Long userId);

}
