package TestFilePrune;

import java.io.FileNotFoundException;

import FilePruneManager.FilePruneManager;

public class TestFilePrune {

	public static void main(String[] args) throws FileNotFoundException {
		FilePruneManager fp = new FilePruneManager() ;
		
		
		
		
		
		fp.printPruned(fp.filePruned(fp.fetchFile("src/file.csv")));
		
		
		
		
	}

}
