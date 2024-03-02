/*
 * 
 */
package de.smarkt;

// TODO: Auto-generated Javadoc
/**
 * 
 * Dies ist die Klasse Haushaltsartikel. Die Produkte mit der Kategorie Haushaltsartikel sollen als Objekte dieser Klasse Haushaltsartikel erstellt werden.
 * 
 * 
 * @author Andy LeHoang, Niels Bohr und Julian Schleich.  
 */
public class Haushaltartikel extends Waren{
	
	/** 
     * 
     * Dieses Attribut ist der Recyclinganteil der Ware.
     */
	private int recylingAnteil;
	
    /**
     * Dies ist der Konstruktor der Klasse Haushaltartikel.
     * Die Attribute name, EK und VK werden von der Klasse Waren vererbt.
     * Das Attribute name, EK, VK und recyclingAnteil werden initialisiert. 
     * 
     * 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
     * @param anteile der Recyclinganteil des Objektes.
     * @see Verwaltung#lagerAuffuellen()
     */
    public Haushaltartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
    
    /**
     * Diese Methode gibt den Wert von recyclingAnteil zurueck.
     *
     * @return den Wert von Recycling-Anteil. 
     * @see Warenkorb#getGeringsteRecyclingAnteil()
     */
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




