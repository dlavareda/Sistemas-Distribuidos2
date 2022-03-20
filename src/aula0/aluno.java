package aula0;

import java.io.Serializable;

public class aluno implements Serializable {

	private int numero;
	private String nome;
	private String curso;
	
	public aluno(int numero, String nome, String curso) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.curso = curso;
	}
	
	public aluno(String nome) {
		super();
		this.nome = nome;
	}
	

	public aluno(int numero) {
		super();
		this.numero = numero;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}