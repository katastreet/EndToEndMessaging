package websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ServerThread implements Runnable{
	
	int port;
	
	public ServerThread(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		Server server = new Server(port);
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(WebSocketServer.class);
            }
        };
        server.setHandler(wsHandler);
        try {
			server.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
	}
	

}
