package aula2;

import java.io.*;
import java.net.*;
import java.lang.Math;

/*
 * O processo Servidor recebe um valor do tipo char que identifica o tipo de cliente que
   est� a comunicar com ele
 */
public class servidorEx3 {
	public servidorEx3() {
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
				char opt = (char) is.readObject();
				System.out.println("Liga��o de cliente do tipo " + opt);
				if(opt == 'A') {
					int num = (int) is.readObject();
					os.writeObject(num*num);
					os.flush();
				}else if(opt == 'B') {
					double num = (double) is.readObject();
					os.writeObject(Math.sqrt(num));
					os.flush();
				}
				os.close();
				is.close();
				meuServidor.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String args[]) {
		servidorEx3 s = new servidorEx3();
	}
}