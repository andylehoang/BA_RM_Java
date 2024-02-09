package application;
import java.util.*;

public class Warenkorb {
   private static int counter = 0;
   private ArrayList<String> waren;
   private double Wert;
   private String Kategorie;
   private boolean Geschenke;
   
   private int id; 
   
   public Warenkorb(String kategorie, boolean geschenke) {
	   this.id = ++counter;
	   this.waren = new ArrayList<String>();
	   this.Wert = 0.0;
	   this.setKategorie(kategorie);
	   this.Geschenke = geschenke;
	   
	   if(this.Geschenke) {
		   switch (this.Kategorie) {
		   			case "U18" : waren = new ArrayList<String>(Arrays.asList(new String[] {"One","Two","Three","Four", "Five"}));
		   				break;
		   			case "Spar-Korb": waren = new ArrayList<String>(Arrays.asList(new String[] {"One","Two","Three","Four", "Six"}));
						break;
		   			case "Mitarbeiterkaufprogramm" : waren = new ArrayList<String>(Arrays.asList(new String[] {"One","Two","Three","Four","Seven"}));
		   			    break;
		   			case "Öko Prinzip": waren = new ArrayList<String>(Arrays.asList(new String[] {"One","Two","Three","Four", "Eight"}));
		   			default: break;
		   }
		   this.id *= 10;
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
}
