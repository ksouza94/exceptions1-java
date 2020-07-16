package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	Integer roomNumber;
	Date checkin;
	Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		
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
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkout.after(checkin)) {
			return "Check-out date must be after check-in date";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
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
