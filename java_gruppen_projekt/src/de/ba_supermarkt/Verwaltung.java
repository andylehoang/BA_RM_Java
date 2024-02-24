/*
 * 
 */
package de.ba_supermarkt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * 
 * @author Andy Le Hoang.
 * Die Verwaltung fungiert als Betreiber des Programms, indem sie die vom Kunden bereitgestellten Eingabedaten entgegennimmt, die entsprechende Geschäftslogik ausführt und zentral Daten speichert und verwaltet, die für den Betrieb des Programms erforderlich sind.
 * @see Main#main(String[])
 */
public class Verwaltung {
   
   /**  Verwaltet alle Warenkörbe, die von Kunden erstellt wurden */
   private ArrayList<Warenkorb> Warenkorben;
   
   /**  Liste der angebotenen Waren im Supermarkt  */
   private ArrayList<Waren> meineWaren;
   
   /**  Zwischenspeicher für den vom Kunden ausgewählten Warenkorb.*/
   private Warenkorb ausgewaehlteWarenkorb;
   
   /** Summiert die Gesamtausgaben des Kunden im Supermarkt für den Tag. */
   private static double tagesAusgabe = 0;
   
   

   
   /**
    * Instanziert eine neue Verwaltung Objekt. 
    * Die Attribute Warenkorben wird initalisiert.
    * Die Attribute meineWaren wird durch die Funktion lagerAuffuelen mit 12 Waren Objekt befüllt.
    * Eine normale Waren, ohne Besonderheiten, wird als Default gesetzt.
    */
   public Verwaltung() {
	   this.Warenkorben = new ArrayList<Warenkorb>();
	   this.meineWaren= this.lagerAuffuellen();
	   
	   //set default Warenkorb
	   this.addWarenkorb("Standard", 0);
   }
   
   /**
    * Einen neue Warenkorb erstellen und die Warenkorben Liste hinzufügen.
    *
    * @param kategorie für das Warenkorb 
    * @param geschenkBetrag bestimmt die Höhe des Geldbetrags für den Warenkorb mit Geschenkoptionen.
    * @see #Verwaltung()
    * @see Main#menuAddWarenkorb()
    * @see #warenEntfernen(int)
    */
   public void addWarenkorb(String kategorie, double geschenkBetrag) {
	   if(geschenkBetrag == 0) {
		   this.Warenkorben.add(new Warenkorb(kategorie));
		   this.setWarenkorb(this.Warenkorben.size()-1);
	   } else {
		   this.Warenkorben.add(new Warenkorb(kategorie,this.geschenkListeGenerieren(kategorie, geschenkBetrag),geschenkBetrag));
	   }
	     
   }
   
