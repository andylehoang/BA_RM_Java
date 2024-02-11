package application;
import java.util.*;

public class Warenkorb {
   private static int counter = 0;
   private ArrayList<String> waren;
   private double Wert;
   private String Kategorie;
   private int Geschenke;
   
   private int id; 
   
   public Warenkorb(String kategorie, int geschenke) {
	   this.id = ++counter;
	   this.waren = new ArrayList<String>();
	   this.Wert = 0.0;
	   this.setKategorie(kategorie);
	   this.Geschenke = geschenke;
	   
	   if(this.Geschenke != 0) {
	    if(this.Geschenke == 10) {
	    	 switch (this.Kategorie) {
	   			case "U18" : waren = new ArrayList<String>(Arrays.asList(new String[] {"One"}));
	   				break;
	   			case "Spar-Korb": waren = new ArrayList<String>(Arrays.asList(new String[] {"Two"}));
					break;
	   			case "Mitarbeiterkaufprogramm" : waren = new ArrayList<String>(Arrays.asList(new String[] {"Three"}));
	   			    break;
	   			case "Öko Prinzip": waren = new ArrayList<String>(Arrays.asList(new String[] {"Four"}));
	   			default: break;
	        }
		   } else if(this.Geschenke == 20) {
			   switch (this.Kategorie) {
	   			case "U18" : waren = new ArrayList<String>(Arrays.asList(new String[] {"Eleven"}));
	   				break;
	   			case "Spar-Korb": waren = new ArrayList<String>(Arrays.asList(new String[] {"Twelve"}));
					break;
	   			case "Mitarbeiterkaufprogramm" : waren = new ArrayList<String>(Arrays.asList(new String[] {"Thirteen"}));
	   			    break;
	   			case "Öko Prinzip": waren = new ArrayList<String>(Arrays.asList(new String[] {"Fourteen"}));
	   			default: break;
	        }
		   } else {
			   switch (this.Kategorie) {
	   			case "U18" : waren = new ArrayList<String>(Arrays.asList(new String[] {"Twenty-One"}));
	   				break;
	   			case "Spar-Korb": waren = new ArrayList<String>(Arrays.asList(new String[] {"Twenty-Two"}));
					break;
	   			case "Mitarbeiterkaufprogramm" : waren = new ArrayList<String>(Arrays.asList(new String[] {"Twenty-Three"}));
	   			    break;
	   			case "Öko Prinzip": waren = new ArrayList<String>(Arrays.asList(new String[] {"Tweenty Four"}));
	   			default: break;
		    }
		   }
		   
	   }
	   	    
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
    
    public double getWert() {
    	//Die Preise im Warenkorb zusammenaddieren
    	double value = 0.0;
    	this.Wert = value;
    	return this.Wert;
    	
    }
    
    @Override
    public String toString() {
    	return (this.Geschenke == 0)? this.id+". "+this.Kategorie : this.id+". "+this.Kategorie+ "_" + this.Geschenke ;
    }
    
}
