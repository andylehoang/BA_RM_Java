package de.ba_supermarkt;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Lebensmittel extends Waren{
	private String mindesthaltbarkeitDatum; 
   
	public Lebensmittel(String name, double EK, double VK, String datum) {
		super(name,EK,VK);
		this.mindesthaltbarkeitDatum = datum;
	}
	
	public long duration() throws ParseException {
		long delta = 0;
		LocalDateTime now = LocalDateTime.now();

        // Parse the date from a String
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Specify the date format
        LocalDate date = LocalDate.parse(this.mindesthaltbarkeitDatum, formatter);

        // Subtract the parsed date from the current date and time
        delta = ChronoUnit.DAYS.between(date, now.toLocalDate());

        // Output the result
        System.out.println("Current date and time: " + now);
        System.out.println("Parsed date: " + date);
        System.out.println("Subtracted date: " + delta);
		
		return delta;
		
	}
}
