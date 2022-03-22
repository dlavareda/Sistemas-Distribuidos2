package aula4.Ex1;


public class teste {
	
	public static void main(String[] args) {
		int[] variavelPart = {0};	
		processo1 p1 = new processo1(variavelPart);
		processo2 p2 = new processo2(variavelPart);
		
		// starting first 2 threads
		p1.start();
		p2.start();
		
		

	}
}
