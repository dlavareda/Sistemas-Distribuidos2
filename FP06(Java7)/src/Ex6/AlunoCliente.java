package Ex6;

import java.rmi.Naming;
import java.util.Scanner;

public class AlunoCliente {
	public static void main(String[] argv) {

		System.setSecurityManager(new SecurityManager());

		try {
			// bind server object to object in client
			AlunoInterface myServerObject = (AlunoInterface) Naming.lookup("AlunosServidorRMI");
			Scanner ReadConsole = new Scanner(System.in);
			String nome;
//invoke method on server object
			int seleccao = 0;
			do {
				System.out.println("[1] - Registar Aluno");
				System.out.println("[2] - Consultar Alunos");
				System.out.println("[3] - Consultar numero de Acessos");
				System.out.println("[4] - Procurar Aluno");
				System.out.println("[5] - Sair");
				System.out.print("Introduza a Selecção: ");
				seleccao = ReadConsole.nextInt();
				switch (seleccao) {
				case 1:
					System.out.println("Numero: ");
					int numero = ReadConsole.nextInt();
					System.out.print("Nome: ");
					nome = ReadConsole.next();
					System.out.print("Curso: ");
					String curso = ReadConsole.next();
					System.out.print("Contacto: ");
					String contacto = ReadConsole.next();
					myServerObject.adicionarAluno(numero, nome, curso, contacto);
				    break;
				case 2:
					System.out.println(myServerObject.listaAlunos());
				    break;
				case 3:
					System.out.println(myServerObject.getAcessos());
				    break;
				case 4:
					System.out.println("Nome: ");
					nome = ReadConsole.next();
					Aluno A = myServerObject.pesquisaAluno(nome);
					if(A != null) {
						System.out.println("Numero: " + A.getNumero());
						System.out.println("Contacto: " + A.getContacto());
					}else {
						System.out.println("Aluno não encontrado!!");
					}
				    break;
				}

			} while (seleccao != 5);

		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			System.exit(0);
		}
		System.out.println("RMI connection successful");
	}
}