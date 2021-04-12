package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.java.accessibility.util.Translator;

public class ServerTranslateLauncher {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=null;
		try {
			
			// Bind server socket to a port
			int portNo=4228;
			serverSocket = new ServerSocket(portNo);
			
			ServerTranslateFrame serverFrame = new ServerTranslateFrame();
			serverFrame.setVisible(true);
			
			serverFrame.updateServerStatus(false);
			ServerTranslationApplication translate= new ServerTranslationApplication();
			int totalRequest=0;
			
			while(true)
			{
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				serverFrame.updateServerStatus(clientSocket.isConnected());
				
				
				int language,translatedWord;
				DataInputStream Input = new DataInputStream(clientSocket.getInputStream());
				language= Input.readInt();
				translatedWord= Input.readInt();
				
				
				String result = translate.chooseLanguage(language, translatedWord);
				
				// create stream to write data on network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				serverFrame.updateRequestStatus(result);
				// send data to client
				outputStream.writeUTF(result);
				outputStream.flush();
				
				
				serverFrame.updateRequestStatus("Sentence selected : "+ translatedWord);
				serverFrame.updateRequestStatus("Language selected : "+ language);
				Input.close();
				
				clientSocket.close();
				outputStream.close();
			}
			
			
			
		}catch(IOException ioe)
		{
			if(serverSocket!= null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
