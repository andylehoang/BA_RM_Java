/*
 * 
 */
package de.smarkt;

// TODO: Auto-generated Javadoc
/**
 * 
 *Dies ist die Klasse 'Haushaltsartikel'. Produkte mit der Kategorie 'Haushaltsartikel' sollen als Objekte dieser Klasse erstellt werden. Es handelt sich hier um eine Tochterklasse der abstrakten Klasse 'Waren'.
 * 
 * 
 * @author Andy LeHoang, Niels Bohr und Julian Schleich.  
 */
public class Haushaltsartikel extends Waren{
	
	/**  Der Recyclinganteil der Ware. */
	private int recylingAnteil;
	
    /**
     * Instanziiert ein neues Haushaltartikel-Objekt. Die Attribute 'name' , 'EK' und 'VK' werden von der Klasse Waren vererbt. Das Attribute 'name', 'EK', 'VK' und 'recyclingAnteil' werden initialisiert. 
     * 
     * 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
     * @param anteile der Recyclinganteil des Objektes.
     * @see Verwaltung#lagerAuffuellen()
     */
    public Haushaltsartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
    
    /**
     * Gibt den Wert von 'recyclingAnteil' zurueck.
     *
     * @return den Recycling-Anteil der Ware 
     * @see Warenkorb#getGeringsteRecyclingAnteil()
     */
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




