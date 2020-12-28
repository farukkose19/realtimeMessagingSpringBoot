package com.mfarukkose.secretwrite.controllers;

import com.mfarukkose.secretwrite.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<User> saveUser(@RequestBody User user);

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<User>> searchUser(@RequestParam("userName") String userName);
}
