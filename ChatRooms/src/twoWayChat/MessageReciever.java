package twoWayChat;

import java.io.InputStream;
import java.util.Scanner;

public class MessageReciever implements Runnable {

	private Scanner s;
	private GUI gui;

	public MessageReciever(InputStream is) {
		s = new Scanner(is);
	}

	public void setGUI(GUI g) {
		gui = g;
	}

	public void recieve() {
		String message;
		while (true) {
			message = s.nextLine();
			gui.addMessage(message);
		}
	}

	@Override
	public void run() {
		recieve();
	}
}
