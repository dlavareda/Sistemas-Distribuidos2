package aula3.Ex3;

import java.util.Random;
/*
 * Calculo sequencial da soma de 2 arrays, diferen�a visivel a partir do tamanho 90000000
 * 
 */
public class ThreadSomaMainSingleThread {
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
		long start_time = System.nanoTime();
		for (int i = 0; i < A.length; i++) {
			C[i] = A[i] + B[i];
		}
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
		System.out.println(difference);
	}
}