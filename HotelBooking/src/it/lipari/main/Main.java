package it.lipari.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import it.lipari.booking.Booking;
import it.lipari.booking.BookingManager;
import it.lipari.hotel.Hotel;
import it.lipari.hotel.Room;
import it.lipari.hotel.SuiteRoom;

public class Main {
	static void Menu() {

		System.out.println("benvenuto nel nostro sistema di booking cosa vuoi fare?:");
		System.out.println("1:effettua prenotazione");
		System.out.println("2:modifica prenotazione");
		System.out.println("3:elimina penotazione");
		System.out.println("4:lista prenotazioni per email");
		System.out.println("5:lista prenotazioni per camera");
		System.out.println("6:numero stanze libere");

		System.out.println("0:esci");

	}

	public static void main(String[] args) {

		Hotel h = new Hotel();
	    BookingManager bm = new BookingManager();
		int val;
		
		

		
		boolean stay = true;
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		do {

			Menu();

			val = in.nextInt();
			switch ((int) val) {

			case 1:
				
				bm.prepBooking(h.getRooms());
				break;

			case 2:
				
				bm.modifyBooking();
				break;

			case 3:

				bm.deleteBooking();
				break;
				
			case 4:

				bm.listForMail();
				break;
				
			case 5:

				bm.listForRoom();
				break;
				
			case 6:

				bm.checkRoomPerDate(h.getRooms());
				break;
				
			case 0:
				
				stay = false;
				break;

			}
			// gestionamo l'operazione richiesta

			// chiediamo se vuole continuare o meno

		} while (stay);

	}

}
