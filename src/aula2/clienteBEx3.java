package aula2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
 * Clientes do tipo �B�, depois de enviarem ao servidor o seu tipo, enviam um valor do tipo double
   e recebem como resposta a raiz quadrada desse valor. 
 */
public class clienteBEx3 {
	public clienteBEx3() {
		Scanner cx = new Scanner(System.in);
		while (true) {
			System.out.println("Deseja efetuar uma opera��o (y/n))");
			String opt = cx.next();
			if (opt.compareTo("y") == 0) {

				try {
					System.out.println("Processo Cliente");
					Socket sc = new Socket("127.0.0.1", 2222);
					ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
					os.writeObject('B');
					os.flush();
					System.out.println("Introduza o numero a calcular a sua ra�z: ");
					double num = cx.nextDouble();
					os.writeObject(num);
					os.flush();
					System.out.println(is.readObject());
					os.close();
					is.close();
					sc.close();

				} catch (IOException e) {
					System.out.println(e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("A terminar liga��o");
				System.exit(0);
			}
		}
	}

	public static void main(String args[]) {
		clienteBEx3 c = new clienteBEx3();
	}
}