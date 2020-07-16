package model.entities;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

import model.exceptions.DomainException;

public class Reservation {
	
	Integer roomNumber;
	Date checkin;
	Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public Date getcheckin() {
		return checkin;
	}
	public Date getcheckout() {
		return checkout;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", check-in "
				+ sdf.format(checkin)
				+ ", check-out "
				+ sdf.format(checkout)
				+ ", duration "
				+ duration()
				+ " nights";
				
	}
	
	

}
