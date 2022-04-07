package Ex6;

import java.io.Serializable;
import java.util.Objects;

public class Aluno implements Serializable{
    private int numero;
    private String nome;
    private String curso;
    private String contacto;
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
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	@Override
	public String toString() {
		return "[numero=" + numero + ", nome=" + nome + ", curso=" + curso + ", contacto=" + contacto + "]\n";
	}
	public Aluno(int numero, String nome, String curso, String contacto) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.curso = curso;
		this.contacto = contacto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contacto, curso, nome, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(contacto, other.contacto) && Objects.equals(curso, other.curso)
				&& Objects.equals(nome, other.nome) && numero == other.numero;
	}
    
}

    