package Reverse;

public class Revers {

	public static boolean palindromCheck(String str) {

		char[] strChared = str.toCharArray();
		char[] charParsed = new char[str.length()];
		String strToParse = new String();

		for (int i = strChared.length - 1; i >= 0; i--) {

			charParsed[(strChared.length - 1) - i] = strChared[i];

		}

		strToParse = String.valueOf(charParsed);
		if (str.equals(strToParse)) {

			return true;
		} else {

			return false;
		}

	}

}
