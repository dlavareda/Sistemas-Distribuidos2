package Ex5;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			Calculator c = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
			System.out.println(c.sub(4, 3));
			System.out.println(c.add(4, 5));
			System.out.println(c.mul(3, 6));
			System.out.println(c.div(9, 3));
		} catch (RemoteException | MalformedURLException | NotBoundException re) {
			System.out.println("RemoteException");
			System.out.println(re.getMessage());
		}
	}
}