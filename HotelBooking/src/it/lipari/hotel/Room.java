package it.lipari.hotel;

public class Room {

	int number;
	float mq = 10;
	boolean hasBalcony = false;
	boolean hasPrivateBathroom = true;
	int capacity = 2;
	
	public Room() {
		this.number = 101;
	}
	
	public Room(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getMq() {
		return mq;
	}

	public void setMq(float mq) {
		this.mq = mq;
	}

	public boolean isHasBalcony() {
		return hasBalcony;
	}

	public void setHasBalcony(boolean hasBalcony) {
		this.hasBalcony = hasBalcony;
	}

	public boolean isHasPrivateBathroom() {
		return hasPrivateBathroom;
	}

	public void setHasPrivateBathroom(boolean hasPrivateBathroom) {
		this.hasPrivateBathroom = hasPrivateBathroom;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
