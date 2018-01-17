package websocket;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import gui.WritableGUI;


@WebSocket
public class WebSocketServer {
	
	WritableGUI gui;
	
	public WebSocketServer(WritableGUI gui) {
		this.gui = gui;
	}
	
	
	@OnWebSocketMessage
    public void echo(Session sess, String incomingMessage) {
           System.out.println("msg recieved:" + incomingMessage);
           
           if(gui != null)
           {
           gui.write(incomingMessage);
           }
//           try {
//			sess.getRemote().sendString("msg:" + incomingMessage);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
           
           
    }
	
}
