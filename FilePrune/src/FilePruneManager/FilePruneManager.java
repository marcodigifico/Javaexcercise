package FilePruneManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Data.Data;

public class FilePruneManager {

	ArrayList<Data> files;

	public FilePruneManager() {
		files = new ArrayList<Data>();

	}

	public ArrayList<Data> fetchFile(String path) throws FileNotFoundException {
		File file = new File(path);
		int i = 0;
		Scanner fileReader = new Scanner(file); // apri il file
		while (fileReader.hasNextLine()) { // fino a che ci sono righe da leggere
			String line = fileReader.nextLine(); // leggi riga
			files.add(new Data(line.split(",")));

			System.out.println(line); // stampa riga
		}
		fileReader.close(); // chiudi il file

		return files;

	}

	public ArrayList<Data> filePruned(ArrayList<Data> filess) {

		// Iterator<Data> fl = filess.iterator();
		String parse1;
		String parse2;

		System.out.println("dopo ");
		for (int i = 0; i < filess.size(); i++) {
			for (int j = 1 + i; j < filess.size(); j++) {
				try {
					/*
					 * parse1=String.valueOf(filess.get(i).rows);
					 * parse2=String.valueOf(filess.get(j).rows); System.out.println(parse1+ " "+
					 * parse2);
					 */
					if (filess.get(i).rows[0].equals(filess.get(j).rows[0])
							&& filess.get(i).rows[1].equals(filess.get(j).rows[1])
							&& filess.get(i).rows[2].equals(filess.get(j).rows[2])) {

						System.out.println("rimuovo " + (j) + " in " + i + "," + j);
						filess.remove(j);
					}
				} catch (Exception e) {
					System.out.println("errore " + i + j);

				}

			}

		}

		return filess;

	}

	public void printPruned(ArrayList<Data> filess) {

		for (Data file : filess) {
			for (int j = 0; j < file.rows.length; j++) {
				System.out.print(file.rows[j] + ",");
			}

			System.out.println("");

		}
	}

	/*
	 * try { File file = new File("C:\\Users\\user\\Desktop\\file.csv");// definisci
	 * percorso del file Scanner fileReader = new Scanner(file); // apri il file
	 * while (fileReader.hasNextLine()) { // fino a che ci sono righe da leggere
	 * String line = fileReader.nextLine(); // leggi riga System.out.println(line);
	 * // stampa riga } fileReader.close(); // chiudi il file } catch
	 * (FileNotFoundException e) { // in caso di errore
	 * System.out.println("Cannot find file."); // stampa l'errore
	 * e.printStackTrace(); } }
	 */

}
