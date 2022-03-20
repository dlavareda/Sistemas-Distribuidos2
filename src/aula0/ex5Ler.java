package aula0;
/* Falta resolver a excep��o de chegar ao fim do ficheiro
* 
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ex5Ler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream("C:\\Users\\Diogo\\Documents\\UBI\\SD\\alunos.txt");
			ObjectInputStream input = new ObjectInputStream(fileStream);
			aluno novoAluno;
			while ((novoAluno = (aluno) input.readObject()) != null) {
				System.out.println(novoAluno.getNumero());
				System.out.println(novoAluno.getNome());
				System.out.println(novoAluno.getCurso());
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
