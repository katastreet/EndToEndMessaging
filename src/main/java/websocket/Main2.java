package websocket;

import java.util.Scanner;


public class Main2 {
	public static void main(String[] args) throws Exception {
		ServerThread server = new ServerThread(8000);
		Thread t1 = new Thread(server);
		t1.start();
		
		Scanner uScanner = new Scanner(System.in);
        
//		String dest = "ws://localhost:8080/";
		
		System.out.println("select ip to connect and port:");
		String dest = uScanner.nextLine();
		
		
		try {
		SetUpClient setUpClient = new SetUpClient(dest);
		System.out.println("username:");
		String username = uScanner.nextLine();
		while(true) {
			setUpClient.sendMessage(username + ":" + uScanner.nextLine());
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			uScanner.close();
		}
			
			
}
}

