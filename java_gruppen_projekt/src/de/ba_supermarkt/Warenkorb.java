package de.ba_supermarkt;

import java.util.ArrayList;

public class Warenkorb {
	private static int counter = 0;
	   private ArrayList<Waren> myWaren;
	   private double Wert;
	   private String Kategorie;
	   private boolean Geschenke;
	   private int id;
	   
	   
	   public Warenkorb(String kategorie) {
		   this.id = ++counter;
		   this.myWaren = new ArrayList<Waren>();
		   this.Wert = 0.0;
		   this.setKategorie(kategorie);  	    
	   }
	   public Warenkorb(String kategorie, ArrayList<Waren> warenGeschenk, double betrag) {
		   this.id = ++counter;
		   this.setKategorie(kategorie);
		   this.Wert = betrag;
		   this.myWaren = warenGeschenk;
		   this.Geschenke = true;
		   
	   }
	   
	   
	   public int getID() {
		   return this.id;
	   }
	    public void setKategorie(String kategorie) {
	    	this.Kategorie = kategorie;
	    }
	    
	    public String getKategorie() {
	    	return this.Kategorie;
	    }
	    
	    public ArrayList<Waren> getMeineWaren(){
	    	return this.myWaren;
	    }
	    
	    public double getWert() {
	    	//Die Preise im Warenkorb zusammenaddieren
            if(!this.Geschenke) {
            	double value = 0.0;
    	    	for(Waren ware: myWaren) {
    	    		value += (this.Kategorie.equalsIgnoreCase("Mitarbeiterprogramm"))? ware.getEK(): ware.getVK();
    	    	}
    	    	this.Wert = value;
            }
	    	return this.Wert;
	    	
	    }
	    
	    
	    @Override
	    public String toString() {
	    	return (!this.Geschenke)? this.id+". "+this.Kategorie : this.id+". "+this.Kategorie+ "_" + (int)this.Wert ;
	    }
	    
	    
	    
}
