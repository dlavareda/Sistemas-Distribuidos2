package aula2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
Clientes do tipo �A�, depois de enviarem ao servidor o seu tipo, enviam um valor inteiro e
recebem como resposta o quadrado desse valor.
 */
public class clienteAEx3 {
	public clienteAEx3() {
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
					os.writeObject('A');
					os.flush();
					System.out.println("Introduza o numero a calcular o seu quadrado: ");
					int num = cx.nextInt();
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
		clienteAEx3 c = new clienteAEx3();
	}
}