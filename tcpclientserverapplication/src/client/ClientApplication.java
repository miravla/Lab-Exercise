package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import ItemProduct.ItemProduct;






public class ClientApplication {

	public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo of Object Stream\n");

		// Request data
		ItemProduct itemProduct=new ItemProduct();
		itemProduct.setName("Airpods Pro");
		itemProduct.setPrice(699);
		

		try {

			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			String item=itemProduct.toString();
			// Send request to server
			System.out.println("Send object to server: " + item);
			objectOS.writeObject(itemProduct);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream and display details
			itemProduct = (ItemProduct) objectIS.readObject();
						
			// Get object from stream and display details
			String result = (String)objectIS.readObject();
			
			//output result
			System.out.println("Validation Result : "+ result);
			System.out.println (" Product ID : " + itemProduct.getItemProductid() );
			System.out.println ("Product Name : " + itemProduct.getName() );
			System.out.println("Product Price : RM "+ itemProduct.getPrice()+"\n");
		
			
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}