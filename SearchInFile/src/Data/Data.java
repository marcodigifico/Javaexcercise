package Data;

public class Data {

	int numbers[];

	public Data(int[] numbers) {

		this.numbers = numbers;
	}

	/*public Data(String line) {
		
		String[] temp = line.split(",");
		
		int[] numbers = new int[temp.length];
		for(int i = 0;i < temp.length;i++)
		{
		   numbers[i] = Integer.parseInt(temp[i]);
		   System.out.println(numbers[i]);
		}
	}*/

	public int[] getNumbers() {
		return this.numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

}
