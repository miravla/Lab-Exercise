package Client;


import java.net.InetAddress;
import java.net.Socket;


public class ClientConnector {
	
	public Socket getConnection() throws Exception {
		
		Socket socket = new Socket(InetAddress.getLocalHost(), 4782);
			
		return socket;
	}

}