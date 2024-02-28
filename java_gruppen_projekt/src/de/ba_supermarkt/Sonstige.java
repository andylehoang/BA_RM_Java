/*
 * 
 */
package de.ba_supermarkt;


// TODO: Auto-generated Javadoc
/**
 * @author Andy Le Hoang, Niels Bohr und Julian Schleich.
 * Dies ist die Klasse Sonstige. Die Produkte mit der Kategorie Sonstige sollen als Objekte dieser Klasse Sonstige erstellt werden.
 * @see Bei der Klasse Sonstige handelt es sich um eine Tochterklasse der Klasse Waren.
 */
public class Sonstige extends Waren {
	
	/** Das Attribut FSK  wird deklariert.
	 * Das Attribut ist der FSK.
	*/
	private int FSK;
	
	/**
	 * Dies ist der Konstruktor der Klasse Sonstige.
     * Die Attribute name, EK und VK werden von der Klasse Waren vererbt.
     * Die Attribute name, EK, VK und FSK werden initialisiert.
	 *
	 * @param name der Name des Objektes.
	 * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
	 * @param FSK der FSK des Objektes.
	 */
	public Sonstige(String name, double EK, double VK, int FSK) {
		super(name,EK,VK);
		this.FSK = FSK;
	}

}
