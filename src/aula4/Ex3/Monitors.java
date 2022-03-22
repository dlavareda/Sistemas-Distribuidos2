package aula4.Ex3;

public class Monitors extends Thread {
	CriticaUm C;

	public Monitors(String nomeObjecto) {
		Thread Thread_a, Thread_b;
		C = new CriticaUm();
		Thread_a = new Thread(this, nomeObjecto + ":Thread a");
		Thread_b = new Thread(this, nomeObjecto + ":Thread b");
		Thread_a.start();
		Thread_b.start();
	}

	public void run() {
		C.method_A();
		C.method_B();
	}
}