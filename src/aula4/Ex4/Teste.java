package aula4.Ex4;

public class Teste extends Thread {
	Reentrant R;

	public Teste() {
		R = new Reentrant();
		Thread T = new Thread(this);
		T.start();
	}

	public void run() {
		R.myMethod();
	}

	public static void main(String args[]) {
		Teste T1 = new Teste();
	}
}