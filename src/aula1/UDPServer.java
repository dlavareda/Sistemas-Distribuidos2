package aula1;

import java.net.*;
import java.io.*;

public class UDPServer {
	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		String s;
		try {
			aSocket = new DatagramSocket(2222);
			System.out.println("<Server> Socket Datagram � escuta no porto 2222");
			while (true) {
				byte[] buffer = new byte[100];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				s = new String(request.getData());
				System.out.println("<Server> Server Recebeu: " + s);
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(),
						request.getPort());
				aSocket.send(reply);
			}
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
