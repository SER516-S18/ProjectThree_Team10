package test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectsOverServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ObjectsOverServer().runServer();
	}

	public void runServer(){
		try {
			ServerSocket ss = new ServerSocket(5005);
			while(true){
				Socket socket = ss.accept();
				System.out.println("Accepted Request!!");
				new ThreadedServer(socket).start();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

class ThreadedServer extends Thread{
	Socket socket = null;
	ObjectInputStream in = null;

	ObjectOutputStream out;
	public ThreadedServer(Socket socket) {
		this.socket = socket; 
	}


	public void run()
	{
		//		try {
		//			in = new ObjectInputStream(socket.getInputStream());
		//			System.out.println("Data coming "  + in.available());
		//			 Message username;
		//		        try {
		//
		//		            username = (Message) in.readObject();
		//
		//		            System.out.println(username.type);
		//
		//		        } catch (ClassNotFoundException cnf) {
		//
		//		            cnf.printStackTrace();
		//
		//		        } catch (IOException io) {
		//
		//		            io.printStackTrace();
		//
		//		        }
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			System.out.println("Data not coming ");
		//			e.printStackTrace();
		//		}

		try {
			Message message = new Message();
			message.type = "hi from server";
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Message implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	public  final long serialVersionUID = 1L;
	public int messageId = 0;
	public String type ;
}
