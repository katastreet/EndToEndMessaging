package websocket;

import java.net.URI;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class SetUpClient {
	
	public String webAddress;
	public WebSocketClient client;
	public Client socket;
	
	public SetUpClient(String address) throws Exception
	{
		webAddress = address;
		client = new WebSocketClient();
		try {
			
			socket = new Client();
			client.start();
			URI echoUri = new URI(webAddress);
			ClientUpgradeRequest request = new ClientUpgradeRequest();
			client.connect(socket, echoUri, request);
			socket.getLatch().await();
		} catch (Throwable t) {
			throw new Exception("Unable to connect:" + toString().toString());
	}
	}
	
	public void sendMessage(String message) {
		socket.sendMessage(message);
		
	}
	
	public void closeSetupClient() throws Exception {
		client.stop();
	}
}

