package twoWayChat;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MessageSender {

	private PrintWriter pw;
	private Scanner s;

	public MessageSender(OutputStream os) {

		pw = new PrintWriter(os);
		s = new Scanner(System.in);

	}

	public void send(String message) {
		pw.println(message);
		pw.flush();
	}

}
