package club.tinysme.lsongseven.hello.world;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/server")
@Component
public class WsServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Open Connection with " + session.getId() + " ...");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Close Connection with " + session.getId() + " ...");
    }

    @OnMessage
    public String onMessage(String message) {
        System.out.println("Message from the client: " + message);
        String echoMsg = "Echo from the server : " + message;
        return echoMsg;
    }

    @OnError
    public void onError(Throwable e) {
        e.printStackTrace();
    }

}
