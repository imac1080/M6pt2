package myFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) throws IOException {
		System.out.println("Escibe 10 lineas y se escriben");
		Scanner myObj = new Scanner(System.in);
		String[] texto = new String[10];
		File fichero1 = new File("src\\escribeLineas.txt");
		if (fichero1.createNewFile()) {
			System.out.println("File" + fichero1.getName() + " Created");
		}
		for (int i = 0; i < texto.length; i++) {
			texto[i] = myObj.nextLine();
		}
		FileWriter fichero = new FileWriter("src\\escribeLineas.txt");
		for (int i = 0; i < texto.length; i++) {
			fichero.write(texto[i] + System.getProperty("line.separator"));
		}
		fichero.close();
	}
}
