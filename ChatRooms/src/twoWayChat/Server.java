package twoWayChat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {

		GUI gui = new GUI("Server");

		ServerSocket ss = new ServerSocket(5454);
		Socket s = ss.accept();

		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();

		MessageSender sender = new MessageSender(os);
		MessageReciever reciever = new MessageReciever(is);

		reciever.setGUI(gui);
		gui.setMessageSender(sender);

		new Thread(reciever).start();

	}
}
