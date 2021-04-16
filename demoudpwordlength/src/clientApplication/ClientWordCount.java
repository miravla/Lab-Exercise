package clientApplication;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientWordCount {

	public static void main(String[] args) {
		
		// Port to receive and respond to request
		final int serverPort=4228;
		int bufferSize = 1024;
		
		try {
			
			
			DatagramSocket clientSocket = new DatagramSocket();
			
			// Data to establish connection to server
			InetAddress serverAddress = InetAddress.getByName("localhost");
			
			// oppen buffer to send data
			byte clientData [] = new byte [bufferSize];
			
			// Convert data to byte and store in buffer
			String sentence = "Do You Wanna Build A Snowman?";
			clientData = sentence.getBytes();
			
			// open UDP Packet
			DatagramPacket  outputPacket = new DatagramPacket(clientData, 
					clientData.length, serverAddress, serverPort);
			
			// Send packet to server
			clientSocket.send(outputPacket);
			
			
			// Open buffer to receive data 
			byte receiveData [] = new byte [bufferSize];
			
			// Receive packet from server 
			DatagramPacket inputPacket = new DatagramPacket (
					receiveData, receiveData.length);
			
			clientSocket.receive(inputPacket);
			
			// Unpack packet
			String countResult = new String (inputPacket.getData());
			System.out.print("Number of words in the sentence : " + countResult );
			
			
			
			clientSocket.close();
		
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		

	}

}
