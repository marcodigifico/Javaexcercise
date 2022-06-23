package TestMoka;

import MokaManager.MokaManager;

public class TestMoka {

	public static void main(String[] args) {
		MokaManager mok = new MokaManager();

		try {
			mok.insertCoffee();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			mok.fireCoffee();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mok.serveCoffee(mok.pourCoffee(), mok.getMoka().getContent(), mok.getCoffeChoiche());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
