package aula3.Ex3;

public class ThreadSoma implements Runnable {
	private int A[], B[], C[], p, u;

	public ThreadSoma(int A[], int B[], int C[], int p, int u) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.p = p;
		this.u = u;
	}

	public int[] getC() {
		return C;
	}
	public void run() {
		for (int i = p; i <= u - 1; i++) {
			C[i] = A[i] + B[i];
		}
	}

}
