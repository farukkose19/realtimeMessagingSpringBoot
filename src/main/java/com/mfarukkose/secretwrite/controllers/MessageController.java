package com.mfarukkose.secretwrite.controllers;

import com.mfarukkose.secretwrite.models.Message;
import com.mfarukkose.secretwrite.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface MessageController {

    @RequestMapping(value = "/getMessageList", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<Message>> getMessageList();

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Message> sendMessage(@RequestBody Message message);

    @RequestMapping(value = "/sendMessageToSocket", method = RequestMethod.POST)
    @ResponseBody
    void sendMessageToSocket(@RequestBody Message message) throws Exception;
}
