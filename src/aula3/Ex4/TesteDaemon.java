package aula3.Ex4;


/*
 * 
 * A Thread Daemon para a execuss�o assim que a Thread Normal termina a execuss�o 5 execuss�es
 * Ao transformar a Thread Daemon em normal executa 10x
 */
public class TesteDaemon {
	public static void main(String[] args) {

		Daemon d1 = new Daemon();
		Normal n2 = new Normal();

		// starting first 2 threads
		d1.start();
		n2.start();

	}
}
