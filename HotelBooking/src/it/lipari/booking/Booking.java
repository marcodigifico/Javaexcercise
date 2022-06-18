package it.lipari.booking;

import java.util.Date;
import it.lipari.hotel.Room;

public class Booking {
	
	Room room;
	Date date;
	
	String clientEmail;
	int capacity = 1;
	
	boolean confirmed = false;
	boolean cancelled = false;
	float amountPaid = 0.0f;
	public Booking(){
		
	}
	
	Booking(Room r, Date d, String email) {
		room = r;
		date = d;
		clientEmail = email;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	
}
