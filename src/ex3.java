
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ex3 {
	public static void main(String[] args) throws IOException {
		File theDir = new File("src\\myFiles");
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
			}
			if (result) {
				System.out.println("DIR created");
			}
		} else {
			System.out.println("El directori ja existeix");
		}
		File fichero1 = new File("src\\myFiles\\fichero1.txt");
		if (fichero1.createNewFile()) {
			System.out.println("File" + fichero1.getName() + " Created");
		} else {
			System.out.println("File " + fichero1.getName() + " already exists");
		}

		File fichero2 = new File("src\\myFiles\\fichero2.txt");
		if (fichero2.createNewFile()) {
			System.out.println("File" + fichero2.getName() + " Created");
		} else {
			System.out.println("File " + fichero2.getName() + " already exists");
		}

		if (fichero2.renameTo(new File("src\\myFiles\\ficheroRenombrado.txt"))) {
			System.out.println("Rename succesful");
		} else {
			System.out.println("Rename failed");
		}

		try {
			File[] files = theDir.listFiles();
			System.out.println("Files are:");
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		fichero1.delete();
		try {
			File[] files = theDir.listFiles();
			System.out.println("Files are:");
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
