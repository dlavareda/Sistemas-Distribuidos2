package aula3.Ex5;


/*
 * Criados 2 grupos de Threads adicionada 1 thread ao grupo 1 e 3 ao grupo2
 * 
 */
public class Teste {
	public static void main(String[] arg) {
		MyThread Ta, Tb, Tc, Td;
		
		ThreadGroup Grupo1 = new ThreadGroup("Grupo1");
		ThreadGroup Grupo2 = new ThreadGroup("Grupo2");
		Grupo1 = Thread.currentThread().getThreadGroup();
		Grupo2 = Thread.currentThread().getThreadGroup();
		Ta = new MyThread(Grupo1, "Thread A");
		Tb = new MyThread(Grupo2, "Thread B");
		Tc = new MyThread(Grupo2, "Thread C");
		Td = new MyThread(Grupo2, "Thread D");
		// inicie a execu��o das Threads
		Ta.start();
		Tb.start();
		Tc.start();
		Td.start();
		Grupo1.interrupt();
		Grupo2.interrupt();
		System.out.println("O nome do grupo �: " + Grupo1.getName());
		System.out.println("O n� de Threads activas no grupo � " + Grupo1.activeCount());
		System.out.println("O nome do grupo �: " + Grupo2.getName());
		System.out.println("O n� de Threads activas no grupo � " + Grupo2.activeCount());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		
		
		
	}
}
