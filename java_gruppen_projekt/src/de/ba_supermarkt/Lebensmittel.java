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
 * @author Andy LeHoang, Niels Bohr und Julian Schleich.
 * Dies ist die Klasse Lebensmittel. Die Produkte mit der Kategorie Lebensmittel sollen als Objekte dieser Klasse Lebensmittel erstellt werden.
 * @see Bei der Klasse Lebensmittel handelt es sich um eine Tochterklasse der Klasse Waren.
 */
public class Lebensmittel extends Waren{
	
	/** Das Attribut mindesthaltbarkeitDatum wird deklariert.
	 * 	Das Attribut mindesthaltbarkeitDatum ist das Mindesthaltbarkeitsdatum.
	 */
	private String mindesthaltbarkeitDatum; 
   
	/**
	 * Dies ist der Konstruktor der Klasse Lebensmittel.
     * Die Attribute name, EK und VK werden von der Klasse Waren vererbt.
     * Das Attribute name, EK, VK und datum werden initialisiert. 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes
	 * @param datum der Mindesthaltbarkeitsdatum des Objektes.
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
