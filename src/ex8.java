import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ex8 {
	public static void main(String[] args) throws IOException {
		Map<String, Float> nombreMap = new <String, Float>TreeMap();
		Scanner myObj = new Scanner(System.in);
		boolean exit = true;
		File ficheroDatos = new File("src\\ex8.txt");
		String cod_map;
		while (exit) {
			System.out.println(
					"\nMENU\n1. INSERTAR\n2. MODIFICAR\n3. BORRAR\n4. MOSTRAR PRODUCTOS\n5. GUARDAR EN FICHERO\n6. LEER DE FICHERO");
			int option = myObj.nextInt();
			myObj.nextLine();
			if (option == 1) {
				System.out.println("ESCRIU EL NOM DEL JOC");
				String nomJoc = myObj.nextLine();
				if (!nomJoc.equals("")) {
					if (nombreMap.containsKey(nomJoc.toLowerCase())) {
						System.out.println(nomJoc + " JA ESTA INTRODUIT");
					} else {
						System.out.println("DIGUES EL PREU DEL JOC");
						nombreMap.put(nomJoc.toLowerCase(), myObj.nextFloat());
						myObj.nextLine();
					}
				}
			} else if (option == 2) {
				if (nombreMap.isEmpty() == false) {
					System.out.println("ESCRIU EL NOM DEL JOC QUE VULGUIS MODIFICAR");
					String nomJoc = myObj.nextLine();
					if (!nomJoc.equals("")) {
						if (nombreMap.containsKey(nomJoc.toLowerCase())) {
							System.out.println("DIGUES EL PREU DEL JOC");
							nombreMap.put(nomJoc.toLowerCase(), myObj.nextFloat());
							myObj.nextLine();
						} else {
							System.out.println(nomJoc + " NO ESTA INTRODUIT");
						}
					}
				} else {
					System.out.println("EL MAP ESTA VUIT");
				}

			} else if (option == 3) {
				if (nombreMap.isEmpty() == false) {
					System.out.println("ESCRIU EL NOM DEL JOC QUE VULGUIS BORRAR");
					String nomJoc = myObj.nextLine();
					if (!nomJoc.equals("")) {
						if (nombreMap.containsKey(nomJoc.toLowerCase())) {
							nombreMap.remove(nomJoc.toLowerCase());
						} else {
							System.out.println(nomJoc + " NO ESTA INTRODUIT");
						}
					}
				} else {
					System.out.println("EL MAP ESTA VUIT");
				}

			} else if (option == 4) {
				if (nombreMap.isEmpty() == false) {
					Iterator it = nombreMap.keySet().iterator();
					while (it.hasNext()) {
						cod_map = (String) it.next();
						System.out.println(cod_map + ": " + nombreMap.get(cod_map));

					}
				} else {
					System.out.println("EL MAP ESTA VUIT");
				}
			} else if (option == 5) {
				if (nombreMap.isEmpty() == false) {
					if (ficheroDatos.createNewFile()) {
						System.out.println("File " + ficheroDatos.getName() + " Created");
					}
					Iterator it = nombreMap.keySet().iterator();
					FileWriter ficheroDatosEscribir = new FileWriter("src\\ex8.txt");
					while (it.hasNext()) {
						cod_map = (String) it.next();
						ficheroDatosEscribir.write(cod_map + " separator " + nombreMap.get(cod_map)
								+ System.getProperty("line.separator"));
					}
					System.out.println("Elements guardats en el arxiu");
					ficheroDatosEscribir.close();
				} else {
					System.out.println("EL MAP ESTA VUIT");
				}
			} else if (option == 6) {
				if (!(ficheroDatos.exists())) {
					System.out.println("EL FIXER DE DADES NO EXISTEIX");
				} else {
					Scanner s = new Scanner(ficheroDatos);
					while (s.hasNextLine()) {
						String linea = s.nextLine(); // Guardamos la linea en un String
						String[] lineaSplit = linea.split(" separator ");
						if (nombreMap.containsKey(lineaSplit[0].toLowerCase())) {
						} else {
							nombreMap.put(lineaSplit[0].toLowerCase(), Float.parseFloat(lineaSplit[1]));
						}
					}
					System.out.println("Elements guardats en el map");
				}
			}

		}
		System.out.println(nombreMap.values());
	}
}
