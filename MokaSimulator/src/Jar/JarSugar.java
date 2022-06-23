package Jar;

public class JarSugar extends Jar {

	String sugarType;

	public JarSugar(String sugarType, int content) {
		super();
		this.sugarType = sugarType;
		this.content = content;
		this.capacity = 200;

	}

	public String getSugarType() {
		return sugarType;
	}

	public void setSugarType(String sugarType) {
		this.sugarType = sugarType;
	}

}
