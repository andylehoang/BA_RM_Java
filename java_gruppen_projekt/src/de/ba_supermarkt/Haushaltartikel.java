/*
 * 
 */
package de.ba_supermarkt;

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
     * Das Attribut reycclingAnteil wird deklariert.
     * Dieses Attribut ist der Recyclinganteil.
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
     * Diese Methode gibt den Wert von recyclingAnteil zurück.
     *
     * @return den Wert von recyclingAnteil. 
     * @see Warenkorb#getGeringsteRecyclingAnteil()
     */
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




