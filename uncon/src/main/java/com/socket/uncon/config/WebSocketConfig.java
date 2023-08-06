package com.socket.uncon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Конфигурируем брокер сообщений, позволяющий обмениваться сообщениями с клиентами
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Регистрируем WebSocket эндпоинт для подключения клиентов
        registry.addEndpoint("/websocket-crypto")
                .setAllowedOriginPatterns("*") // Разрешить запросы от всех источников (замените "*" на конкретные домены, если это безопасно)
                .withSockJS();
    }

}
