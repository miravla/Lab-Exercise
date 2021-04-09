package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Client.ClientConnector;

public class ClientTranslator {
private ClientConnector connector;
	
	public ClientTranslator () {
		
		connector = new ClientConnector();
	}
	
	
	public String countWord (String text) throws Exception {
		
		Socket socket = null;
		DataOutputStream WordToCount = null;
		DataInputStream NoOfWord = null;
		String totalWords;
		//int totalWords = 0;
		// Request data
				ClientTranslator language1 = new ClientTranslator();
				language1.setLanguage("Selamat pagi");
				
				
		
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
			//If anythings goes wrong, close all
			
			if (WordToCount != null)
				WordToCount.close();
			
			if ( NoOfWord != null)
				 NoOfWord.close();
			
			if (socket != null)
				socket.close();
			
		}
		
		return totalWords;
		
	}


	private void setLanguage(String string) {
		// TODO Auto-generated method stub
		
	}
}
