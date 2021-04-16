package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ItemProduct.ItemProduct;



/**
 * This class demonstrate the application of ObjectInputStream and 
 * ObjectOutputStream at the server-side application.
 * 
 * How to run this program?
 * 
 * 1. Open Terminal
 * 2. Change the directory to /workspace-dad/demoObjectStream/bin
 * 3. Run -> java console.server.ServerSideApp
 * 
 * @author emalianakasmuri
 *
 */

public class ServerApplication {

	/**
	 * Main entry point of application
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			// Port to receive and respond to request
			int portNo = 4228;
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			int itemProductid=0, totalRequest =0;
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast to ItemProduct
				ItemProduct itemProduct = (ItemProduct) objectIS.readObject();
				

				// To validate product name
				Validation validation = new Validation();
				
				String result = validation.validateItemName(itemProduct);
				
				
				// Process object
				itemProduct.setItemProductid(++itemProductid);

				
				// Create output stream to send object
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
				objectOS.writeObject(itemProduct);
				
				
				
				System.out.println(" Total request : " + ++totalRequest);
				System.out.println(" Validation Result : " + result);
				System.out.println("Ready for next request");
				// Close all streams
				objectIS.close();
				objectOS.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}