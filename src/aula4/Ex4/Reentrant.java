package aula4.Ex4;

public class Reentrant {
	static int times = 1;

	public synchronized void myMethod() {
		int i = times++;
		System.out.println("myMethod has started " + i + " time(s)");
		while (times < 4)
			myMethod();
		System.out.println("myMethod has exited " + i + " time(s)");
	}
}