package aula4.Ex2;

public class PontoVenda extends Thread {
	SalaCinema SC = new SalaCinema();
	String posto;
	public PontoVenda(SalaCinema SC, String posto) {
		super();
		this.SC = SC;
		this.posto = posto;
	}

	public void run() {
		int pausa;
		while (true) {
			try {
				pausa = (int) (Math.random() * 2000);
				//pausa = 2 //alínea d
				sleep(pausa);
				System.out.println(posto + " vendeu o bilhete " + SC.venderBilhete() + " para o filme " + SC.filme());
				if (SC.disponiveis() == 0) {
					System.out.println(posto + " fim");
					break;
				}
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
