package demoCountWordClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientWordCount {
	
	private ClientConnector connector;
	
	public ClientWordCount () {
		
		connector = new ClientConnector();
	}
	//Count word from input
	
	public String countWord (String text) throws Exception {
		
		Socket socket = null;
		DataOutputStream WordToCount = null;
		DataInputStream NoOfWord = null;
		String totalWords;
		//int totalWords = 0;
		
		try {
			
			// Get connection
			socket =  connector.getConnection();
			
			// Send data to server
			WordToCount = new DataOutputStream(socket.getOutputStream());
			WordToCount.writeUTF(text);
			
			// Get total words from socket
			 NoOfWord = new DataInputStream(socket.getInputStream());
			 totalWords =  NoOfWord.readUTF();
			
					
		} catch (Exception exception ) {
			
			throw exception;
			
			
			
		} finally {
			//If anythings goes wrong, closee all
			
			if (WordToCount != null)
				WordToCount.close();
			
			if ( NoOfWord != null)
				 NoOfWord.close();
			
			if (socket != null)
				socket.close();
			
		}
		
		return totalWords;
		
	}
	
	
	

}
