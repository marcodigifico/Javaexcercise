package Glass;

public class CoffeeGlass extends Glass {

	boolean sugar;
	String typeOfSugar;

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public String getTypeOfSugar() {
		return typeOfSugar;
	}

	public void setTypeOfSugar(String typeOfSugar) {
		this.typeOfSugar = typeOfSugar;
	}

	public CoffeeGlass() {

		super();
		this.content = 0;
		this.capacity = 2;
		this.typeOfSugar = "Nessuno";
		this.sugar = false;

	}

}
