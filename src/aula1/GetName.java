package aula1;

import java.net.InetAddress;

public class GetName {
	public static void main(String args[]) throws Exception {
		InetAddress host = null;
		host = InetAddress.getLocalHost();
		System.out.println(host.getHostName());
	}
}
