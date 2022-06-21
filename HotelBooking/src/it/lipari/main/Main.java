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

	public static void main(String[] args) {

		Hotel h = new Hotel();
		ArrayList<ArrayList<Room>> listHx = h.getRooms();
		ArrayList<Room> listHy = new ArrayList<Room>();

		Calendar c = Calendar.getInstance();
		Date dateP = new Date();
		String l;
		BookingManager bm = new BookingManager();
		ArrayList<Room> list = new ArrayList<>();
		int val;
		boolean check = false;
		ArrayList<Integer> booked = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 20; j++) {
				if (j != 13 && j != 17) {
					int number = (i + 1) * 100 + j;
					Room r = Math.random() < 0.1 ? new SuiteRoom(number) : new Room(number);
					if (r instanceof SuiteRoom) {

						((SuiteRoom) r).setHasCameraService(new Random().nextBoolean());
						((SuiteRoom) r).setHasPool(new Random().nextBoolean());
						r.setCapacity((int) (Math.random() * (2 - 1 + 1) + 1));
						r.setHasBalcony(new Random().nextBoolean());
						r.setHasPrivateBathroom(new Random().nextBoolean());
						r.setMq(20 * r.getCapacity());

					} else {

						r.setCapacity((int) (Math.random() * (2 - 1 + 1) + 1));
						r.setHasBalcony(new Random().nextBoolean());
						r.setHasPrivateBathroom(new Random().nextBoolean());
						r.setMq(r.getMq() * r.getCapacity());
					}
					listHy.add(r);

				}
			}
			listHx.add(listHy);
			listHy = new ArrayList<Room>();

		}

		boolean stay = true;
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		do {
			// Stampiamo il menu delle operazioni
			System.out.println("benvenuto nel nostro sistema di booking cosa vuoi fare?:");
			System.out.println("1:effettua prenotazione");
			System.out.println("2:modifica prenotazione");
			System.out.println("3:elimina penotazione");
			System.out.println("4:lista prenotazioni per email");
			System.out.println("5:lista prenotazioni per camera");
			System.out.println("6:numero stanze libere");

			System.out.println("0:esci");
			val = in.nextInt();
			switch ((int) val) {

			case 1:
				Booking b = new Booking();
				System.out.println("inserisci la tua mail:");
				l = in2.nextLine();
				b.setClientEmail(l);
				System.out.println("adesso selezioniamo la data:");
				System.out.println("giorno:");
				c.set(Calendar.DAY_OF_MONTH, in.nextInt());
				System.out.println("mese:");
				c.set(Calendar.MONTH, in.nextInt());
				System.out.println("anno:");
				c.set(Calendar.YEAR, in.nextInt());

				b.setDate(c.getTime());

				bm.checkRoomPerDate(listHx, b.getDate());

				System.out.println("quale camera vuoi prenotare:");

				int num = in.nextInt();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 18; j++) {

						if (num == listHx.get(i).get(j).getNumber()) {

							b.setRoom(listHx.get(i).get(j));

						}
					}

				}

				bm.addBooking(b);

				break;

			case 2:
				bm.modifyBooking();

				/*
				 * System.out.println("digita l'email della prenotazione:"); String m =
				 * in3.nextLine();
				 * 
				 * for (Map.Entry<String, ArrayList<Booking>> key :
				 * BM.getBookingsPerClient().entrySet()) { if (m.equals(key.getKey())) {
				 * System.out.println("stanze prenotate da " +
				 * BM.getBookingsPerClient().keySet()); for (int i = 0; i <
				 * key.getValue().size(); i++) {
				 * 
				 * System.out.println(key.getValue().get(i).getRoom().getNumber()); }
				 * 
				 * } } System.out.println("quale vuoi modificare:"); int numtoMod =
				 * in3.nextInt(); System.out.println("con quale stanza vuoi modificarlo:"); int
				 * numtoSet = in4.nextInt();
				 * 
				 * for (Map.Entry<String, ArrayList<Booking>> key :
				 * BM.getBookingsPerClient().entrySet()) { if (m.equals(key.getKey())) {
				 * System.out.println("stanze prenotate da " + key.getKey()); for (int i = 0; i
				 * < key.getValue().size(); i++) {
				 * 
				 * if (numtoMod == key.getValue().get(i).getRoom().getNumber())
				 * key.getValue().get(i).getRoom().setNumber(numtoSet); }
				 * 
				 * } }
				 */

				break;

			case 3:

				bm.deleteBooking();
				/*
				 * System.out.println("digita l'email della prenotazione:"); String m2 =
				 * in3.nextLine();
				 * 
				 * for (Map.Entry<String, ArrayList<Booking>> key :
				 * BM.getBookingsPerClient().entrySet()) { if (m2.equals(key.getKey())) {
				 * System.out.println("stanze prenotate da " +
				 * BM.getBookingsPerClient().keySet()); for (int i = 0; i <
				 * key.getValue().size(); i++) {
				 * 
				 * System.out.println(key.getValue().get(i).getRoom().getNumber()); }
				 * 
				 * } } System.out.println("quale vuoi cancellare:"); int numtoCanc =
				 * in3.nextInt();
				 * 
				 * for (Map.Entry<String, ArrayList<Booking>> key :
				 * BM.getBookingsPerClient().entrySet()) { if (m2.equals(key.getKey())) {
				 * System.out.println("stanze prenotate da " + key.getKey()); for (int i = 0; i
				 * < key.getValue().size(); i++) {
				 * 
				 * if (numtoCanc == key.getValue().get(i).getRoom().getNumber())
				 * key.getValue().remove(i); }
				 * 
				 * } }
				 */

				break;
			case 4:

				bm.listForMail();

				/*
				 * System.out.println("quale mail vuoi verificare:"); String s = in3.nextLine();
				 * 
				 * for (Map.Entry<String, ArrayList<Booking>> key :
				 * BM.getBookingsPerClient().entrySet()) { if (s.equals(key.getKey())) {
				 * System.out.println("stanze prenotate da " + key.getKey()); for (int i = 0; i
				 * < key.getValue().size(); i++) {
				 * 
				 * System.out.println(key.getValue().get(i).getRoom().getNumber()); }
				 * 
				 * } }
				 */

				break;
			case 5:

				bm.listForRoom();
				/*
				 * System.out.println("quale stanza vuoi verificare:"); int rNumber =
				 * in.nextInt();
				 * 
				 * for (int key : BM.getBookingsPerRoomNumber().keySet()) { if (rNumber == key)
				 * { System.out.println("date in cui e' prenotata la " + rNumber); for (Date
				 * roomDate : BM.getBookingsPerRoomNumber().get(key).keySet()) { Calendar c2 =
				 * Calendar.getInstance();
				 * 
				 * System.out.println(roomDate); }
				 * 
				 * } }
				 */
				break;
			case 6:

				bm.checkRoomPerDate(listHx);

				System.out.println("inserisci data:");
				System.out.println("giorno:");
				c.set(Calendar.DAY_OF_MONTH, in.nextInt());
				System.out.println("mese:");
				c.set(Calendar.MONTH, in.nextInt());
				System.out.println("anno:");
				c.set(Calendar.YEAR, in.nextInt());

				Date datetoParse = c.getTime();

				System.out.println("stanze libere per il: " + datetoParse);
				for (int key : bm.getBookingsPerRoomNumber().keySet()) {

					for (Date bookD : bm.getBookingsPerRoomNumber().get(key).keySet()) {

						if (datetoParse.compareTo(bookD) == 0) {

							booked.add(bm.getBookingsPerRoomNumber().get(key).get(bookD).getRoom().getNumber());

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
