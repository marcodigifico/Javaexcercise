package it.lipari.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import it.lipari.hotel.Hotel;
import it.lipari.hotel.Room;

public class BookingManager {
	
	HashMap<String,ArrayList<Booking>> bookingsPerClient = new HashMap<String,ArrayList<Booking>>();
   HashMap<Integer,HashMap<Date,Booking>> bookingsPerRoomNumber = new HashMap<Integer,HashMap<Date,Booking>>();
	
	public HashMap<String, ArrayList<Booking>> getBookingsPerClient() {
	return bookingsPerClient;
}





public void setBookingsPerClient(HashMap<String, ArrayList<Booking>> bookingsPerClient) {
	this.bookingsPerClient = bookingsPerClient;
}





	public void addBooking(Booking b) {
	
		ArrayList<Booking> list = bookingsPerClient.get(b.getClientEmail());
		if(list == null) {
			list = new ArrayList<Booking>();
		}
		list.add(b);
		bookingsPerClient.put(b.getClientEmail(), list);
		
	   Room r = b.getRoom();
		Integer rn = r.getNumber();
		HashMap<Date,Booking> bookingsPerDate = getBookingsPerRoomNumber().get(rn);
		if(bookingsPerDate == null) {
			bookingsPerDate = new HashMap<Date,Booking>();
		}
		bookingsPerDate.put(b.getDate(), b);
		getBookingsPerRoomNumber().put(rn, bookingsPerDate);
	}
	
				
				
			
			
   public HashMap<Integer,HashMap<Date,Booking>> getBookingsPerRoomNumber() {
		return bookingsPerRoomNumber;
	}
	public void setBookingsPerRoomNumber(HashMap<Integer,HashMap<Date,Booking>> bookingsPerRoomNumber) {
		this.bookingsPerRoomNumber = bookingsPerRoomNumber;
	}

}
