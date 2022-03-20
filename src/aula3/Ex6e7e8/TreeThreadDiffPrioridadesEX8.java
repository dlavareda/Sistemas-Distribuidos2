package aula3.Ex6e7e8;

/*
 * Confirma-se que no caso da execuss�o abaixo a Thread C termina antes da Thread B
 */
public class TreeThreadDiffPrioridadesEX8 {
	public static void main(String[] arg) {
		MyThread Ta = new MyThread("Thread A");
		Ta.setPriority(Thread.MAX_PRIORITY);
		MyThread Tb = new MyThread("Thread B");
		Tb.setPriority(Thread.MIN_PRIORITY);
		MyThread Tc = new MyThread("Thread C");
		Ta.start();
		Tb.start();
		Tc.start();
		System.out.println("Prioridade Thread A: " + Ta.getPriority());
		System.out.println("Prioridade Thread B: " + Tb.getPriority());
		System.out.println("Prioridade Thread C: " + Tc.getPriority());
	}

}