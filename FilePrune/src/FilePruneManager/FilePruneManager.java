package FilePruneManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
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
			// files.add(new Data(line.split(",")));
			files.add(new Data(line));

			System.out.println(line); // stampa riga
		}
		fileReader.close(); // chiudi il file

		return files;

	}

	public ArrayList<Data> filePruned(ArrayList<Data> filess) {

		System.out.println("dopo ");
		for (int i = 0; i < filess.size(); i++) {
			for (int j = 1 + i; j < filess.size(); j++) {
				try {

					if (compareRows(filess.get(i).rows, filess.get(j).rows) == 1) {
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

			System.out.println(file.rows + ",");

		}
	}

	int compareRows(String st1, String st2) {

		if (st1.equals(st2)) {
			return 1;
		} else {
			return 0;

		}

	}

}
