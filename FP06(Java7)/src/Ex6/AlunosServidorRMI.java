package Ex6;

import java.net.*;
import java.rmi.*;

public class AlunosServidorRMI {
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
			AlunoInterface objRemoto = new AlunoImpl();

			// registar o objeto remoto no Registry
			Naming.rebind("AlunosServidorRMI", objRemoto);
			System.out.println("Remote object ready");
		} catch (MalformedURLException | RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
}
