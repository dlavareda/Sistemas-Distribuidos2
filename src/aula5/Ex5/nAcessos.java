package aula5.Ex5;
/*
 * 
 * Classe criada para a partilha dos dados do numero de acessos cumulativos ao servidor 
 */
public class nAcessos {
	private int nAcessos;
	public nAcessos() {
		nAcessos = 0;
	}
	public synchronized int get() {
		return nAcessos;
	}
	public synchronized void inc() {
		nAcessos++;
	}
}
