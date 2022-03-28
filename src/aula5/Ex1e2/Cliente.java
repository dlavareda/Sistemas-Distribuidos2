package aula5.Ex1e2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {
	private Socket s;

	public Cliente() {
		try {
			s = new Socket("127.0.0.1", 5432);
			ObjectInputStream is = new ObjectInputStream(s.getInputStream());
			System.out.println(is.readObject());
			System.out.println(is.readObject());
			s.close();
		} // try
		catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} // construtor

	public static void main(String args[]) {
		Cliente c = new Cliente();
	}
}