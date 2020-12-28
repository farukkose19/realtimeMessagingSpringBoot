package com.mfarukkose.secretwrite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public interface Main {

    @RequestMapping("/")
    @ResponseBody String mockService();
}
