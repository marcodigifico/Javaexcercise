package it.lipari.booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import it.lipari.hotel.Hotel;
import it.lipari.hotel.Room;

public class BookingManager {

	HashMap<String, ArrayList<Booking>> bookingsPerClient = new HashMap<String, ArrayList<Booking>>();
	HashMap<Integer, HashMap<Date, Booking>> bookingsPerRoomNumber = new HashMap<Integer, HashMap<Date, Booking>>();

	public HashMap<String, ArrayList<Booking>> getBookingsPerClient() {
		return bookingsPerClient;
	}

	public void setBookingsPerClient(HashMap<String, ArrayList<Booking>> bookingsPerClient) {
		this.bookingsPerClient = bookingsPerClient;
	}
	
	
	
   /*-----aggiunge una camera----*/
	public void prepBooking(ArrayList<ArrayList<Room>> listH){
		Scanner in2 = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
	    Booking b = new Booking();
	    Calendar c = Calendar.getInstance();
	    
	    System.out.println("inserisci la tua mail:");
	    String l = in2.nextLine();
	    b.setClientEmail(l);
	    System.out.println("adesso selezioniamo la data:");
	    System.out.println("giorno:");
		c.set(Calendar.DAY_OF_MONTH, in.nextInt());
	    System.out.println("mese:");
	    c.set(Calendar.MONTH, in.nextInt());
	    System.out.println("anno:");
	    c.set(Calendar.YEAR, in.nextInt());

	    b.setDate(c.getTime());

	    this.checkRoomPerDate(listH, b.getDate());

	    System.out.println("quale camera vuoi prenotare:");

	    int num = in.nextInt();
	    for (int i = 0; i < 3; i++) {
		  for (int j = 0; j < 18; j++) {

			if (num == listH.get(i).get(j).getNumber()) {

				b.setRoom(listH.get(i).get(j));

			}
		  }

	    }

	    this.addBooking(b);
	}

	
	
	public void addBooking(Booking b) {

		ArrayList<Booking> list = bookingsPerClient.get(b.getClientEmail());

		if (list == null)
			list = new ArrayList<Booking>();

		list.add(b);

		bookingsPerClient.put(b.getClientEmail(), list);

		Room r = b.getRoom();
		Integer rn = r.getNumber();
		HashMap<Date, Booking> bookingsPerDate = bookingsPerRoomNumber.get(rn);
		if (bookingsPerDate == null) {
			bookingsPerDate = new HashMap<Date, Booking>();
		}
		bookingsPerDate.put(b.getDate(), b);
		bookingsPerRoomNumber.put(rn, bookingsPerDate);
	}
	
	
	/*-----troviamo le camere libere  per data----*/

