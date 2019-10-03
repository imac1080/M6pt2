import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ex5 {
	public static void main(String[] args) throws IOException {
		File fichero1 = new File("src\\frasesMatrix.txt");
		if (fichero1.createNewFile()) {
			System.out.println("File" + fichero1.getName() + " Created");
		} else {
			System.out.println("File " + fichero1.getName() + " already exists");
		}
		FileWriter fichero = new FileWriter("src\\frasesMatrix.txt");
		fichero.write("Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar.");
		fichero.close();
	}
}
