package FileReader;

abstract class Comparable {
	
	
	public  int compare(Object a,Object b) {
		if(((Integer)a)>((Integer)b)) {
			
			return 1;
		}else {
			
			return 0;
		}
		
	}

}