	public void checkRoomPerDate(ArrayList<ArrayList<Room>> listHx) {
		Scanner in = new Scanner(System.in);

		boolean check;

		Calendar c = Calendar.getInstance();
		System.out.println("inserisci data:");
		System.out.println("giorno:");
		c.set(Calendar.DAY_OF_MONTH, in.nextInt());
		System.out.println("mese:");
		c.set(Calendar.MONTH, in.nextInt());
		System.out.println("anno:");
		c.set(Calendar.YEAR, in.nextInt());
		Date datetoParse = c.getTime();

		System.out.println("stanze libere per il: " + datetoParse);
		ArrayList<Integer> booked = new ArrayList<Integer>();

		for (int key : bookingsPerRoomNumber.keySet()) {

			for (Date bookD : bookingsPerRoomNumber.get(key).keySet()) {

				if (datetoParse.compareTo(bookD) == 0) {

					booked.add(bookingsPerRoomNumber.get(key).get(bookD).getRoom().getNumber());

				}

			}

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 18; j++) {
				check = false;
				for (int y = 0; y < booked.size(); y++) {
					if (booked.get(y) == listHx.get(i).get(j).getNumber()) {
						check = true;

					}

				 }
				if (!check)
				 System.out.println("LA STANZA n " + listHx.get(i).get(j).getNumber() + "disponibile");
			  } 
		   }

	    }
	
	
	

	public void checkRoomPerDate(ArrayList<ArrayList<Room>> listHx, Date datetoParse) {

		boolean check;

		System.out.println("stanze libere per il: " + datetoParse);
		ArrayList<Integer> booked = new ArrayList<Integer>();
		for (int key : bookingsPerRoomNumber.keySet()) {

			for (Date bookD : bookingsPerRoomNumber.get(key).keySet()) {

				if (datetoParse.compareTo(bookD) == 0) {

					booked.add(bookingsPerRoomNumber.get(key).get(bookD).getRoom().getNumber());

				}

			}

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 18; j++) {
				check = false;
				for (int y = 0; y < booked.size(); y++) {
					if (booked.get(y) == listHx.get(i).get(j).getNumber()) {
						check = true;

					}

				}
			 if (!check)
					System.out.println("LA STANZA n " + listHx.get(i).get(j).getNumber() + " e' disponibile");
			}
		  }

	    }
	
	
	/*-----elimina prenotazione----*/
	public void deleteBooking() {

		System.out.println("digita l'email della prenotazione:");
		Scanner in3 = new Scanner(System.in);
		String m2 = in3.nextLine();

		for (Map.Entry<String, ArrayList<Booking>> key : getBookingsPerClient().entrySet()) {
			if (m2.equals(key.getKey())) {
			  System.out.println("stanze prenotate da " + getBookingsPerClient().keySet());
			  
			  for (int i = 0; i < key.getValue().size(); i++) {

					System.out.println(key.getValue().get(i).getRoom().getNumber());
				}

			}
		}
		System.out.println("quale vuoi cancellare:");
		int numtoCanc = in3.nextInt();

		for (Map.Entry<String, ArrayList<Booking>> key : getBookingsPerClient().entrySet()) {
			if (m2.equals(key.getKey())) {
				System.out.println("stanze prenotate da " + key.getKey());
				for (int i = 0; i < key.getValue().size(); i++) {

					if (numtoCanc == key.getValue().get(i).getRoom().getNumber())
						key.getValue().remove(i);
				}

			 }
		  }

	    }
	
	
	/*-----stampa le stanze prenotate per mail----*/
	public void listForMail() {

		System.out.println("quale mail vuoi verificare:");

		Scanner in3 = new Scanner(System.in);
		String s = in3.nextLine();

		if (getBookingsPerClient().containsKey(s)) {
			Iterator<Booking> booked = bookingsPerClient.get(s).iterator();
			while (booked.hasNext()) {

				Booking book = booked.next();
				System.out.println(book.getRoom().getNumber());

			}

		}

	}
	/*-----stampa le date in cui è prenotata una stanza----*/

	public void listForRoom() {

		System.out.println("quale stanza vuoi verificare:");
		Scanner in = new Scanner(System.in);
		int rNumber = in.nextInt();

		for (int key : bookingsPerRoomNumber.keySet()) {
			if (rNumber == key) {
				System.out.println("date in cui e' prenotata la " + rNumber);
				for (Date roomDate : bookingsPerRoomNumber.get(key).keySet()) {
					Calendar c2 = Calendar.getInstance();

					System.out.println(roomDate);
				}

			}
		}

	}
	/*-----modifica prenotazione----------------*/

	public void modifyBooking() {

		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);

		System.out.println("digita l'email della prenotazione:");
		String m = in.nextLine();

		for (Map.Entry<String, ArrayList<Booking>> key : getBookingsPerClient().entrySet()) {
			if (m.equals(key.getKey())) {
				System.out.println("stanze prenotate da " + getBookingsPerClient().keySet());
				for (int i = 0; i < key.getValue().size(); i++) {

					System.out.println(key.getValue().get(i).getRoom().getNumber());
				}

			}
		}
		System.out.println("quale vuoi modificare:");
		int numtoMod = in2.nextInt();
		System.out.println("con quale stanza vuoi modificarlo:");
		int numtoSet = in3.nextInt();

		for (Map.Entry<String, ArrayList<Booking>> key : getBookingsPerClient().entrySet()) {
			if (m.equals(key.getKey())) {
				System.out.println("stanze prenotate da " + key.getKey());
				for (int i = 0; i < key.getValue().size(); i++) {

					if (numtoMod == key.getValue().get(i).getRoom().getNumber())
						key.getValue().get(i).getRoom().setNumber(numtoSet);
				}

			}
		}

	}

}
