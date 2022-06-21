package it.lipari.hotel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import it.lipari.booking.BookingManager;

public class Hotel {
	
	String name;
	String address;
	String phone;
	
	
	float[] roomPrice;
	float suitePrice;
	
	int roomsPerFlat;
	
	ArrayList<ArrayList<Room>> rooms;
	 
	public Hotel(){
		this.rooms=new ArrayList<ArrayList<Room>>();
		ArrayList<Room> listHy = new ArrayList<Room>();
		
	
		
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
			rooms.add(listHy);
			listHy = new ArrayList<Room>();

		}
		
	}
	

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float[] getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(float[] roomPrice) {
		this.roomPrice = roomPrice;
	}
	public float getSuitePrice() {
		return suitePrice;
	}
	public void setSuitePrice(float suitePrice) {
		this.suitePrice = suitePrice;
	}
	public int getRoomsPerFlat() {
		return roomsPerFlat;
	}
	public void setRoomsPerFlat(int roomsPerFlat) {
		this.roomsPerFlat = roomsPerFlat;
	}
	public ArrayList<ArrayList<Room>> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<ArrayList<Room>> rooms) {
		this.rooms = rooms;
	}
	
	

}
