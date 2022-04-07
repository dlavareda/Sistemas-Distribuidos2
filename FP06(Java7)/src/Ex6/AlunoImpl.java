package Ex6;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class AlunoImpl extends UnicastRemoteObject implements AlunoInterface {
	ArrayList<Aluno> listaAlunos;
	int acessos = 0;
	public AlunoImpl() throws java.rmi.RemoteException {
		super();
		listaAlunos = new ArrayList<Aluno>();
	}
	
	public boolean adicionarAluno(int numero, String nome, String curso, String contacto)  throws java.rmi.RemoteException{
		Aluno A = new Aluno(numero, nome, curso, contacto);
		listaAlunos.add(A);
		acessos++;
		return true;
	}
	public ArrayList<Aluno> listaAlunos()  throws java.rmi.RemoteException{
		acessos++;
		return listaAlunos;
	}
	public int getAcessos() throws java.rmi.RemoteException {
		return acessos;
	}
	public Aluno pesquisaAluno(String nome) throws java.rmi.RemoteException{
		for (Aluno aluno : listaAlunos) {
			if (aluno.getNome().compareTo(nome) == 0) {
				return aluno;
			}
		}
		return null;
	}
}