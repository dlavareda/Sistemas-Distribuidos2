package aula3.Ex1e2;

public class TesteRunable {
	
	public static void main (String[] str){
	 MyThread2 T = new MyThread2();
	 Thread Ta, Tb;
	 Ta = new Thread(T);
	 Tb = new Thread(T);
	 Ta.start();
	 Tb.start();
	} }

