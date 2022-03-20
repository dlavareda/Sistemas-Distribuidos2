package aula3.Ex4;

public class Daemon extends Thread {
	public Daemon() {
		super();
		setDaemon(true);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(" I'm a daemon Thread");
		}
	}
}