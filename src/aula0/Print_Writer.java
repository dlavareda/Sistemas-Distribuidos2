package aula0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print_Writer {
		 public static void main (String args[]){
		 PrintWriter pw;
		 try {
		 pw = new PrintWriter ( new FileWriter ("C:\\Users\\Diogo\\Documents\\UBI\\SD\\testeSD.txt"));
		 pw.println(2.31);
		 pw.println(false);
		 pw.print("X");
		 pw.flush();
		 pw.close();
		 }
		 catch (IOException e){
		 System.out.println(e.getMessage());
		 }
		 try {
			Ler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 public static void Ler() throws IOException {
			BufferedReader br;
			br = new BufferedReader(new FileReader("C:\\Users\\Diogo\\Documents\\UBI\\SD\\testeSD.txt"));
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			}
}
