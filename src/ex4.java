import java.io.File;
import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Digues la ruta del fixer");
		String fixerNom = myObj.nextLine();
		File fixer = new File(fixerNom);
		while (fixer.isDirectory()) {
			System.out.println(fixerNom + " no es un fichero, es un directorio.");
			System.out.println("Digues un nou nom");
			fixerNom = myObj.nextLine();
			fixer = new File(fixerNom);
		}
		Scanner s = null;
		try {
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fixer);
			while (s.hasNextLine()) {
				String linea = s.next(); // Guardamos la linea en un String
				System.out.println(linea); // Imprimimos la linea
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

	}
}
