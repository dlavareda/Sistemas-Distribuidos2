package aula1;


import java.net.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.io.*;

class Task implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(4000); // 4Seg timeout
		return "Ready!";
	}
}

public class UDPClient {
	public static String readString() {
		BufferedReader canal;
		canal = new BufferedReader(new InputStreamReader(System.in));
		try {
			return canal.readLine();
		} catch (IOException ex) {
			return null;
		}
	}

	public static void main(String args[]) {
		String s = "";
		System.out.print("Qual o servidor? ");
		String host = readString();
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			while (true) {
				System.out.print("<Client> Mensagem a enviar = ");
				s = readString();
				if (s.equals("fim")) {
					System.out.println("A terminar a execuss�o");
					System.exit(0);
				}
				byte[] m = s.getBytes();
				InetAddress aHost = InetAddress.getByName(host);
				int serverPort = 2222;
				DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
				long t1 = System.currentTimeMillis();
				long t2 = 0;
				aSocket.send(request);
				byte[] buffer = new byte[100];
				ExecutorService executor = Executors.newSingleThreadExecutor();
				Future<String> future = executor.submit(new Task());
				try {
					System.out.println(future.get(3, TimeUnit.SECONDS));
					DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
					aSocket.receive(reply);

					System.out.println("<Client> Recebeu: " + new String(reply.getData()));
				} catch (TimeoutException | InterruptedException | ExecutionException e) {
					future.cancel(true);
					System.out.println("TimeOut na liga��o ao servidor!");
				}
				t2 = System.currentTimeMillis();
				executor.shutdownNow();
				System.out.println(t2 - t1);

			} // while
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}