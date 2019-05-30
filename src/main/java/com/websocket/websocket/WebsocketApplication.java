package com.websocket.websocket;

import com.websocket.websocket.echo.EchoHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class WebsocketApplication implements WebSocketConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}

	@Bean
	public EchoHandler echoHandler(){
		return new EchoHandler();
	}


	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(echoHandler(),"/echo");
	}
}
