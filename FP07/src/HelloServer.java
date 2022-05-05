
import java.rmi.*;
import java.io.*;

public class HelloServer extends java.rmi.server.UnicastRemoteObject implements Hello_S_I {
	private static Hello_C_I client;

	public HelloServer() throws java.rmi.RemoteException {
		super();
	}

	// Método remoto
	public void printOnServer(String s) throws java.rmi.RemoteException {
		System.out.println(" SERVER : " + s);
	}

	// Método remoto
	public void subscribe(String name, Hello_C_I c) throws java.rmi.RemoteException {
		System.out.println("Subscribing " + name);
		client = c;
	}

	// Método local
	public static String lerString() {
		String s = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
			s = in.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}

	public static void main(String[] args) {
		String s;
		System.setSecurityManager(new SecurityManager());

		try {
			// Exercício:
			// - Lançar o registry
			try { // Iniciar a execução do registry no porto desejado
				java.rmi.registry.LocateRegistry.createRegistry(1099);
				System.out.println("RMI registry ready.");
			} catch (Exception e) {
				System.out.println("Exception starting RMI registry:");
			}
			HelloServer h = new HelloServer();
			Naming.rebind("Hello", h);
			while (true) {
				System.out.println("Mensagem para o cliente:");
				s = lerString();
				client.printOnClient(s);
			}
		} catch (RemoteException r) {
			System.out.println("Exception in server" + r.getMessage());
		} catch (java.net.MalformedURLException u) {
			System.out.println("Exception in server - URL");
		}
	}

	
}