package aula1;

import java.net.InetAddress;

public class GetIP {
	public static void main(String args[]) throws Exception {
		InetAddress host = null;
		host = InetAddress.getLocalHost();
		byte ip[] = host.getAddress();
		for (int i = 0; i < ip.length; i++) {
			if (i > 0)
				System.out.print(".");
			System.out.print(ip[i] & 0xff);
		}
		System.out.println();
	}
}