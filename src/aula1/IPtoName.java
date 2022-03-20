package aula1;

import java.net.*;
import java.io.*;

public class IPtoName {
	public static void main(String args[]) throws IOException {
		String s = " ";
		char c;
		System.out.print("IP address? ");
		while ((c = (char) System.in.read()) != 10)
			s += c;
		s = s.trim();
		InetAddress host = null;
		try {
			byte[] ipAddr = new byte[] { 127, 0, 0, 1 };
			System.out.println(InetAddress.getByAddress(ipAddr).getHostName());
		} catch (UnknownHostException e) {
			System.out.println("IP malformed ");
		}
	}
}
