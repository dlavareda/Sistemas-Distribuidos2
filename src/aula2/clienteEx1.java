package aula2;

import java.io.*;
import java.net.*;

public class clienteEx1 {
	public clienteEx1() {
		try {
			System.out.println("Processo Cliente");
			Socket sc = new Socket("127.0.0.1", 2222);
			ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
			System.out.println(is.readObject());
			os.writeObject(" Ol�, eu sou o cliente");
			os.flush();
			System.out.println(is.readObject());
			os.writeObject("Cliente: Continuo por aqui");
			os.flush();
			os.close();
			is.close();
			sc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		clienteEx1 c = new clienteEx1();
	}
}