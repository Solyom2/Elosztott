package hu.me.it.stompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/chat/message")
    public OutGoingChatMessage greeting(IncomingChatMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new OutGoingChatMessage(message);
    }

}
