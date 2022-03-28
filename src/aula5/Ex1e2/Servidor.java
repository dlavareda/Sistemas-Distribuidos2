package aula5.Ex1e2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket ss;
	private Socket s;
	private Connection c;

	public Servidor() {
		try {
			ss = new ServerSocket(5432);
		} catch (IOException e) {

		}
		try {
			while (true) {
				s = ss.accept();
				c = new Connection(s);
			}
		} catch (IOException e) {

		}
	}

	public static void main(String args[]) {
		Servidor dataHora = new Servidor();
	}
}