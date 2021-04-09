package Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTranslateLauncher {


	public static void main(String[] args) {
		
		
		ServerTranslateFrame serverFrame = new ServerTranslateFrame();
		serverFrame.setVisible(true);
		
		try {

			// Bind server socket to port 5217 or any port no
			ServerSocket serverSocket =new ServerSocket(4782);

			// Variable to keep tract number of request made to the server
			int totalRequest = 0;

			// Server needs to be alive
			while(true) {

				// Message indicating server is alive
				serverFrame.updateServerStatus(false);

				// Accept connection request
				Socket socket =serverSocket.accept();
				serverFrame.updateServerStatus(socket.isConnected());

				// Create input stream to read data to be processed from client
				DataInputStream ClientInput = new DataInputStream(socket.getInputStream());
				String text = ClientInput .readUTF();
		
				// Process text and get the total word count from the text
				ServerTranslationApplication translate = new ServerTranslationApplication();
				int totalWords = translate.countWord(text);

				// Create output stream to send output to the client
				DataOutputStream ClientOutput = new DataOutputStream(socket.getOutputStream());
				ClientOutput.writeInt(totalWords);

				// Close connection
				ClientInput .close();
				ClientOutput .close();
				socket.close();

				// Update request status
				serverFrame.updateRequestStatus("Word typed by Client : " + text);
				serverFrame.updateRequestStatus("Language Selected : " + totalWords);
				serverFrame.updateRequestStatus("Accept connection from client.  "
						+ "Total request = " + ++totalRequest);

			}
			
		} catch (Exception exception) {

			exception.printStackTrace();
			serverFrame.updateRequestStatus("DURIAN TUNGGAL, WE HAVE A PROBLEM!");
			serverFrame.updateRequestStatus("Exception: " + exception.getMessage());
		}
	}
		

}

