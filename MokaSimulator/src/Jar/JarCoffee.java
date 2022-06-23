package Jar;

public class JarCoffee extends Jar {

	String CoffeeType;

	public JarCoffee(String CoffeeType, int content) {

		super();
		this.CoffeeType = CoffeeType;
		this.content = content;
		this.capacity = 200;

	}

	public String getCoffeeType() {
		return CoffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		CoffeeType = coffeeType;
	}

	public int getCapacity() {
		return content;
	}

	public void setCapacity(int capacity) {
		content = capacity;
	}

}
