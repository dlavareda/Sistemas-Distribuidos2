import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {
	public static void main(String[] argv) {

		System.setSecurityManager(new SecurityManager());

		try {
			// bind server object to object in client
			RMIInterface myServerObject = (RMIInterface) Naming.lookup("RMIImpl");
			Scanner ReadConsole = new Scanner(System.in);
//invoke method on server object
			int seleccao = 0;
			do {

				System.out.println("[1] - Adicionar XPTO");
				System.out.println("[2] - Consultar Lista");
				System.out.println("[3] - Mostrar Contador");
				System.out.println("[4] - Sair");
				System.out.print("Introduza a Selecção: ");
				seleccao = ReadConsole.nextInt();
				switch (seleccao) {
					case 1:
						myServerObject.adiciona("XPTO");
					case 2:
						System.out.println(myServerObject.consulta());
					case 3:
						System.out.println(myServerObject.getCount());
				}
			} while (seleccao != 4);

		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			System.exit(0);
		}
		System.out.println("RMI connection successful");
	}
}