package aula5.Ex4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class AlunosServidorMultiT {
	private ServerSocket ss;
	private Socket s;
	private Connection c;
	private nAcessos N = new nAcessos();
	final AtomicInteger clientesAtivos = new AtomicInteger(0);
	final int maxClientes = 5;

	public AlunosServidorMultiT() {

		try {
			ss = new ServerSocket(2222);
			while (true) {
				System.out.println(clientesAtivos.get());
				s = ss.accept();
				c = new Connection(s, N, clientesAtivos, maxClientes);
			}
		} catch (IOException e) {

		}
	}

	public static void main(String args[]) {
		AlunosServidorMultiT servidor = new AlunosServidorMultiT();
	}
}