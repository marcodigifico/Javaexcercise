package ReverseTest;

import java.util.Scanner;

import Reverse.Revers;

public class ReverseTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("inserisci la parola");
		String str = s.nextLine();

		if (Revers.palindromCheck(str)) {

			System.out.println("la parola e' palindroma");

		} else {

			System.out.println("la parola non e' palindroma");
		}

	}

}
