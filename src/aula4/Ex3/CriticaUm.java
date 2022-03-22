package aula4.Ex3;

public class CriticaUm {
	public synchronized void method_A() {
		System.out.println(Thread.currentThread().getName() + " Método A");
		try {
			Thread.sleep((int) Math.round(Math.random() * 5000));
		} catch (InterruptedException e) {

		}
		System.out.println(Thread.currentThread().getName() + " Saindo do Método A");
	}

	public static synchronized void method_B() {
		System.out.println(Thread.currentThread().getName() + " Método B");
		try {
			Thread.sleep((int) Math.round(Math.random() * 5000));
		} catch (InterruptedException e) {

		}
		System.out.println(Thread.currentThread().getName() + " Saindo do Método B");
	}
}