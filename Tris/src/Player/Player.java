package Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	int n;
	String simbol;

	HashMap<Integer,Integer> choices;

	public Player(int n,String simbol) {
		this.simbol=simbol;

		this.n = n;

	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public HashMap<Integer, Integer> getChoices() {
		return choices;
	}

	public void setChoices(HashMap<Integer, Integer> choices) {
		this.choices = choices;
	}
	
	
	

}
