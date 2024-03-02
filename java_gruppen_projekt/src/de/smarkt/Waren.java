/*
 * 
 */
package de.smarkt;

 // TODO: Auto-generated Javadoc
/**
  * @author Andy LeHoang, Niels Bohr und Julian Schleich.
  * Dies ist die Klasse Waren. Diese Klasse ist die Mutterklasse der Klassen Haushaltsartikel, Lebensmittel und Sonstige.
  *   
  */
abstract class Waren {
	
	/**Das Attribut counter ist für das Vergeben der ID noetig. */
	private static int counter= 0;
    
    /** Das Attribut id ist die Identifikationsnummer jedes Objektes. */
    private int id;
    
    /** 
     *  Das Attribut einkaufPreis ist der Einkaufspreis des Waren.
     *  Das Attribut verkaufPreis ist der Verkaufspreis des Waren.
     */
    private double einkaufPreis, verkaufPreis;
    
    /**  
     *  Das Attribut name ist der Name des Waren.
     */
    private String name;
    
    /**
     * Dies ist der Konstruktor der Klasse Waren.
     * 
     * @param name der Name des Objektes.
     * @param EK der Einkaufpreis des Objektes.
     * @param VK der Verkaufspreis des Objektes.
     */
    public Waren(String name, double EK, double VK) {
    	this.id = ++counter;
    	this.name = name;
    	this.einkaufPreis = EK;
    	this.verkaufPreis = VK;
    } 
    
    
    
    /**
     * Diese Methode gibt den Wert vom Einkaufspreis zurueck.
     *
     * @return den Einkaufspreis der Ware.
     * @see Main#produktAusstellen(java.util.ArrayList)
     * @see Verwaltung#geschenkListeGenerieren(String, double)
     * @see Warenkorb#getWert()
     */
    public double getEK() {
    	return this.einkaufPreis;
    }
    
    /**
     * Diese Methode gibt den Wert vom Verkaufspreis zurueck.
     *
     * @return den Verkaufspreis der Ware.
     * @see Main#produktAusstellen(java.util.ArrayList)
     * @see Verwaltung#geschenkListeGenerieren(String, double)
     * @see Verwaltung#warenEinfuegen(int)
     * @see Warenkorb#getWert()
     */
    public double getVK() {
    	return this.verkaufPreis;
    }
    
    /**
     * Diese Methode gibt den Inhalt von name zurueck.
     *
     * @return den Inhalt von name.
     * @see Main#produktAusstellen(java.util.ArrayList)
     * @see Main#warenKaufen()
     * @see Verwaltung#geschenkListeGenerieren(String, double)
     * @see Verwaltung#warenEinfuegen(int)
     * @see #toString()
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * Ueberschreibung der to-String Methode fuer die vereinfachte Ausgabe im Konsole.
     *
     * @return die Name der Ware
     */
    @Override
    public String toString() {
    	return this.getName();
    }
}