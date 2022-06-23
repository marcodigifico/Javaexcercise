package Closet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Glass.CoffeeGlass;
import Glass.Glass;
import Jar.Jar;
import Jar.JarCoffee;
import Jar.JarSugar;
import Spoon.Spoon;

public class Closet {

	ArrayList<JarCoffee> j;
	ArrayList<JarSugar> su;

	Spoon coffeSpoon;

	ArrayList<CoffeeGlass> glass;

	public ArrayList<JarCoffee> getJ() {
		return j;
	}

	public void setJ(ArrayList<JarCoffee> j) {
		this.j = j;
	}

	public Closet() {
		j = new ArrayList<JarCoffee>();

		j.add(new JarCoffee("Jinseng", new Random().nextInt(200)));

		j.add(new JarCoffee("Arabica", new Random().nextInt(200)));

		j.add(new JarCoffee("Espresso", new Random().nextInt(200)));

		coffeSpoon = new Spoon();

		su = new ArrayList<JarSugar>();

		su.add(new JarSugar("normale", new Random().nextInt(200)));

		su.add(new JarSugar("di canna", new Random().nextInt(200)));

	}

	public ArrayList<JarSugar> getSu() {
		return su;
	}

	public void setSu(ArrayList<JarSugar> su) {
		this.su = su;
	}

	public Spoon getCoffeSpoon() {
		return coffeSpoon;
	}

	public void setCoffeSpoon(Spoon coffeSpoon) {
		this.coffeSpoon = coffeSpoon;
	}

	public String takeJarC() {
		int i = 0;
		System.out.println("andiamo nel cassetto ,Quale caffè vuoi prendere");
		for (JarCoffee jar : j) {

			System.out.println(i + " " + jar.getCoffeeType() + " g " + jar.getContent());
			i++;

		}

		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		return j.get(choice).getCoffeeType();

	}

	public Jar takeJarS() {

		int i = 0;
		System.out.println("andiamo nel cassetto ,Quale caffè vuoi prendere");
		for (JarSugar jar : su) {

			System.out.println(i + " " + jar.getSugarType() + " g " + jar.getCapacity());
			i++;

		}

		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		return su.get(choice);

	}

	public ArrayList<CoffeeGlass> takeGlass(int number) {

		System.out.println("adesso prendiamo " + number + " bicchieri");
		glass = new ArrayList<CoffeeGlass>();

		for (int i = 0; i < number; i++) {
			glass.add(new CoffeeGlass());

		}

		return glass;

	}

}
