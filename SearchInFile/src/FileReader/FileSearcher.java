package FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Data.Data;

public class FileSearcher extends Comparable {

	Data data;
	boolean find;
//////////////////////////////////////////////////////JSON
	public ArrayList<Long> fetchFileFromJson(String path) throws Exception {

		Object obj = new JSONParser().parse(new FileReader(path));
		JSONObject jo = (JSONObject) obj;
		ArrayList<Long> fetched = (ArrayList<Long>) jo.get("array");

		return fetched;

	}

	public void searchNumberAndWriteJSON(long val, String path) throws Exception {
		ArrayList<Long> fetched = fetchFileFromJson(path);
		Collections.sort(fetched);

		if (fetched.contains(val)) {

			File myFile = new File("src/output.txt");
			myFile.createNewFile();
			FileWriter myWriter = new FileWriter("src/output.txt");

			myWriter.write("questo e' il vettore ordinato:,");
			for (int i = 0; i < fetched.size(); i++) {
				myWriter.write(fetched.get(i).toString() + ",");
			}
			myWriter.write("\n");
			myWriter.write("il numero trovato e':," + val);
			myWriter.close();

		} else {

			System.out.println("non trovato");

		}

	}

///////////////////////////////////////////////////////////CSV
	public int[] fetchFileFromCsv(String path) throws FileNotFoundException {
		File file = new File(path);

		Scanner fileReader = new Scanner(file);
		String line = fileReader.nextLine();

		String[] temp = line.split(",");

		int[] numbers = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {

			numbers[i] = Integer.parseInt(temp[i]);
			System.out.println(numbers[i]);
		}

		fileReader.close();

		return numbers;

	}

	public void searchNumberAndWriteCsv(int[] fetched, int val) throws IOException {
		bublesort(fetched);

		int numberFind = internalSearch(fetched, 0, fetched.length - 1, val);
		if (find) {
			System.out.print("entro");
			File myFile = new File("src/output.csv");
			myFile.createNewFile();
			FileWriter myWriter = new FileWriter("src/output.csv");

			myWriter.write("questo e' il vettore ordinato:,");
			for (int i = 0; i < fetched.length; i++) {
				myWriter.write(((Integer) fetched[i]).toString() + ",");
			}
			myWriter.write("\n");
			myWriter.write("il numero trovato e':," + numberFind);
			myWriter.close();

		}

	}

/////////////////////////////////////////////////////////////////////////////SORT & SEARCH
	int internalSearch(int n[], int indexStart, int indexEnd, int val) {

		if (compare(indexStart, indexEnd) == 1) {
			this.find = false;

			return 0;

		}

		int index = (indexStart + indexEnd) / 2;

		int found = n[index];

		if (found == val) {

			this.find = true;
			return index;

		} else if (val > found) {

			return internalSearch(n, index + 1, indexEnd, val);
		} else {

			return internalSearch(n, indexStart, index - 1, val);

		}

	}

	static void bublesort(int[] numbers) {

		boolean sorted = false;
		int counter = 0;
		int temp = 0;
		while (sorted == false) {
			sorted = true;
			for (int i = 0; i < numbers.length - 1 - counter; i++) {

				if (numbers[i] > numbers[i + 1]) {

					temp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = temp;
					sorted = false;

				}

			}

		}
	}

///////////////////////////////////////////////////////////////GETTER AND SETTER
	public Data getFiles() {
		return data;
	}

	public void setFiles(Data files) {
		this.data = files;
	}

}
