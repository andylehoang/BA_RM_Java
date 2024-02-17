package de.ba_supermarkt;

import java.util.ArrayList;

public class Verwaltung {
   private ArrayList<Warenkorb> Warenkorben;
   private ArrayList<Waren> Lager;
   private Warenkorb ausgewaehlteWarenkorb;
   private double tagesAusgabe;

   
   public Verwaltung() {
	   this.Warenkorben = new ArrayList<Warenkorb>();
	   this.Lager = new ArrayList<Waren>();
	   this.tagesAusgabe = 0.0;
	   
	   //Add Proxy to test
	   this.lagerAuffuellen(new Lebensmittel("Mineralwasser", 0.45,0.9,"17-02-2023"));
	   this.lagerAuffuellen(new Haushaltartikel("Plastiktüte", 0.5,0.1,100));
	   this.lagerAuffuellen(new Sonstige("Moana", 3.0,12.0,10));
	   
	   //set default Warenkorb
	   this.addWarenkorb(new Warenkorb("Standard",0));
	   this.setWarenkorb(this.Warenkorben.get(0));
   }
   
   public void addWarenkorb(Warenkorb warenkorb) {
	   this.Warenkorben.add(warenkorb);
   }
   public ArrayList<Warenkorb> getWarbenkorben(){
	   return this.Warenkorben;
   }
   
   public void readCSV() {
	   // Daten von CSV Datei einlesen
   }
   
   public void lagerAuffuellen(Waren waren) {
	   this.Lager.add(waren);
   } 
   
   public double getTagesAusgabe(){
	   return this.tagesAusgabe;
   }
   
   public Warenkorb getAusgewaehlteWarenkorb() {
	   return this.ausgewaehlteWarenkorb;
   }
   
  public void setWarenkorb(Warenkorb warenkorb) {
	  this.ausgewaehlteWarenkorb = warenkorb;
  }
    
}
