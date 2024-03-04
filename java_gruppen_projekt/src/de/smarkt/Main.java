/*
 * 
 */
package de.smarkt;

import java.util.*;


// TODO: Auto-generated Javadoc
/**
 * Die Main-Klasse interagiert mit dem Kunden ueber eine Benutzeroberflaeche in der Konsole und verarbeitet die eingegebenen Daten, bevor sie an die Verwaltung weitergeleitet werden.
 * 
 * @author Andy Le Hoang
 */
public class Main {
	 
	 /** Die Instanz fuer die Verwaltung wird deklariert. */
 	private static Verwaltung myVerwaltung;
	 
 	/** Ein Scanner-Objekt wird zur Einlesung von Kundeneingaben initialisiert. */
 	private static Scanner sc = new Scanner(System.in);
	 

	/**
	 * Die Applikation wird in der `main`-Methode eingefuehrt. Dabei erscheint die Benutzerschnittstelle in der Konsole. Abhaengig von der Eingabe des Benutzers wird die entsprechende Geschaeftslogik ausgefuehrt. Zusaetzlich existiert ein Mechanismus zur Ueberpruefung fehlerhafter Eingaben, der es dem Benutzer ermoeglicht, eine neue Eingabe gemaess den angegebenen Richtlinien anzufordern. Darueber hinaus wird die Instanz fuer die Verwaltung initialisiert, um die Applikation zu steuern. Am Ende der Laufzeit der Applikation wird die gesamte Ausgabe vom Kunde angezeigt.
	 *
	 * @param args die Argumente
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myVerwaltung = new Verwaltung();
		boolean exit = false;
		System.out.println("Willkommen zu Smarkt");
		
		
		while(!exit){
	      try { 
	    	  
	    		produktAusstellen(myVerwaltung.getMeineWaren());
	    		menuDrucken();
	    	    String input = sc.next();
	    	   //Prüfen, ob die Eingabe gültig ist
	    	    while(!input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("w") && !input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("i") && !input.equalsIgnoreCase("v") && !input.equalsIgnoreCase("b") && (!input.equalsIgnoreCase("k") || (input.equalsIgnoreCase("k") && myVerwaltung.getAusgewaehlteWarenkorb().getGeschenkStatus()))) {
	    	    	System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
	    	    	input = sc.next();
	    	    }
	    	    //Prüfen, ob der Benutzer aussteigen möchte
		          if(input.equalsIgnoreCase("n")) {
		        	  menuAddWarenkorb();
		          } else if(input.equalsIgnoreCase("k")) {
		        	 warenKaufen();
		          } else if(input.equalsIgnoreCase("w")){
		        	  warenkorbWechseln();
		          } else if(input.equalsIgnoreCase("a")){
		        	  clear();
		        	  viewAllWarenkorben();
		       	      System.out.println("[Z]urück");
		       	      input = sc.next();
		       	      while(!input.equalsIgnoreCase("z")) {
		       		    System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
		       		    input = sc.next();
		       	      }
		       	      clear();
		          }else if(input.equalsIgnoreCase("b")){
		        	  bezahlen();
		          }else if(input.equalsIgnoreCase("i")){
		        	  ausgewaehlteWarenkorbGreifen();
		          }else {
		        	  exit = true;
		          }
		    } catch (InputMismatchException e) {
	           sc.next();
		    	System.out.println("Falsche Datentyp");
		    	System.out.println("Prozess gecancelt \n \n");
		    }
	    	
	    } 
		System.out.println("\n\n");
	    System.out.println("Heute haben Sie  " + myVerwaltung.getTagesAusgabe() + "€ ausgegeben");
	    System.out.print("Programm verlassen");
	}
	
	
	
	
	
	
	
	
	/**
	 * Das Menu fuer die einzelnen Funktionen wird ausgedruckt
	 * 
	 * @see #main(String[])
	 */
	public static void menuDrucken() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Aktuelle Warenkorb: " + myVerwaltung.getAusgewaehlteWarenkorb());
		System.out.println("-----------------------------------------------------");
		if(myVerwaltung.getAusgewaehlteWarenkorb().getGeschenkStatus()) {
			System.out.println("Funktionsmenü: [N]euen Warenkorb hinzufügen | [W]arbenkorb wechseln | [A]lle Warenkörbe anzeigen | [I]nformation zu aktuellem Warenkorb  | [B]ezahlen | [V]erlassen" );
		}else {
			System.out.println("Funktionsmenü: [N]euen Warenkorb hinzufügen | [W]arbenkorb wechseln | [A]lle Warenkörbe anzeigen | [I]nformation zu aktuellem Warenkorb  | [K]aufen | [B]ezahlen | [V]erlassen" );
		}
		
