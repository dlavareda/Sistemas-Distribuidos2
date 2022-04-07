

import java.net.*;
import java.rmi.*;

public class RMIServer {
	@SuppressWarnings("removal")
	public static void main(String[] argv) {
		System.setSecurityManager(new SecurityManager());
		try { // Iniciar a execução do registry no porto desejado
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");
		} catch (Exception e) {
			System.out.println("Exception starting RMI registry:");
		}
		try {
			// instanciar objeto remoto
			RMIInterface objRemoto = new RMIImpl();

			// registar o objeto remoto no Registry
			Naming.rebind("RMIImpl", objRemoto);
			System.out.println("Remote object ready");
		} catch (MalformedURLException | RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
}