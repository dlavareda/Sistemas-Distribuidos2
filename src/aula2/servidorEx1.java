package aula2;

import java.io.*;
import java.net.*;

public class servidorEx1 {
	public servidorEx1() {
		System.out.println("Processo Servidor");
		ServerSocket meuServidor = null;
		Socket sServidor = null;
		ObjectInputStream is;
		ObjectOutputStream os;
		try {
			while (true) {
				meuServidor = new ServerSocket(2222);
				sServidor = meuServidor.accept();
				is = new ObjectInputStream(sServidor.getInputStream());
				os = new ObjectOutputStream(sServidor.getOutputStream());
				os.writeObject(" Ol�, eu sou o servidor");
				os.flush();
				System.out.println(is.readObject());
				os.writeObject("Servidor: Continuo por aqui");
				os.flush();
				System.out.println(is.readObject());
				os.close();
				is.close();
				meuServidor.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String args[]) {
		servidorEx1 s = new servidorEx1();
	}
}