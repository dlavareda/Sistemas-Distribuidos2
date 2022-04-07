package Ex6;

import java.util.ArrayList;

public interface AlunoInterface extends java.rmi.Remote {
	public boolean adicionarAluno(int numero, String nome, String curso, String contacto)
			throws java.rmi.RemoteException;

	public ArrayList<Aluno> listaAlunos() throws java.rmi.RemoteException;
	public int getAcessos() throws java.rmi.RemoteException;
	public Aluno pesquisaAluno(String nome) throws java.rmi.RemoteException;
}
