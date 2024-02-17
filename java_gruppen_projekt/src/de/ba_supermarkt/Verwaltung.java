package de.ba_supermarkt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Verwaltung {
   private ArrayList<Warenkorb> Warenkorben;
   private ArrayList<Waren> meineWaren;
   private Warenkorb ausgewaehlteWarenkorb;
   private double tagesAusgabe;
   
   

   
   public Verwaltung() {
	   this.Warenkorben = new ArrayList<Warenkorb>();
	   this.meineWaren= this.warenEinfuegen();
	   this.tagesAusgabe = 0.0;
	   
	   //Add Proxy to test
	  
	   
	   //set default Warenkorb
	   this.addWarenkorb("Standard", 0);
   }
   
   public void addWarenkorb(String kategorie, double geschenkBetrag) {
	   if(geschenkBetrag == 0) {
		   this.Warenkorben.add(new Warenkorb(kategorie));
		   //this.setWarenkorb(this.Warenkorben.get(this.Warenkorben.size()-1));
	   } else {
		   this.Warenkorben.add(new Warenkorb(kategorie,this.generateGeschenkListe(kategorie, geschenkBetrag)));
	   }
	   this.setWarenkorb(this.Warenkorben.get(this.Warenkorben.size()-1));   
   }
   
   public ArrayList<Waren> generateGeschenkListe(String kategorie, double summeBetrag) {
	   double betrag = summeBetrag;
	   ArrayList<Waren> GeschenkList = new ArrayList<Waren>();
	   while(betrag >= 0) {
		   for(Waren ware : meineWaren) {
			   double delta = (kategorie.equalsIgnoreCase("Mitarbeiterprogramm"))? betrag - ware.getEK(): betrag - ware.getVK();
			   if(delta > 0) {
				   GeschenkList.add(ware);
				   betrag -= (betrag - delta);
			   } else {
				   betrag = -1;
			   }
		   }
	   }
	   return GeschenkList;
   }
   
   
   public ArrayList<Warenkorb> getWarbenkorben(){
	   return this.Warenkorben;
   }
   
   public ArrayList<String[]> readCSV() {
	   // Daten von CSV Datei einlesen
	   ArrayList<String[]> daten = new ArrayList<String[]>();


       String file = "..\\Rohdaten Supermarkt.CSV";
       BufferedReader reader = null;
       String line = "";

       try {
           reader = new BufferedReader(new FileReader(file));
           while((line = reader.readLine()) != null) {

               String[] row = line.split(";");
               daten.add(row);


           }

       }
       catch(Exception e) {
           e.printStackTrace();
       }
       finally {
           try {
               reader.close();
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       } return daten;
   }
   
   
   
   public ArrayList<Waren> warenEinfuegen() {
	   ArrayList<Waren> meineWaren = new ArrayList<Waren>();
       ArrayList<String[]> daten = this.readCSV();
       String Lebensmittel = "Lebensmittel";
       String Haushaltsartikel = "Haushaltsartikel";
       String Sonstige = "Sonstige";
       double pivotEK = 0;
       double pivotVK = 0;
       int pivotAnteile = 0;
       int pivotFSK = 0;

       for (int i = 0; i < daten.size(); i++) { //läuft nur definierte Anzahl =11 durch, später variabel
           if (daten.get(i)[1].equals(Lebensmittel)) {
               pivotEK = Double.parseDouble(daten.get(i)[3]);
               pivotVK = Double.parseDouble(daten.get(i)[4]);

               meineWaren.add(new Lebensmittel(daten.get(i)[2],pivotEK,pivotVK,daten.get(i)[5]));
           }
           else if (daten.get(i)[1].equals(Haushaltsartikel)) {
               pivotEK = Double.parseDouble(daten.get(i)[3]);
               pivotVK = Double.parseDouble(daten.get(i)[4]);
               pivotAnteile = Integer.parseInt(daten.get(i)[5]);

               meineWaren.add(new Haushaltartikel(daten.get(i)[2],pivotEK,pivotVK,pivotAnteile));

           }
           else if (daten.get(i)[1].equals(Sonstige)) {
               pivotEK = Double.parseDouble(daten.get(i)[3]);
               pivotVK = Double.parseDouble(daten.get(i)[4]);
               pivotFSK = Integer.parseInt(daten.get(i)[5]);

               meineWaren.add(new Sonstige(daten.get(i)[2],pivotEK,pivotVK,pivotFSK));

           }

       }
       return meineWaren;
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
  
  public ArrayList<Waren> getMeineWaren(){
	  return this.meineWaren;
  }
    
}
