/*
 * 
 */
package de.ba_supermarkt;

import java.text.ParseException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Diese Klasse bildet die Warenkorb ab. Sie enthält alle wichtige Eigenschaften eines virtuellen Warenkorbs und beinhaltet die vom Kunde gekaufte Waren.
 * 
 * @author Andy Le Hoang
 */
public class Warenkorb {
	
	/** Verfolgt die Anzahl der erzeugten Instanzen dieser Klasse */
	private static int counter = 0;
	   
   	/** Beinhalten die hinzugefügten Waren  */
   	private ArrayList<Waren> myWaren;
	   
   	/** Gesamtbetrag von aller Waren im Warenkorb */
   	private double wert;
	   
   	/** Die Kategorie vom Warenkorb */
   	private String kategorie;
	   
   	/** Legt fest, ob die Geschenkoption gewählt wird */
   	private boolean geschenk;
	   
   	/** Identifikationsnummer für die Warenkorbinstanz */
   	private int id;
	   
	   
	   
	   
	   /**
   	 * Instanziert einen neuer Warenkorb ohne Geschenkoption
   	 *
   	 * @param kategorie die Kategorie vom Warenkorben 
   	 * @see Verwaltung#addWarenkorb(String, double)
   	 */
   	public Warenkorb(String kategorie) {
		   this.id = ++counter;
		   this.myWaren = new ArrayList<Waren>();
		   this.wert = 0.0;
		   this.kategorie = kategorie;
		   this.geschenk = false;
	   }
	   
   	/**
   	 * Den Konstruktor überladen. Istanziert einen neuer Warenkorb mit festgelegten Geschenkbetrag
   	 *
   	 * @param kategorie die Kategorie vom Warenkorben in Form einer String
   	 * @param warenGeschenk die Liste von Waren, die für die Geschenkoption generiert wird
   	 * @param betrag die erwünschte Summe aller Waren innerhalb dieses Geschenkwarenkorbs.
   	 * @see Verwaltung#addWarenkorb(String, double)
   	 */
   	public Warenkorb(String kategorie, ArrayList<Waren> warenGeschenk, double betrag) {
		   this.id = ++counter;
		   this.kategorie  = kategorie;
		   this.wert = betrag;
		   this.myWaren = warenGeschenk;
		   this.geschenk = true;
		   
	   }
	    
	    /**
    	 * Gibt die Kategorie des Warenkorbs zurück
    	 *
    	 * @return die Kategorie des Warenkorbs
    	 * @see Verwaltung#warenEinfuegen(int)
    	 * @see Main#printProduct(ArrayList)
    	 * @see Main#viewAllWarenkorben()
    	 * 
    	 */
    	public String getKategorie() {
	    	return this.kategorie;
	    }
	    
	    /**
    	 * Gibt die Liste von eingefügten Waren zurück
    	 *
    	 * @return die Liste myWaren
    	 * @see Verwaltung#warenEntfernen(int)
    	 * @see Verwaltung#warenEinfuegen(int)
    	 * @see Main#warenKaufen()
    	 * @see Main#ausgewaehlteWarenkorbGreifen()
    	 * 
    	 */
    	public ArrayList<Waren> getMeineWaren(){
	    	return this.myWaren;
	    }
	    
	    /**
    	 * Gibt den Gesamtwert des Warenkorbs zurück
    	 *
    	 * @return den Wert
    	 * @see Verwaltung#bezahlenLogik(int)
    	 * @see Main#viewAllWarenkorben()
    	 * @see Main#ausgewaehlteWarenkorbGreifen()
    	 */
    	public double getWert() {
	    	//Die Preise im Warenkorb zusammen addieren
            if(!this.geschenk) {
            	double value = 0.0;
    	    	for(Waren ware: myWaren) {
    	    		value += (this.kategorie.equalsIgnoreCase("Mitarbeiterprogramm"))? ware.getEK(): ware.getVK();
    	    	}
    	    	this.wert = value;
            }
            double roundOff = Math.round(this.wert * 100.0) / 100.0;
	    	return roundOff;
	    	
	    }
	    
	    
	    /**
    	 * Überschreibt die toString-Methode, damit man den Instanz im Konsole vereinfacht  als String ausgeben lassen kann
    	 *
    	 * @return überblickende Beschreibung des Warenkorbs
    	 * @see Main#viewAllWarenkorben()
    	 */
    	@Override
	    public String toString() {
	    	return (!this.geschenk)? this.id+". "+this.kategorie : this.id+". "+this.kategorie+ "_" + (int)this.wert ;
	    }
	    
	    /**
    	 * Sucht die Waren mit dem längste Mindesthaltbarkeitdatum und gibt sie dann im Konsole aus.
    	 *
    	 * @see Main#ausgewaehlteWarenkorbGreifen()
    	 */
    	public void getLaengsteMindesthaltbarkeitsdatum()  {
	    	long htage = -1;
	    	int index = -1;
	    	for(Waren ware: this.myWaren) {
	    		if(ware instanceof Lebensmittel) {
	    			try {
						if(((Lebensmittel) ware).duration() >= htage) {
							htage = ((Lebensmittel) ware).duration();
							index = this.myWaren.indexOf(ware);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	    		} 
	    	}
	    	
	    	if(htage != -1 && index != -1 ) {
	    		System.out.println("Längste Mindesthaltbarkeitsdatum: " + htage + "| Produkt : " + this.myWaren.get(index));
	    	}
	    }
	    
	    /**
    	 * Sucht die Waren mit dem geringsten Recycling-Anteil und gibt sie dann im Konsole aus.
    	 *
    	 * @see Main#ausgewaehlteWarenkorbGreifen()
    	 */
    	public void getGeringsteRecyclingAnteil() {
	    	int anteile = 10000;
	    	int index = -1;
	    	for(Waren ware: this.myWaren) {
	    		if(ware instanceof Haushaltartikel) {
	    			if(((Haushaltartikel)ware).getRecylingAnteile() <= anteile) {
						anteile = ((Haushaltartikel)ware).getRecylingAnteile();
						index = this.myWaren.indexOf(ware);
					} 
	    		} 
	    	}
	    	
	    	if(anteile != 10000 && index != -1 ) {
	    		System.out.println("geringste Recyclinganteile: " + anteile + "| Produkt : " + this.myWaren.get(index));
	    	}
	    	
	    }
	    
	    /**
    	 * Waren aus der myWaren-Liste entfernen.
    	 *
    	 * @param index den Index von der Ware in der Liste
    	 * @see Verwaltung#warenEntfernen(int)
    	 */
    	public void warenEntfernen(int index) {
	    	this.myWaren.remove(index);
	    }
	    
	   
	    
	    
	    
	    
	    
}
