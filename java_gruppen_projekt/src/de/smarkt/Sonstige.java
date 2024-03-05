/*
 * 
 */
package de.smarkt;


// TODO: Auto-generated Javadoc
/**
 * 
 * Dies ist die Klasse 'Sonstige'. Produkte mit der Kategorie 'Sonstige' sollen als Objekte dieser Klasse erstellt werden. Es handelt sich hier um eine Tochterklasse der abstrakten Klasse 'Waren'.
 * 
 * @author Andy Le Hoang, Niels Bohr und Julian Schleich.
 */
public class Sonstige extends Waren {
	
	/**  Der FSK der Ware. */
	private int FSK;
	
	/**
	 *Instanziiert ein neues Sonstige-Objekt. Die Attribute 'name' , 'EK' und 'VK' werden von der Klasse Waren vererbt. Das Attribute 'name', 'EK', 'VK' und 'FSK' werden initialisiert.
	 *
	 * @param name der Name des Objektes.
	 * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
	 * @param FSK der FSK des Objektes.
	 * @see Verwaltung#lagerAuffuellen()
	 */
	public Sonstige(String name, double EK, double VK, int FSK) {
		super(name,EK,VK);
		this.FSK = FSK;
	}

}
