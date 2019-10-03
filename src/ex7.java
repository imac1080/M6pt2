import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ex7 {
	public static void main(String[] args) throws IOException {
		System.out.println(
				"Digues cp + el primer argumento es la ruta del fichero a copiar + el segundo argumento es la ruta del fichero copia.");
		Scanner myObj = new Scanner(System.in);
		String[] texto = { "" };
		String comanda = myObj.nextLine();
		texto = comanda.split(" ");
		while (!(texto[0].equals("cp"))) {
			System.out.println("comanda " + texto[0] + " no reconeguda");
			System.out.println("Intenta posar cp");
			comanda = myObj.nextLine();
			texto = comanda.split(" ");
		}
		File ficheroLeer = new File(texto[1]);
		File ficheroEscribir = new File(texto[2]);
		if (ficheroEscribir.createNewFile()) {
			System.out.println("File" + ficheroEscribir.getName() + " Created");
		}
		FileWriter ficheroEscribir2 = new FileWriter(texto[2]);
		Scanner s = null;

		try {
			s = new Scanner(ficheroLeer);
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // Guardamos la linea en un String
				ficheroEscribir2.write(linea + System.getProperty("line.separator"));
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		ficheroEscribir2.close();
	}
}
