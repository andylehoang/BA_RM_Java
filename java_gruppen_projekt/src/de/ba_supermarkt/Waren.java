/*
 * 
 */
package de.ba_supermarkt;

 // TODO: Auto-generated Javadoc
/**
  * @author Andy LeHoang, Niels Bohr und Julian Schleich.
  * Dies ist die Klasse Waren. Diese Klasse ist die Mutterklasse der Klassen Haushaltsartikel, Lebensmittel und Sonstige.
  *   
  */
 public class Waren {
	
	/** Das Attribut counter wird deklariert.
   *  Das Attribut counter ist für das Vergeben der ID nötig. 
   */
	private static int counter= 0;
    
    /** Das Attribut id wird deklariert.
     *  Das Attribut id ist die einmalige id jedes Objektes. 
     */
    private int id;
    
    /** Die Attribute einkaufPreis und verkaufPreis werden deklariert.
     *  Das Attribut einkaufPreis ist der Einkaufspreis.
     *  Das Attribut verkaufPreis ist der Verkaufspreis.
     */
    private double einkaufPreis, verkaufPreis;
    
    /** Das Attribut name wird deklariert. 
     *  Das Attribut name ist der Name.
     */
    private String name;
    
    /**
     * Dies ist der Konstruktor der Klasse Waren.
     * Das Attribute name, EK und VK werden initialisiert.
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
     * Diese Methode gibt den Wert von ek zurück.
     *
     * @return den Wert von ek.
     * @see Main#produktAusstellen(java.util.ArrayList)
     * @see Verwaltung#geschenkListeGenerieren(String, double)
     * @see Warenkorb#getWert()
     */
    public double getEK() {
    	return this.einkaufPreis;
    }
    
    /**
     * Diese Methode gibt den Wert von vk zurück.
     *
     * @return den Wert von vk.
     * @see Main#produktAusstellen(java.util.ArrayList)
     * @see Verwaltung#geschenkListeGenerieren(String, double)
     * @see Verwaltung#warenEinfuegen(int)
     * @see Warenkorb#getWert()
     */
    public double getVK() {
    	return this.verkaufPreis;
    }
    
    /**
     * Diese Methode gibt den Inhalt von name zurück.
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
     * Überschreibung der to-String Methode für die vereinfachte Ausgabe im Konsole.
     *
     * @return name die Name der Ware
     */
    @Override
    public String toString() {
    	return this.getName();
    }
}