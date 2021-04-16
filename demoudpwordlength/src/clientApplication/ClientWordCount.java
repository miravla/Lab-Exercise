package clientApplication;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientWordCount {

	public static void main(String[] args) {
		
		// server port which client going to connect
		final int serverPort=4228;
		int bufferSize = 1024;
		
		try {
			
			
			DatagramSocket clientSocket = new DatagramSocket();
			
			// Get the IP address of server
			InetAddress serverAddress = InetAddress.getByName("localhost");
			
			// Create buffer to send data
			byte sendDataBuffer [] = new byte [bufferSize];
			
			// Convert data to byte and store in buffer
			String sentence = "Do You Wanna Build A Snowman?";
			sendDataBuffer = sentence.getBytes();
			
			// Create UDP Packet
			DatagramPacket  outputPacket = new DatagramPacket(sendDataBuffer, 
					sendDataBuffer.length, serverAddress, serverPort);
			
			// Send packet to server
			clientSocket.send(outputPacket);
			
			
			// Create buffer to store receiving data 
			byte receiveDataBuffer [] = new byte [bufferSize];
			
			// Receive packet from server 
			DatagramPacket inputPacket = new DatagramPacket (
					receiveDataBuffer, receiveDataBuffer.length);
			
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
