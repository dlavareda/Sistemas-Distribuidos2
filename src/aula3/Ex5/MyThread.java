package aula3.Ex5;

public class MyThread  extends Thread {
	public MyThread(ThreadGroup tg, String name) {
		super(tg, name);

	}

	public void run() {
		while (true) {
			System.out.println("Sou a " + this.getName());
			if (isInterrupted()) {
				break;
			}
			Thread.yield();
		}
	}
}