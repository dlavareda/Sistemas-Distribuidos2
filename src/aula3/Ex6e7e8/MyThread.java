package aula3.Ex6e7e8;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);

	}

	public void run() {

		System.out.println("Sou a " + this.getName());

	}
}