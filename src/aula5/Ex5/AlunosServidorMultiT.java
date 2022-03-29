package aula5.Ex5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * 
 * BROKEN
 * To be fixed 
 * 
 */
public class AlunosServidorMultiT {
	private ServerSocket ss;
	private Socket s;
	private Connection c;
	private nAcessos N = new nAcessos();
	final AtomicInteger clientesAtivos = new AtomicInteger(0);


	public AlunosServidorMultiT() {
        ExecutorService pool = Executors.newFixedThreadPool(1);  
		try {
			ss = new ServerSocket(2222);
			while (true) {
				s = ss.accept();
				c = new Connection(s, N);
		        pool.execute(c);
			}
		} catch (IOException e) {

		}
        pool.shutdown();    
	}

	public static void main(String args[]) {
		AlunosServidorMultiT servidor = new AlunosServidorMultiT();
	}
}