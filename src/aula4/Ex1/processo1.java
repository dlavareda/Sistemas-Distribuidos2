package aula4.Ex1;

public class processo1 extends Thread {
	private int x, M, y;
	int[] variavelPart;

	public processo1(int variavelPart[]) {
		super();
		this.variavelPart = variavelPart;

	}

	public synchronized void run() {

			x = M;
			y = -M;
			while (true) {
				// secção crítica 1
				x = x - variavelPart[0];
				y = y + variavelPart[0];
				System.out.println(x);
				System.out.println(y);
				if (x + y != 0) {
					
					System.out.println("Secção crítica violada");
					break;
				} // fim do if
			} // fim do While
		}
	
}
