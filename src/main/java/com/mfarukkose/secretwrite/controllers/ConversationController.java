package com.mfarukkose.secretwrite.controllers;

import com.mfarukkose.secretwrite.models.Conversation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ConversationController {

    @RequestMapping(value = "/getMyConversations", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<Conversation>> getMyConversations(@RequestParam("userId") Long userId);

    @RequestMapping(value = "/createOrGetConversation", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Conversation> createOrGetConversation(@RequestBody Conversation conversation);
}
