package com.mfarukkose.secretwrite.services;

import org.springframework.web.socket.WebSocketSession;

public interface WebSocketSessionService {

    WebSocketSession saveWebSocketSession(WebSocketSession webSocketSession);
    WebSocketSession getWebSocketSession(String sessionId);

}
