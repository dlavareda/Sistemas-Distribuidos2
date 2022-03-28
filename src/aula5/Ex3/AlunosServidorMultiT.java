package aula5.Ex3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AlunosServidorMultiT {
	private ServerSocket ss;
	private Socket s;
	private Connection c;
	private nAcessos N = new nAcessos();
	
	public AlunosServidorMultiT() {
		try {
			ss = new ServerSocket(2222);
		} catch (IOException e) {

		}
		try {
			while (true) {
				s = ss.accept();
				c = new Connection(s, N);
			}
		} catch (IOException e) {

		}
	}

	public static void main(String args[]) {
		AlunosServidorMultiT servidor = new AlunosServidorMultiT();
	}
}