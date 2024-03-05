/*
 * 
 */
package de.smarkt;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// TODO: Auto-generated Javadoc
/**
 * 
 * Dies ist die Klasse 'Lebensmittel'. Produkte mit der Kategorie 'Lebensmittel' sollen als Objekte dieser Klasse erstellt werden. Es handelt sich hier um eine Tochterklasse der abstrakten Klasse 'Waren'
 * 
 * @author Andy LeHoang, Niels Bohr und Julian Schleich.
 */
public class Lebensmittel extends Waren{
	
	/** das Mindesthaltbarkeitsdatum des Lebensmittels. */
	private String mindesthaltbarkeitDatum; 
   
	/**
	 * Instanziiert ein neues Lebensmittel-Objekt. Die Attribute 'name' , 'EK' und 'VK' werden von der Klasse Waren vererbt. Das Attribute 'name', 'EK', 'VK' und 'mindesthaltbarkeitDatum' werden initialisiert.
     * 
     * 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes
	 * @param datum der Mindesthaltbarkeitsdatum des Objektes.
	 * @see Verwaltung#lagerAuffuellen()
	 */
	public Lebensmittel(String name, double EK, double VK, String datum) {
		super(name,EK,VK);
		this.mindesthaltbarkeitDatum = datum;
	}
	
	/**
	 * Berechnet, wie viele Tage bis zum Verfallsdatum verbleiben
	 *
	 * @return die Tage bis zum Ablaufdatum
	 * @throws ParseException die Parse Exception
	 * 
	 * @see Warenkorb#getLaengsteMindesthaltbarkeitsdatum()
	 */
	public long duration() throws ParseException {
		long delta = 0;
		LocalDateTime now = LocalDateTime.now();

        // Datum zu String parsen
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Datum Format spezifizieren
        LocalDate date = LocalDate.parse(this.mindesthaltbarkeitDatum, formatter);

        // Delta von jetzt zum Mindesthaltbarkeitdatum berechnen
        delta = ChronoUnit.DAYS.between(now.toLocalDate(),date);		
		return delta;
		
	}
}