		System.out.println("-----------------------------------------------------");		
	}
	
	/**
	 * Druckt die Liste von Waren in einer geordnete Tabelle aus. 
	 * 
	 * @see #main(String[])
	 * @see #ausgewaehlteWarenkorbGreifen()
	 * @param warenList Liste von Waren
	 */
	public static void produktAusstellen(ArrayList<Waren> warenList) {
		System.out.println("| ID |          Name         | Preis");
		System.out.println("------------------------------------");
		String line = "";
		for (int y = 0; y < warenList.size(); y++) {
			Waren ware= warenList.get(y);
			// Abstand für ID
			line += "| "+ (y+1) ;
			line += ((y+1) < 10) ? "  ": " ";
			// Abstand für Name
			line += "|   "+ ware.getName();
			for(int i = 0; i<= 19 - ware.getName().length(); i++) {
				line += " ";
			}
			//Abstand für Preis
			line += "| ";
			line += (myVerwaltung.getAusgewaehlteWarenkorb().getKategorie().equalsIgnoreCase("Mitarbeiterkaufprogramm"))? ware.getEK(): ware.getVK();
			line += "\n";
		}
	   System.out.print(line);
	}
	
	
	/**
	 * Die Menu fuer die Kategorien und Auswahl fuer die Feststellung der Geschenkoption von Warenkorb ausdrucken. Die Eingabe von Kunde wird geprueft. Danach wird die passende Daten fuer die Erstellung einer neue Warenkorb Objekt verwendet. 
	 * 
	 * @see #main(String[])
	 */
	public static void menuAddWarenkorb() {
		String kategorie = "";
		double geschenkBetrag = 0;
		System.out.println("Bitte eingeben: [Sp]ar-Korb | [M]itarbeiterkaufprogramm | [U]18 | [O]eko-Prinzip | [D]efault");
		kategorie = sc.next();
		
		//Prüfen ob die eingabe stimmt
		 while(!kategorie.equalsIgnoreCase("Sp") && !kategorie.equalsIgnoreCase("M") && !kategorie.equalsIgnoreCase("u") && !kategorie.equalsIgnoreCase("o") && !kategorie.equalsIgnoreCase("d")) {
 	    	System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
 	    	kategorie = sc.next();
 	    }
		//Tatsächliche Kategorie einfügen
		if(kategorie.equalsIgnoreCase("Sp")) {
			kategorie = "Spar-Korb";
		} else if (kategorie.equalsIgnoreCase("M")) {
			kategorie = "Mitarbeiterkaufprogramm";
		} else if(kategorie.equalsIgnoreCase("U")){
			kategorie = "U18";
		} else if(kategorie.equalsIgnoreCase("O")){
			kategorie = "Öko-Prinzip";
		} else {
			kategorie = "Standard";
		}
			
		// Abfragen: Geschenk oder nicht 
		System.out.println("Möchten Sie die Geschenkoption für diesen Warenkorb wählen? \n [J/N]");
		String option = sc.next();
		//Prüfen ob die eingabe stimmt
		 while(!option.equalsIgnoreCase("j") && !option.equalsIgnoreCase("n")) {
	 	    	System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
	 	    	option = sc.next();
	 	    }
		 // Code durchführen, wenn die eingabe = ja, es passiert nichts, wenn der Antwort nein ist.
		if(option.equalsIgnoreCase("j")) {
		  //Geschenkbetrag auswählen
		  System.out.println("Bitte wählen Sie die Summe für Ihren Geschenkkorb: [ 10 | 20 | 50 ]");
		  geschenkBetrag = sc.nextDouble();
		  //Prüfen ob die eingabe stimmt
		  while(geschenkBetrag != 10 && geschenkBetrag != 20 && geschenkBetrag != 50) {
	 	    	System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
	 	    	geschenkBetrag = sc.nextDouble();
	 	    }
		}
		//Warenkorb einfügen
		myVerwaltung.addWarenkorb(kategorie, geschenkBetrag);
		clear();
		System.out.println(myVerwaltung.getLetzte() + " wird hinzugefügt");
	}
	
	/**
	 * Der Logik fuer das Einfuegen von Ware im Warenkorb wird durchgefuehrt. Aber zuerst muss die Eingabe zur Auswahl der gewuenschten Ware ueberprueft.
	 * 
	 * @see #main(String[])
	 */
	public static void warenKaufen() {
		
		int wareID = 0;
		System.out.println("Bitte wählen Sie die ID des Artikels, den Sie kaufen möchten");
		wareID = sc.nextInt();
		while(wareID> 12 || wareID < 1) {
			System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
			wareID = sc.nextInt();
		}
		clear();
		Waren pickedItem = myVerwaltung.getMeineWaren().get(wareID-1);
		if(myVerwaltung.warenEinfuegen(wareID-1)) {
			System.out.println(pickedItem.getName()+ " wird in " + myVerwaltung.getAusgewaehlteWarenkorb()+ " hinzugefügt");
		}else {
			System.out.println(pickedItem.getName()+ " ist nicht geeignet für Kategorie:" + myVerwaltung.getAusgewaehlteWarenkorb().getKategorie());
		}
	}
	
	/**
	 * Ein Ueberblick von aller vom Kunde erstellten Warenkoerbe wird in einer Tabelle dargestellt.
	 * 
	 * @see #main(String[])
	 * @see #warenkorbWechseln()
	 * @see #bezahlen()
	 */
	public static void viewAllWarenkorben() {
		System.out.println("| ID |              Kategorie           | Gesamtwert");
		System.out.println("-------------------------------------------");
		String line = "";
		for (int i = 0; i< myVerwaltung.getWarbenkoerbe().size(); i++) {
			// Abstand für ID
			line += "| "+ (i+1) ;
			line += ((i+1)<10) ? "  ": " ";
			// Abstand für Kategorie
			line += "|   "+ myVerwaltung.getWarbenkoerbe().get(i);
			for (int x = 0; x <= 30 - myVerwaltung.getWarbenkoerbe().get(i).toString().length(); x++) {
				line += " ";
			}
			// Abstand für Preis
			line += "|   "+ myVerwaltung.getWarbenkoerbe().get(i).getWert() + "\n";
		}
		System.out.print(line);
	}
	
	/**
	 * Der Logik fuer das Wechseln von verschiedene Warenkoerbe wird durchgefuehrt, nachdem der Kunde feststellt, welchen Warenkorb er moechte.
	 * 
	 * @see #main(String[])
	 */
	public static void warenkorbWechseln() {
		viewAllWarenkorben();
		System.out.println("Bitte wählen Sie den gewünschten Index für den Warenkorb");
		int index = sc.nextInt();
		while(index< 0 || index>myVerwaltung.getWarbenkoerbe().size()) {
			System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
			index = sc.nextInt();
		}
		myVerwaltung.setWarenkorb(index-1);
		clear();
	}
	
	/**
	 * Der Logik von der Bezahlungsvorgang fuer die vom Kunde ausgewaehlten Warenkorb wird durchgefuehrt. 
	 * 
	 * @see #main(String[])
	 */
	public static void bezahlen() {
		clear();
		viewAllWarenkorben();
		System.out.println("Für welchen Warenkorb möchten Sie bezahlen? Bitte wählen Sie die ID des Wagens");
		int warenkorb_id = sc.nextInt();
		while(warenkorb_id < 1 || warenkorb_id > myVerwaltung.getWarbenkoerbe().size()) {
			System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
			warenkorb_id = sc.nextInt();
		}
		clear();
		if(!myVerwaltung.bezahlenLogik(warenkorb_id-1)) {
			System.out.println("Warenkorb war leer");
		} else {
			System.out.println("Zahlung erfolgreich");
		}
	}
	
	/**
	 * Zugriff auf den momentan ausgewaehlte Warenkorb. Die besondere Eigenschaften von Waren im Warenkorb werden angezeigt. Funktionen wie Warenkorb direkt bezahlen, Warenkorb entfernen und zurueckspringen wird dem Kunden angebote. Diese werden nach Eingabe von Kunde durchgefuehrt. Status Meldung werden am Ende angezeigt.
	 * 
	 * @see #main(String[])
	 */
	public static void ausgewaehlteWarenkorbGreifen() {
		clear();
		//Zwischen Speicher für den ausgewählten Warenkorb innitalisieren
		Warenkorb auswahl = myVerwaltung.getAusgewaehlteWarenkorb();
		System.out.println("Warbenkorb: " + auswahl+ "\n");
		
		//Besonderes Eigenschaften von Waren im Warenkorb ausdrucken
		auswahl.getLaengsteMindesthaltbarkeitsdatum();
		auswahl.getGeringsteRecyclingAnteil();
		System.out.println("\n");
		
		// Alle Waren im ausgewählten Warenkorb in einer Tabelle ausstellen
		produktAusstellen(auswahl.getMeineWaren());
		System.out.println("\n Summe: "+ auswahl.getWert() + " €");
		System.out.println("------------------------------------------");
		
		// Funktionsmenu für Geschenkoption anpassen. Nutzer sollt nicht in der Lage sein, den Stand des Geschenkwarenkorb zu ändern.
		if(auswahl.getGeschenkStatus()) {
			System.out.println("Funktionsmenü: [V]erlassen | [B]ezahlen" );
		} else {
			System.out.println("Funktionsmenü: [V]erlassen | [E]ntfernen | [B]ezahlen" );
		}
		
		// Eingabe überprüfen
		String option = sc.next();
		 while(!option.equalsIgnoreCase("v") && (!option.equalsIgnoreCase("e") || (option.equalsIgnoreCase("e") && auswahl.getGeschenkStatus()))  && !option.equalsIgnoreCase("b")) {
	 	    	System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
	 	    	option = sc.next();
	 	    }
		 
		 // Logik für jeder gültiger Eingabe durchspielen
		if(option.equalsIgnoreCase("b")) {
			int index = myVerwaltung.getWarbenkoerbe().indexOf(auswahl);
			clear();
			if(!myVerwaltung.bezahlenLogik(index)) {
				System.out.println("Warenkorb war leer");
			} else {
				System.out.println("Zahlung erfolgreich");
			}
		} else if(option.equalsIgnoreCase("e")){
				System.out.println("Bitte wählen Sie den Index des Artikels, den Sie entfernen möchten");
				int index = sc.nextInt();
				while((index< 0 || index>auswahl.getMeineWaren().size()) && !auswahl.getMeineWaren().isEmpty()) {
					System.out.println("Falsche Eingabe. Bitte nochmal versuchen");
					index = sc.nextInt();
				}
				clear();
				if(myVerwaltung.warenEntfernen(index-1)) {
					System.out.println("Artikel wurde entfernt");
				} else {
					System.out.println("Warenkorb ist leer");
				}	
		} else {
			clear();
		}
		
	}
	
	/**
	 * 50 leere Zeile fuer das Entleeren der Konsole generieren.
	 * @see #main(String[])
	 * @see #ausgewaehlteWarenkorbGreifen()  
	 * @see #bezahlen()
	 * @see #warenkorbWechseln()
	 * @see #warenKaufen()
	 */
	public static void clear() {
		for(int i = 0; i<=50; i++) {
			System.out.println("\n");
		}
	}


}
