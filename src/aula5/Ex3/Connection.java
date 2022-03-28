package aula5.Ex3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import aula2.Aluno;

public class Connection extends Thread {
	private Socket S;
	nAcessos N;

	public Connection(Socket s, nAcessos N) {
		super();
		S = s;
		this.N = N;
		start();
	}

	@SuppressWarnings("unchecked")
	public synchronized void run() {
		try {
			// Le do ficheiro e carrega no ArrayList em mem�ria
			FileInputStream fileStream = null;
			@SuppressWarnings("unused")
			ArrayList<Aluno> ListaAlunos2 = new ArrayList<Aluno>();
			try {
				fileStream = new FileInputStream(
						"/Users/dlavareda/Documents/UBI/Sistemas Distribuidos/GITHUB/Sistemas-Distribuidos2/src/aula5/Ex3/alunos.txt");
				ObjectInputStream input = new ObjectInputStream(fileStream);
				ListaAlunos2 = (ArrayList<Aluno>) input.readObject();
				input.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			ObjectInputStream is;
			ObjectOutputStream os;

			// In�cio do servidor
			System.out.println("Processo Servidor");
			is = new ObjectInputStream(S.getInputStream());
			os = new ObjectOutputStream(S.getOutputStream());
			char opt = (char) is.readObject();
			System.out.println("Pedido do tipo " + opt);
			if (opt == 'R') {
				N.inc();
				String nome = (String) is.readObject();
				int numero = (int) is.readObject();
				String curso = (String) is.readObject();
				String contato = (String) is.readObject();
				Aluno novoaluno = new Aluno(numero, nome, curso, contato);
				// Verifica se o aluno � duplicado
				boolean existe = false;
				for (Aluno aluno : ListaAlunos2) {
					if (aluno.getNumero() == novoaluno.getNumero()) {
						existe = true;
					}
				}
				if (existe) {
					os.writeObject(-1);
					os.flush();
				} else {
					ListaAlunos2.add(novoaluno);
					FileOutputStream file = null;
					try {
						file = new FileOutputStream(
								"/Users/dlavareda/Documents/UBI/Sistemas Distribuidos/GITHUB/Sistemas-Distribuidos2/src/aula5/Ex3/alunos.txt");
						ObjectOutputStream output;
						output = new ObjectOutputStream(file);
						output.writeObject(ListaAlunos2);
						output.close();
						os.writeObject(ListaAlunos2.size());
						os.flush();
					} catch (IOException e) { // TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (opt == 'C') { // Listar Alunos Registados
				N.inc();
				os.writeObject(ListaAlunos2.toString());
				os.flush();
			} else if (opt == 'N') { // Consultar Numero de Acessos ao Servidor
				N.inc();
				os.writeObject(N.get());
				os.flush();
			} else if (opt == 'P') { // Pesquisa por Nome
				N.inc();
				String nome = (String) is.readObject();
				boolean existe = false;
				for (Aluno aluno : ListaAlunos2) {
					if (aluno.getNome().compareTo(nome) == 0) {
						os.writeObject(aluno.toString());
						os.flush();
						existe = true;
					}
				}
				if (existe == false) {
					os.writeObject("Aluno Não Encontrado");
					os.flush();
				}
			} else {
				N.inc();
				System.out.println("Pedido mal formatado!");
			}
			os.close();
			is.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
