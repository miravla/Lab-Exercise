package serverApplication;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerWordCount {

	public static void main(String[] args) {
		
		// Port to receive and respond to request
		final int serverPort=4228;
		int bufferSize = 1024;
		
		try {
			// Instantiate a new DatagramSocket to receive responses from the client
			DatagramSocket serverSocket = new DatagramSocket (serverPort);
			
			// Open buffers to Store client data
		    byte clientDataReceived[] = new byte[bufferSize];
		    
		    DatagramPacket inputPacket = new DatagramPacket(clientDataReceived, clientDataReceived.length);
		    System.out.println("Waiting for Connection....");
		    
		    // Receive data from the client and store in inputPacket
		    serverSocket.receive(inputPacket);
			
			// Client Data
		    String receivedData = new String (inputPacket.getData());
		    System.out.println("Message of Client : " + receivedData);
			
		    //Count word
			WordCount wordCount = new WordCount();
			String sendData = wordCount.getWordCount(receivedData);
			System.out.println("The sentence contains " + sendData+" words");
			
			// Open buffer to send result back to client	
			byte sendResult[]= sendData.getBytes();
			
			// Get client's address
			InetAddress clientAddress = inputPacket.getAddress(); 
			int clientPort = inputPacket.getPort();
			
			// Open new UDP packet to send to the client with their address
			DatagramPacket outputPacket = new DatagramPacket(sendResult,
					sendResult.length, clientAddress, clientPort);
			
			// Send the packet to client
		    serverSocket.send(outputPacket);

		    // Close the socket connection
		    serverSocket.close();
			
			
		
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}