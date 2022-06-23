package Moka;

import java.util.Scanner;

public class Moka {

	boolean Empty;
	int People;/* per quante persone */
	int capacity;
	int content;

	public Moka() {
		Scanner s = new Scanner(System.in);
		System.out.println("di quante persone deve essere la moka");

		this.People = s.nextInt();
		Empty = true;
		this.capacity = this.People * 8;

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public boolean Empty() {
		return Empty;
	}

	public void setEmpty(boolean isEmpty) {
		this.Empty = isEmpty;
	}

	public int getPeople() {
		return People;
	}

	public void setPeople(int people) {
		People = people;
	}

}
