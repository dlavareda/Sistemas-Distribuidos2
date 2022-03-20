package aula3.Ex3;

import java.util.Random;

/*
 * 
 * Calculo multithread da soma de 2 arrays, diferen�a visivel a partir do tamanho 90000000
 * 
 */
public class ThreadSomaMainMultiThread {
	public static void main(String[] args) {
		Random rd = new Random() ;
		int[] C = new int[90000000];
		int[] A = new int[90000000];
		for (int i = 0; i < A.length; i++) {
			A[i] = (Math.abs(rd.nextInt()))/2; //Prevenir numeros negativos
		}
		int[] B = new int[90000000];
		for (int i = 0; i < B.length; i++) {
			B[i] = (Math.abs(rd.nextInt()))/2; //Prevenir numeros negativos
		}
		ThreadSoma t1 = new ThreadSoma(A, B, C, 0, (C.length / 2));
		ThreadSoma t2 = new ThreadSoma(A, B, C, (C.length / 2), C.length);
		Thread Ta, Tb;
		Ta = new Thread(t1);
		Tb = new Thread(t2);
		long start_time = System.nanoTime();
		Ta.start();
		Tb.start();
		try {
			Ta.join();
			Tb.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
		System.out.println(difference);
	}
}