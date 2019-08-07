package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reservation reservation;
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		if (!checkout.after(checkin)) {
			System.out.println("Erros Check-in must be before Check-out");
		} 
		else {
				reservation = new Reservation(roomNumber, checkin, checkout);
				System.out.println("Reservation: " + reservation);
				System.out.println("Enter data to update the reservation: ");
				System.out.print("Check-in date: ");
				checkin = sdf.parse(sc.next());
				System.out.print("Check-out date: ");
				checkout = sdf.parse(sc.next());
	
				Date now = new Date();
				if (((checkin.before(now)) || (checkout.before(now))) || (!checkout.after(checkin))) {
					System.out.println("Erros Check-in and must be before Check-out and after today");
				} 
				else {
	
						reservation.updateDates(checkin, checkout);
						System.out.println("Reservation: " + reservation);
				}
			
		}

		sc.close();

	}

}
