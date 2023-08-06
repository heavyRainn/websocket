package com.socket.uncon.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic")
    public String handleHelloMessage(String message) {
        // Просто добавляем префикс "Hello, " к полученному сообщению и отсылаем его всем подписчикам на "/topic/crypto"
        return "Hello, " + message;
    }

}
