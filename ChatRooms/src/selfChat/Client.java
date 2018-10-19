package selfChat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		GUI gui = new GUI("Client");

		Socket s = new Socket("localhost", 5454);

		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();

		MessageSender sender = new MessageSender(os);
		MessageReciever reciever = new MessageReciever(is);

		reciever.setGUI(gui);
		gui.setMessageSender(sender);

		new Thread(reciever).start();
	}

}
