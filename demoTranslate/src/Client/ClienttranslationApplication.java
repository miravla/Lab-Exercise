package Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClienttranslationApplication{
public static void main(String[] args){
	try{
		Socket socket = new Socket(InetAddress.getLocalHost(),4228);
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String text=bufferedReader.readLine();
		System.out.println(text);
		bufferedReader.close();
		socket.close();
		}catch(IOException e){
		e.printStackTrace();
}
}
}