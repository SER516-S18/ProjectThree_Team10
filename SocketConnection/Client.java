package test;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
 
public class Client {
	
	private static SocketAddress address;
	private static Socket socket;
	private static ObjectOutputStream out;
	private static ObjectInputStream in = null;
	
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 5005;
		
		address = new InetSocketAddress(ip, port);
		socket = new Socket();
		try {
			socket.connect(address);
			System.out.println("Connected!");
			out = new ObjectOutputStream(socket.getOutputStream());
 
//			Message msg = new Message();
//			msg.type = " send";
//			out.writeObject(msg);
//			System.out.println("Message sent!");
 
			
			
				in = new ObjectInputStream(socket.getInputStream());
				System.out.println("Data coming "  + in.available());
				 Message username;   
				 username = (Message) in.readObject();
				 System.out.println("data from Server : " + username.type);
	

			} 		
		 catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
			
			socket.close();
			System.out.println("Socket closed.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
}
