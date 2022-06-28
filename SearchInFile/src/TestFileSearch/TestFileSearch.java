package TestFileSearch;

import java.io.FileNotFoundException;
import java.io.IOException;

import Data.Data;
import FileReader.FileSearcher;

public class TestFileSearch {

	
	public static void main(String[] args) throws Exception {

		FileSearcher r = new FileSearcher();

		try {

			int[] fetched = r.fetchFileFromCsv("src/input.csv");
			
			r.searchNumberAndWriteCsv(fetched, 4);
			
			/////////////////////////////////////////
			
			r.searchNumberAndWriteJSON(2,"src/input.json");
			
				
				
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
