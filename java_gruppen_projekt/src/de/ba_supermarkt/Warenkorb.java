package de.ba_supermarkt;

import java.text.ParseException;
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
            double roundOff = Math.round(this.Wert * 100.0) / 100.0;
	    	return roundOff;
	    	
	    }
	    
	    
	    @Override
	    public String toString() {
	    	return (!this.Geschenke)? this.id+". "+this.Kategorie : this.id+". "+this.Kategorie+ "_" + (int)this.Wert ;
	    }
	    
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
	    
	    public void warenEntfernen(int index) {
	    	this.myWaren.remove(index);
	    }
	    
	   
	    
	    
	    
	    
	    
}
