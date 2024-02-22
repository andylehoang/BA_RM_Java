/*
 * 
 */
package de.ba_supermarkt;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class Lebensmittel.
 */
public class Lebensmittel extends Waren{
	
	/** The mindesthaltbarkeit datum. */
	private String mindesthaltbarkeitDatum; 
   
	/**
	 * Instantiates a new lebensmittel.
	 *
	 * @param name the name
	 * @param EK the ek
	 * @param VK the vk
	 * @param datum the datum
	 */
	public Lebensmittel(String name, double EK, double VK, String datum) {
		super(name,EK,VK);
		this.mindesthaltbarkeitDatum = datum;
	}
	
	/**
	 * Duration.
	 *
	 * @return the long
	 * @throws ParseException the parse exception
	 */
	public long duration() throws ParseException {
		long delta = 0;
		LocalDateTime now = LocalDateTime.now();

        // Parse the date from a String
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Specify the date format
        LocalDate date = LocalDate.parse(this.mindesthaltbarkeitDatum, formatter);

        // Subtract the parsed date from the current date and time
        delta = ChronoUnit.DAYS.between(now.toLocalDate(),date);		
		return delta;
		
	}
}
