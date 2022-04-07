package Ex5;

import java.rmi.*;

public class CalculatorServer {
	public CalculatorServer() {
		System.setSecurityManager(new SecurityManager());
		try {
			Calculator c = new CalculatorImpl();
			Naming.rebind("rmi://localhost:1099/CalculatorService", c);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new CalculatorServer();
	}
}