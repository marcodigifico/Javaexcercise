package it.lipari.hotel;

import java.util.ArrayList;

public class Hotel {
	
	String name;
	String address;
	String phone;
	
	float[] roomPrice;
	float suitePrice;
	
	int roomsPerFlat;
	ArrayList<ArrayList<Room>> rooms;
	public Hotel(){
		rooms = new ArrayList<>();
		
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
