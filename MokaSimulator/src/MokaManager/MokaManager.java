package MokaManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Closet.Closet;
import Glass.CoffeeGlass;
import Glass.Glass;
import Jar.Jar;
import Moka.Moka;

public class MokaManager {

	Closet closet;
	Moka moka;
	String coffeChoiche;

	public MokaManager() {

		this.closet = new Closet();
		this.moka = new Moka();

	}

	public void insertCoffee() throws InterruptedException {

		coffeChoiche = closet.takeJarC();
		System.out.println("svitiamo la caffettiera da " + moka.getPeople() + " persone");

		for (int i = 0; i <= 3; i++) {
			TimeUnit.SECONDS.sleep(1);

			System.out.print(".");

		}
		System.out.println("*knock*");

		if (moka.Empty()) {

			System.out.println("finalmente si e' aperta inseriamo l'acqua e poi "
					+ (closet.getCoffeSpoon().getSpoonCapacity() * moka.getPeople()) + "g di caffe' nel filtro");

			moka.setEmpty(false);

		} else {

			System.out.println("finalmente si e' aperta,mmmm e' piena per qualche motivo");

		}

	}

	public void fireCoffee() throws InterruptedException {

		System.out.println("mettiamo sul fuoco per qualche minuto...");
		TimeUnit.SECONDS.sleep(5);

		System.out.println("fatto,hai prodotto " + (closet.getCoffeSpoon().getSpoonCapacity() * moka.getPeople())
				+ " cl di caffè ");
		moka.setContent(closet.getCoffeSpoon().getSpoonCapacity() * moka.getPeople());

		if (moka.getContent() > moka.getCapacity()) {
			System.out.println("oddio sta strabordando dovrai gettarne un po");
			moka.setContent(moka.getCapacity());
			System.out.println("adesso va bene:" + moka.getContent());

		}

	}

	public ArrayList<CoffeeGlass> pourCoffee() throws InterruptedException {
		int i = 0;

		ArrayList<CoffeeGlass> g = closet.takeGlass(moka.getPeople());
		System.out.println("adesso,versiamo il caffe'!");
		for (CoffeeGlass glass : g) {

			System.out.println("versiamo nella tazza: " + (i + 1));

			TimeUnit.SECONDS.sleep(2);

			if ((moka.getContent() - glass.getCapacity()) < 0) {
				System.out.println("non c'è abbastanza caffe' per riempire la tazza! " + (i + 1));
				glass.setContent(0);

				break;
			} else {
				glass.setContent(2);

				moka.setContent(moka.getContent() - glass.getCapacity());

			}
			i++;

		}

		putSugar(g);

		return g;

	}

	void putSugar(ArrayList<CoffeeGlass> g) {

		int i = 0;
		for (CoffeeGlass glass : g) {

			System.out.println(
					"scegli il tipo di zucchero per la tazza" + (i + 1) + "  1:di canna 2:normale  altro:nessuno");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();
			switch (choice) {
			case 1:

				glass.setSugar(true);
				glass.setTypeOfSugar("di canna");
				break;
			case 2:
				glass.setSugar(true);
				glass.setTypeOfSugar("normale");
				break;
			default:
				break;

			}
			i++;

		}

	}

	public void serveCoffee(ArrayList<CoffeeGlass> g, int rest, String type) {
		int i = 0;
		System.out.println("le tazze servite sono");
		for (CoffeeGlass glass : g) {

			if (glass.emptyGlass()) {

			} else {

				System.out.println("caffe " + type + " n:" + (i + 1) + " zucchero:" + glass.getTypeOfSugar());
				i++;

			}

		}
		System.out.println("e nella moka è rimasto :" + rest + " cl");

	}

	public Moka getMoka() {
		return moka;
	}

	public void setMoka(Moka moka) {
		this.moka = moka;
	}

	public Closet getCloset() {
		return closet;
	}

	public void setCloset(Closet closet) {
		this.closet = closet;
	}

	public String getCoffeChoiche() {
		return coffeChoiche;
	}

	public void setCoffeChoiche(String coffeChoiche) {
		this.coffeChoiche = coffeChoiche;
	}

}
