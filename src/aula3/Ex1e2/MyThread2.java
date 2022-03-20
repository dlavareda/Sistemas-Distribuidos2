package aula3.Ex1e2;

public class MyThread2 implements Runnable {
	public void run(){
		 System.out.println("Hi there, from " + Thread.currentThread().getName() );
		}
}
