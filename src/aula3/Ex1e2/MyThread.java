package aula3.Ex1e2;

public class MyThread extends Thread {
    public MyThread() {
        super("MyThread");
    }
    public void run() {
    	System.out.println("Hello there, from " + getName() );
    }
}