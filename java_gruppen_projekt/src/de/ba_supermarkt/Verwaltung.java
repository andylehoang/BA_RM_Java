package de.ba_supermarkt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Verwaltung {
   private ArrayList<Warenkorb> Warenkorben;
   private ArrayList<Waren> meineWaren;
   private Warenkorb ausgewaehlteWarenkorb;
   private static double tagesAusgabe = 0;
   
   

   
   public Verwaltung() {
	   this.Warenkorben = new ArrayList<Warenkorb>();
	   this.meineWaren= this.lagerAuffuellen();
	   
	   //Add Proxy to test
	  
	   
	   //set default Warenkorb
	   this.addWarenkorb("Standard", 0);
   }
   
   public void addWarenkorb(String kategorie, double geschenkBetrag) {
	   if(geschenkBetrag == 0) {
		   this.Warenkorben.add(new Warenkorb(kategorie));
		   this.setWarenkorb(this.Warenkorben.size()-1);
	   } else {
		   this.Warenkorben.add(new Warenkorb(kategorie,this.generateGeschenkListe(kategorie, geschenkBetrag),geschenkBetrag));
	   }
	     
   }
   
   public ArrayList<Waren> generateGeschenkListe(String kategorie, double summeBetrag) {
	   double betrag = summeBetrag;
	   ArrayList<Waren> GeschenkList = new ArrayList<Waren>();
	   while(betrag >= 0) {
		   for(Waren ware : meineWaren) {
			   if(kategorie.equalsIgnoreCase("Öko-Prinzip")) {
				   if(ware.getName().equalsIgnoreCase("Plastikbesteck") || ware.getName().equalsIgnoreCase("Wurst")) {
					   continue;
				   }
			   } else if(kategorie.equalsIgnoreCase("U18")) {
				   if(ware.getName().equalsIgnoreCase("Flasche Wein") || ware.getName().equalsIgnoreCase("DVD Actionfilm")) {
					   continue;
				   }
			   }
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


       String file = "java_gruppen_projekt/src/de/ba_supermarkt/Supermarkt.CSV"; // ..\\Rohdaten Supermarkt.CSV  java_gruppen_projekt/src/de/ba_supermarkt/Supermarkt.CSV
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
   
   
   
   public ArrayList<Waren> lagerAuffuellen() {
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
   
   
   public boolean warenEinfuegen(int id) {
	   boolean status = true;
	   Waren pickedItem = this.getMeineWaren().get(id);
	   if(this.ausgewaehlteWarenkorb.getKategorie().equalsIgnoreCase("Öko-Prinzip")) {
		   if(pickedItem.getName().equalsIgnoreCase("Plastikbesteck") || pickedItem.getName().equalsIgnoreCase("Wurst")) {
			   status = false;   
		   } 
	   }else if(this.ausgewaehlteWarenkorb.getKategorie().equalsIgnoreCase("U18")){
		   if(pickedItem.getName().equalsIgnoreCase("Flasche Wein") || pickedItem.getName().equalsIgnoreCase("DVD Actionfilm")) {
			   status = false;   
		   } 
	   }else if(this.ausgewaehlteWarenkorb.getKategorie().equalsIgnoreCase("Spar-Korb")){
		   if(this.ausgewaehlteWarenkorb.getWert()+pickedItem.getVK() > 50) {
			   status = false;   
		   } 
	   }
	   
	   if(status) {
		   this.getAusgewaehlteWarenkorb().getMeineWaren().add(pickedItem);
		   
	   } 
	   return status;
   }
   
   public boolean bezahlenLogik(int index) {
	   double warenkorbSumme = this.Warenkorben.get(index).getWert();
	   if(warenkorbSumme != 0) {
		   tagesAusgabe += warenkorbSumme;
		   this.warenkorbEntfernen(index);
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public void warenkorbEntfernen(int index) {
	   this.Warenkorben.remove(index);
	   if(this.Warenkorben.isEmpty()) {
		   this.addWarenkorb("Standard", 0);
	   } else {
		   this.setWarenkorb(0);
	   }
   }
   
   public boolean warenEntfernen(int waren_id) {
	   // remove the product from the array
	   if(!this.ausgewaehlteWarenkorb.getMeineWaren().isEmpty()) {
		   this.ausgewaehlteWarenkorb.warenEntfernen(waren_id);
		   return true;
	   } 
	   return false;
	   
   }
   
   
   
   public double getTagesAusgabe(){
	   return tagesAusgabe;
   }
   
   public Warenkorb getAusgewaehlteWarenkorb() {
	   return this.ausgewaehlteWarenkorb;
   }
   
  public void setWarenkorb(int index) {
	  this.ausgewaehlteWarenkorb = this.Warenkorben.get(index);
  }
  
  public ArrayList<Waren> getMeineWaren(){
	  return this.meineWaren;
  }
  public Warenkorb getLast() {
	  return this.Warenkorben.get(this.Warenkorben.size()-1);
  }
    
}
