

import java.rmi.Naming;

public class RMIClient {
	@SuppressWarnings("removal")
	public static void main(String[] argv) {

		System.setSecurityManager(new SecurityManager());

		try {
			// bind server object to object in client
			RMIInterface myServerObject = (RMIInterface) Naming.lookup("RMIImpl");
//invoke method on server object
			myServerObject.adiciona("XPTO");
			System.out.println(myServerObject.consulta());
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			System.exit(0);
		}
		System.out.println("RMI connection successful");
	}
}