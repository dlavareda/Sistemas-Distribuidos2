package aula4.Ex2;


public class teste {
	public static void main(String[] args) {
		SalaCinema S = new SalaCinema("Fast and Furious", 0, 150);
		PontoVenda p1 = new PontoVenda(S, "Posto 1");
		PontoVenda p2 = new PontoVenda(S, "Posto 2");
		PontoVenda p3 = new PontoVenda(S, "Posto 3");
		p1.start();
		p2.start();
		p3.start();
	}
}
