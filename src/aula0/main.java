package aula0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static void main(String args[]) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\Diogo\\Documents\\UBI\\SD\\testeSD.txt"));
			bw.write('1');
			bw.newLine();
			bw.write('2');
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			Ler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void Ler() throws IOException {
		BufferedReader br;
		br = new BufferedReader(new FileReader("C:\\Users\\Diogo\\Documents\\UBI\\SD\\testeSD.txt"));
	    String line;
		while ((line = br.readLine()) != null) {
	 	   System.out.println(line);
		 }
	}
}