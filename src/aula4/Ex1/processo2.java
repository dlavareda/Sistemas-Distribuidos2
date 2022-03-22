package aula4.Ex1;

public class processo2 extends Thread {
	int[] variavelPart;

	public processo2(int variavelPart[]) {
		super();
		setDaemon(true);
		this.variavelPart = variavelPart;
	}

	public synchronized void run() {
			while (true) {
				// secção crítica 2
				variavelPart[0] = variavelPart[0] + 1;

			}
		
	}
}
