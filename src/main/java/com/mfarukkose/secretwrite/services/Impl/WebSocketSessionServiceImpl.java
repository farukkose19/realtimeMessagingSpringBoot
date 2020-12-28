package com.mfarukkose.secretwrite.services.Impl;

import com.mfarukkose.secretwrite.repositories.WebSocketSessionRepository;
import com.mfarukkose.secretwrite.services.WebSocketSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class WebSocketSessionServiceImpl implements WebSocketSessionService {

    @Autowired
    WebSocketSessionRepository webSocketSessionRepository;

    @Override
    public WebSocketSession saveWebSocketSession(WebSocketSession webSocketSession) {
        try {
            return webSocketSessionRepository.save(webSocketSession);
        } catch (Exception e) {
            throw new RuntimeException("Error when saving webSocketSession", e);
        }
    }

    @Override
    public WebSocketSession getWebSocketSession(String sessionId) {
        try {
            return webSocketSessionRepository.findWebSocketSessionById(sessionId);
        } catch (Exception e) {
            throw new RuntimeException("Error when getting webSocketSession", e);
        }
    }
}
