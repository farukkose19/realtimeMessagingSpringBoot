package com.mfarukkose.secretwrite.controllers.Impl;

import com.mfarukkose.secretwrite.controllers.Main;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainImpl implements Main {

    @Override
    public String mockService() {
        return "success\n";
    }
}
