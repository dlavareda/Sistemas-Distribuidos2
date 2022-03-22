package aula4.Ex2;

public class SalaCinema {
	private String filme;
	private int ultimolugarvendido; // apresentará 0 até lotação
	private int lotacao;

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public int getUltimolugarvendido() {
		return ultimolugarvendido;
	}

	public void setUltimolugarvendido(int ultimolugarvendido) {
		this.ultimolugarvendido = ultimolugarvendido;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public int venderBilhete() {
		if (getUltimolugarvendido() < getLotacao()) {
			setUltimolugarvendido(getUltimolugarvendido() + 1);
			return getUltimolugarvendido();
		} else {
			return -1;
		}

	}

	public String filme() {
		return getFilme();
	}

	public int disponiveis() {
		return getUltimolugarvendido();
	}

	public SalaCinema() {
		super();
	}

	public SalaCinema(String filme, int ultimolugarvendido, int lotacao) {
		super();
		this.filme = filme;
		this.ultimolugarvendido = ultimolugarvendido;
		this.lotacao = lotacao;
	}

}
