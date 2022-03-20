package aula0;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ex5 {

	public static void main(String[] args) throws IOException  {
		
        aluno a1 = new aluno(123456, "Diogo","Engenharia Informatica" );
        aluno a2 = new aluno(632154, "Ana","Engenharia Aeronautica");
        aluno a3 = new aluno(845987, "Susana","Biotecnologia");

        FileOutputStream file = null;
		try {
			file = new FileOutputStream("C:\\Users\\Diogo\\Documents\\UBI\\SD\\alunos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        ObjectOutputStream output = new ObjectOutputStream(file);
		output.writeObject(a1);
		output.writeObject(a2);
		output.writeObject(a3);

        output.close();

	}

}