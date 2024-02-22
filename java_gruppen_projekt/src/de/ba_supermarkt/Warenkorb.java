/*
 * 
 */
package de.ba_supermarkt;

import java.text.ParseException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Warenkorb.
 */
public class Warenkorb {
	
	/** The counter. */
	private static int counter = 0;
	   
   	/** The my waren. */
   	private ArrayList<Waren> myWaren;
	   
   	/** The Wert. */
   	private double Wert;
	   
   	/** The Kategorie. */
   	private String Kategorie;
	   
   	/** The Geschenke. */
   	private boolean Geschenke;
	   
   	/** The id. */
   	private int id;
	   
	   
	   
	   
	   /**
   	 * Instantiates a new warenkorb.
   	 *
   	 * @param kategorie the kategorie
   	 */
   	public Warenkorb(String kategorie) {
		   this.id = ++counter;
		   this.myWaren = new ArrayList<Waren>();
		   this.Wert = 0.0;
		   this.setKategorie(kategorie);  	    
	   }
	   
   	/**
   	 * Instantiates a new warenkorb.
   	 *
   	 * @param kategorie the kategorie
   	 * @param warenGeschenk the waren geschenk
   	 * @param betrag the betrag
   	 */
   	public Warenkorb(String kategorie, ArrayList<Waren> warenGeschenk, double betrag) {
		   this.id = ++counter;
		   this.setKategorie(kategorie);
		   this.Wert = betrag;
		   this.myWaren = warenGeschenk;
		   this.Geschenke = true;
		   
	   }
	   
	   
	   /**
   	 * Gets the id.
   	 *
   	 * @return the id
   	 */
   	public int getID() {
		   return this.id;
	   }
	    
    	/**
    	 * Sets the kategorie.
    	 *
    	 * @param kategorie the new kategorie
    	 */
    	public void setKategorie(String kategorie) {
	    	this.Kategorie = kategorie;
	    }
	    
	    /**
    	 * Gets the kategorie.
    	 *
    	 * @return the kategorie
    	 */
    	public String getKategorie() {
	    	return this.Kategorie;
	    }
	    
	    /**
    	 * Gets the meine waren.
    	 *
    	 * @return the meine waren
    	 */
    	public ArrayList<Waren> getMeineWaren(){
	    	return this.myWaren;
	    }
	    
	    /**
    	 * Gets the wert.
    	 *
    	 * @return the wert
    	 */
    	public double getWert() {
	    	//Die Preise im Warenkorb zusammenaddieren
            if(!this.Geschenke) {
            	double value = 0.0;
    	    	for(Waren ware: myWaren) {
    	    		value += (this.Kategorie.equalsIgnoreCase("Mitarbeiterprogramm"))? ware.getEK(): ware.getVK();
    	    	}
    	    	this.Wert = value;
            }
            double roundOff = Math.round(this.Wert * 100.0) / 100.0;
	    	return roundOff;
	    	
	    }
	    
	    
	    /**
    	 * To string.
    	 *
    	 * @return the string
    	 */
    	@Override
	    public String toString() {
	    	return (!this.Geschenke)? this.id+". "+this.Kategorie : this.id+". "+this.Kategorie+ "_" + (int)this.Wert ;
	    }
	    
	    /**
    	 * Gets the laegste mindesthaltbarkeitsdatum.
    	 *
    	 * @return the laegste mindesthaltbarkeitsdatum
    	 */
    	public void getLaegsteMindesthaltbarkeitsdatum()  {
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
    	 * Gets the geringste recycling anteil.
    	 *
    	 * @return the geringste recycling anteil
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
    	 * Waren entfernen.
    	 *
    	 * @param index the index
    	 */
    	public void warenEntfernen(int index) {
	    	this.myWaren.remove(index);
	    }
	    
	   
	    
	    
	    
	    
	    
}
