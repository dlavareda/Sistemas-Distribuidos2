package com.example.demo;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity // This tells Hibernate to make a table out of this class
public class Professor {
	@Id // depId is the primary key
	private Integer profId;
	private String nome;
	private Integer dptId;

	public Integer getProfId() {
		return profId;
	}

	public void setProfId(Integer profId) {
		this.profId = profId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDptId() {
		return dptId;
	}

	public void setDptId(Integer dptId) {
		this.dptId = dptId;
	}

	@Override
	public String toString() {
		return "Professor [profId=" + profId + ", nome=" + nome + ", dptId=" + dptId + "]";
	}
}