   /**
    * 
    * Generiert eine Liste von Waren bis zur Höhe des gegebenen Betrags unter Berücksichtigung verschiedener Kategorienbeschränkungen.
    *
    * @param kategorie the kategorie
    * @param summeBetrag the summe betrag
    * @see #addWarenkorb(String, double)
    * @return die Liste von Waren als ArrayList<Waren>
    */
   public ArrayList<Waren> geschenkListeGenerieren(String kategorie, double summeBetrag) {
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
   
   
   /**
    * Zugriff auf die Attribute Warenkorben. 
    *
    * @see Main#viewAllWarenkorben()
    * @see Main#warenkorbWechseln()
    * @see Main#bezahlen()
    * @return the warbenkorben
    */
   public ArrayList<Warenkorb> getWarbenkorben(){
	   return this.Warenkorben;
   }
   
   /**
    * Extrahiert die Produktdaten aus der Supermarkt.CSV-Datei.
    * 
    * @see #lagerAuffuellen()
    * @return eine ArrayList aus listen von Strings
    */
   public ArrayList<String[]> readCSV() {
	   // Daten von CSV Datei einlesen
	   ArrayList<String[]> daten = new ArrayList<String[]>();


       String file = "../java_gruppen_projekt/src/de/ba_supermarkt/Supermarkt.CSV"; // ..\\Rohdaten Supermarkt.CSV  java_gruppen_projekt/src/de/ba_supermarkt/Supermarkt.CSV
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
   
   
   
   /**
    * Konvertiert die extrahierten Daten aus der CSV-Datei und erstellt für jedes Produkt ein entsprechendes Objekt, das dann der Attribute 'meineWaren' hinzugefügt wird.
    * @see #Verwaltung()
    * @return  Liste der angebotenen Produkte in Form von ArrayList<Waren>
    */
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

       for (int i = 0; i < daten.size(); i++) { 
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
   
   
   /**
    * Fügt die gewunschte Waren in die ausgewählt Warenkorb hinzu.
    *
    * @param int id von der Ware aus der meineWaren Liste
    * @see Main#warenKaufen()
    * @return true, if successful
    */
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
   
   /**
    * Führt den Bezahlungsvorgang für den gewünschten Warenkorb durch und entfernt diesen Warenkorb aus der Liste.
    *
    * @param index von der Warenkorb in der Liste
    * @see Main#bezahlen()
    * @return true, wenn der Wert vom Warenkorb nicht 0 ist.
    */
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
   
   /**
    * Warenkorb aus der Warkorben Liste entfernen.
    * 
    * @see #bezahlenLogik(int)
    * @param index vom gewünschten Warenkorb
    */
   public void warenkorbEntfernen(int index) {
	   this.Warenkorben.remove(index);
	   if(this.Warenkorben.isEmpty()) {
		   this.addWarenkorb("Standard", 0);
	   } else {
		   this.setWarenkorb(0);
	   }
   }
   
   /**
    * Waren aus der vom Kunde vorher ausgewählte Warenkorb entfernen
    *
    * @param int index vom Waren in der Waren-Liste vom ausgewäehlten Warenkorb 
    * @see Main#ausgewaehlteWarenkorbGreifen() 
    * @return true, wenn Warenkorb nicht leer ist und die Ware erfolgreich entfernt wird.
    */
   public boolean warenEntfernen(int warenIndex) {
	   // remove the product from the array
	   if(!this.ausgewaehlteWarenkorb.getMeineWaren().isEmpty()) {
		   this.ausgewaehlteWarenkorb.warenEntfernen(warenIndex);
		   return true;
	   } 
	   return false;
	   
   }
   
   
   
   /**
    * Zugriff auf die gesamte Ausgabe vom Kunde für den Tag
    * 
    * @see Main#main(String[])
    * @return tagesAusgabe
    */
   public double getTagesAusgabe(){
	   return tagesAusgabe;
   }
   
   /**
    * Zugriff auf die vom Kunde ausgewählte Warenkorb
    * 
    * @see Main#printProduct(ArrayList)
    * @see Main#warenKaufen()
    * @see Main#ausgewaehlteWarenkorbGreifen()
    * @return ausgewaehlte Warenkorb
    */
   public Warenkorb getAusgewaehlteWarenkorb() {
	   return this.ausgewaehlteWarenkorb;
   }
   
  /**
   * Zu einem neuen Warenkorb aus der Liste der Warenkörbe wechseln.
   * 
   * @see Main#warenkorbWechseln()
   * @see #addWarenkorb(String, double)
   * @see #warenkorbEntfernen(int)
   * @param index vom gewünschten Warenkorb
   */
  public void setWarenkorb(int index) {
	  this.ausgewaehlteWarenkorb = this.Warenkorben.get(index);
  }
  
  /**
   * Zugriff auf die meineWaren-Liste
   *
   * @see Main#main(String[])
   * @see Main#warenKaufen()
   * @return die Liste der angebotenen Produkte
   */
  public ArrayList<Waren> getMeineWaren(){
	  return this.meineWaren;
  }
  
  /**
   * Gibt die letzte Element der Liste von Warenkorben an
   *
   * @see Main#menuAddWarenkorb()
   * @return letzte Warenkorb
   */
  public Warenkorb getLetzte() {
	  return this.Warenkorben.get(this.Warenkorben.size()-1);
  }
    
}
