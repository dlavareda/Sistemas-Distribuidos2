package aula2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import aula2.Aluno;

/*
 * Ja grava e le a Array List do ficheiro  
 * 
 */
public class AlunosServidor {
	@SuppressWarnings("unchecked")
	public AlunosServidor() {
		// Le do ficheiro e carrega no ArrayList em mem�ria
		FileInputStream fileStream = null;
		@SuppressWarnings("unused")
		ArrayList<Aluno> ListaAlunos2 = new ArrayList<Aluno>();
		try {
			fileStream = new FileInputStream(
					"/Users/dlavareda/Documents/UBI/Sistemas Distribuidos/GITHUB/Sistemas-Distribuidos2/src/aula2/alunos.txt");
			ObjectInputStream input = new ObjectInputStream(fileStream);
			ListaAlunos2 = (ArrayList<Aluno>) input.readObject();
			input.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// In�cio do servidor
		System.out.println("Processo Servidor");
		ServerSocket meuServidor = null;
		Socket sServidor = null;
		ObjectInputStream is;
		ObjectOutputStream os;
		int nAcessos = 0;
		try {
			while (true) {
				meuServidor = new ServerSocket(2222);
				sServidor = meuServidor.accept();
				is = new ObjectInputStream(sServidor.getInputStream());
				os = new ObjectOutputStream(sServidor.getOutputStream());
				char opt = (char) is.readObject();
				System.out.println("Pedido do tipo " + opt);
				if (opt == 'R') {
					nAcessos++;
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
									"/Users/dlavareda/Documents/UBI/Sistemas Distribuidos/GITHUB/Sistemas-Distribuidos2/src/aula2/alunos.txt");
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
					nAcessos++;
					os.writeObject(ListaAlunos2.toString());
					os.flush();
				} else if (opt == 'N') { // Consultar Numero de Acessos ao Servidor
					nAcessos++;
					os.writeObject(nAcessos);
					os.flush();
				} else if (opt == 'P') { // Pesquisa por Nome
					nAcessos++;
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
						os.writeObject("Aluno N�o Encontrado");
						os.flush();
					}
				} else {
					nAcessos++;
					System.out.println("Pedido mal formatado!");
				}
				os.close();
				is.close();
				meuServidor.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		AlunosServidor s = new AlunosServidor();

	}
}
