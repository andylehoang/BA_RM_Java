/*
 * 
 */
package de.ba_supermarkt;

// TODO: Auto-generated Javadoc
/**
 * @author Andy LeHoang, Niels Bohr und Julian Schleich.
 * Dies ist die Klasse Haushaltsartikel. Die Prdoukte mit der Kategorie Haushaltsartikel sollen als Objekte dieser Klasse Haushaltsartikel erstellt werden.
 * @see Bei der Klasse Haushaltsartikel handelt es sich um eine Tochterklasse der Klasse Waren.  
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
     * Das Attribut recyclingAnteil wird initialisiert. 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
     * @param anteile der Recyclinganteil des Objektes.
     */
    public Haushaltartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
    
    /**
     * Diese Methode gibt den Wert von recyclingAnteil zurück.
     *
     * @return den Wert von recyclingAnteil. 
     */
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




