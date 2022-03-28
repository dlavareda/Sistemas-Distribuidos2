package aula5.Ex4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AlunosCliente {
	public AlunosCliente() {
		Scanner cx = new Scanner(System.in);
		while (true) {
			System.out.println("Escolha a opção a realizar");
			System.out.println("1 - Registar Aluno");
			System.out.println("2 - Listar Alunos Registados");
			System.out.println("3 - Consultar Numero de Acessos ao Servidor");
			System.out.println("4 - Pesquisa por Nome");
			System.out.println("5 - Sair");
			String opt = cx.next();

			if (opt.compareTo("1") == 0) { // Registar Aluno
				try {
					System.out.println("Registo de Novo Aluno");
					Socket sc = new Socket("127.0.0.1", 2222);
					ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
					os.writeObject('R');
					os.flush();
					System.out.println("Nome: ");
					String nome = cx.next();
					os.writeObject(nome);
					os.flush();
					System.out.println("Numero: ");
					int num = cx.nextInt();
					os.writeObject(num);
					os.flush();
					System.out.println("Curso: ");
					String curso = cx.next();
					os.writeObject(curso);
					os.flush();
					System.out.println("Contato: ");
					String contato = cx.next();
					os.writeObject(contato);
					os.flush();
					int count = (int) is.readObject();
					if (count != -1) {
						System.out.println("Ja foram registados " + count + " alunos.");
					} else {
						System.out.println("O aluno já existe");
					}
					os.close();
					is.close();
					sc.close();

				} catch (IOException|ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else if (opt.compareTo("2") == 0) { // Listar Alunos Registados
				System.out.println("Listagem de Alunos");
				try {
					Socket sc = new Socket("127.0.0.1", 2222);
					ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
					;
					os.writeObject('C');
					os.flush();
					System.out.println((String) is.readObject());
					os.close();
					is.close();
					sc.close();

				} catch (IOException|ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			} else if (opt.compareTo("3") == 0) { // Consultar Numero de Acessos ao Servidor
				System.out.println("Consulta Numero Acessos ao Servidor");
				try {
					Socket sc = new Socket("127.0.0.1", 2222);
					ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
					;
					os.writeObject('N');
					os.flush();
					System.out.println("Fora realizados " + (int) is.readObject() + " acessos ao servidor!");
					os.close();
					is.close();
					sc.close();

				} catch (IOException|ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else if (opt.compareTo("4") == 0) { // Pesquisa por Nome
				System.out.println("Pesquisa por Nome");
				try {
					Socket sc = new Socket("127.0.0.1", 2222);
					ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(sc.getInputStream());
					;
					os.writeObject('P');
					os.flush();
					System.out.println("Nome: ");
					String nome = cx.next();
					os.writeObject(nome);
					os.flush();
					System.out.println((String) is.readObject());
					os.close();
					is.close();
					sc.close();

				} catch (IOException|ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			} else {
				System.exit(0);
			}
		}
	}

	public static void main(String args[]) {
		AlunosCliente c = new AlunosCliente();
	}
}
