package com.websocket.websocket.echo;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("CONNECTION ESTABLISHED"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();

        for(int i=0;i<25;i++){
            session.sendMessage(new TextMessage("RECEIVED: "+ msg+i));
            Thread.sleep(3000);
        }

    }

}
