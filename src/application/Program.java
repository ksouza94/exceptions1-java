package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number:");
			int number = sc.nextInt();
			
			System.out.println("Date check-in: dd/MM/yyyy");
			Date checkin = sdf.parse(sc.next());
			
			System.out.println("Date check-ou: dd/MM/yyyy");
			Date checkout = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkin, checkout);
			
			System.out.println("Reservation:" + reservation);
			System.out.println();
			System.out.println("Enter the data to update the reservation:");
			
			System.out.println("Date check-in: dd/MM/yyyy");
			 checkin = sdf.parse(sc.next());
			 
			
			System.out.println("Date check-ou: dd/MM/yyyy");
			 checkout = sdf.parse(sc.next());
			 
			reservation.updateDates(checkin, checkout);
				
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Data inválida!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		
		sc.close();
		
		}

}
