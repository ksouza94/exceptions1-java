package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number:");
		int number = sc.nextInt();
		
		System.out.println("Date check-in: dd/MM/yyyy");
		Date checkin = sdf.parse(sc.next());
		
		System.out.println("Date check-ou: dd/MM/yyyy");
		Date checkout = sdf.parse(sc.next());
		
		/// no primeiro if se encontra a exception
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
		
		else {
			
			Reservation reservation = new Reservation(number, checkin, checkout);
			
			System.out.println("Reservation:" + reservation);
			System.out.println();
			System.out.println("Enter the data to update the reservation:");
			
			System.out.println("Date check-in: dd/MM/yyyy");
			 checkin = sdf.parse(sc.next());
			 
			
			System.out.println("Date check-ou: dd/MM/yyyy");
			 checkout = sdf.parse(sc.next());
			 
			 Date now = new Date();
			 if (checkin.before(now) || checkout.before(now) ) {
				 
				 System.out.println("Error in reservation: Reservation dates for update must be future dates!");
				 
			 }
			 else if (!checkout.after(checkin)) {
				 System.out.println("Error in reservation: Check-out date must be after check-in date!");
				 
			 }
			 else {
				 
				 reservation.UpdateDates(checkin, checkout);
				 System.out.println("Reservation:" + reservation);
				 
			 }
			 
			 
			 
		}
		
		
		
		
		sc.close();
		
		

	}

}
