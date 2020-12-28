package com.mfarukkose.secretwrite.controllers.Impl;

import com.mfarukkose.secretwrite.controllers.UserController;
import com.mfarukkose.secretwrite.models.User;
import com.mfarukkose.secretwrite.services.CounterService;
import com.mfarukkose.secretwrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Autowired
    CounterService counterService;

    @Override
    public ResponseEntity<User> saveUser(User user) {
        try {
            user.setId(counterService.getNext("user"));
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            throw new RuntimeException("Error when saving user", e);
        }
    }

    @Override
    public ResponseEntity<List<User>> searchUser(String userName) {
        try {
            return ResponseEntity.ok(userService.searchUser(userName));
        } catch (Exception e) {
            throw new RuntimeException("Error when searching users", e);
        }
    }


}
