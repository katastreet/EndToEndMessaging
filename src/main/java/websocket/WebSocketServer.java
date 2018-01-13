package websocket;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;


@WebSocket
public class WebSocketServer {
	
	@OnWebSocketMessage
    public void echo(Session sess, String incomingMessage) {
           System.out.println("msg recieved:" + incomingMessage);
//           try {
//			sess.getRemote().sendString("msg:" + incomingMessage);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
           
           
    }
	
}
