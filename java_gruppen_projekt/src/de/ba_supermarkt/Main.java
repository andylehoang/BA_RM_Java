/*
 * 
 */
package de.ba_supermarkt;

import java.util.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	 
	 /** The my verwaltung. */
 	private static Verwaltung myVerwaltung;
	 
 	/** The sc. */
 	private static Scanner sc = new Scanner(System.in);
	 

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myVerwaltung = new Verwaltung();
		boolean exit = false;
		System.out.println("Welcome to BA Supermarket");
		
		
		while(!exit){
	      try { 
	    	  
	    		printProduct(myVerwaltung.getMeineWaren());
	    		printMenu();
	    	    String input = sc.next();
	    	   //Check if input is valid
	    	    while(!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("v") && !input.equalsIgnoreCase("g") && !input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("p")) {
	    	    	System.out.println("Wrong input. Please try again");
	    	    	input = sc.next();
	    	    }
	    	    //Check if user want to exit
		          if(input.equalsIgnoreCase("a")) {
		        	  menuAddWarenkorb();
		          } else if(input.equalsIgnoreCase("b")) {
		        	 warenKaufen();
		          } else if(input.equalsIgnoreCase("c")){
		        	  warenkorbWechseln();
		          } else if(input.equalsIgnoreCase("v")){
		        	  clear();
		        	  viewAllWarenkorben();
		       	      System.out.println("[R]eturn");
		       	      input = sc.next();
		       	      while(!input.equalsIgnoreCase("r")) {
		       		    System.out.println("Wrong input");
		       		    input = sc.next();
		       	      }
		       	      clear();
		          }else if(input.equalsIgnoreCase("p")){
		        	  bezahlen();
		          }else if(input.equalsIgnoreCase("g")){
		        	  ausgewaehlteWarenkorbGreifen();
		          }else {
		        	  exit = true;
		          }
		    } catch (InputMismatchException e) {
	           sc.next();
		    	System.out.println("Wrong input type");
		    	System.out.println("Process Canceled \n \n");
		    }
	    	
	    } 
		System.out.println("\n\n");
	    System.out.println("Today you have sent " + myVerwaltung.getTagesAusgabe() + "€ in Total");
	    System.out.print("Exited");
	}
	
	
	
	
	
	
	
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Current cart: " + myVerwaltung.getAusgewaehlteWarenkorb());
		System.out.println("-----------------------------------------------------");
		System.out.println("Function menu: [A]dd new Cart | [C]hange cart; | [V]iew all cart | [G]rab information of current cart | [E]xit | [B]uy | [P]ay" );
		System.out.println("-----------------------------------------------------");		
	}
	
	/**
	 * Prints the product.
	 *
	 * @param warenList the waren list
	 */
	public static void printProduct(ArrayList<Waren> warenList) {
		System.out.println("| ID |          Name         | Preis");
		System.out.println("------------------------------------");
		String line = "";
		for (int y = 0; y < warenList.size(); y++) {
			Waren ware= warenList.get(y);
			// Offset for ID
			line += "| "+ (y+1) ;
			line += ((y+1) < 10) ? "  ": " ";
			// Offset for Name
			line += "|   "+ ware.getName();
			for(int i = 0; i<= 19 - ware.getName().length(); i++) {
				line += " ";
			}
			//Offset for Preis
			line += "| ";
			line += (myVerwaltung.getAusgewaehlteWarenkorb().getKategorie().equalsIgnoreCase("Mitarbeiterprogramm"))? ware.getEK(): ware.getVK();
			line += "\n";
		}
	   System.out.print(line);
	}
	
	
	/**
	 * Menu add warenkorb.
	 */
	public static void menuAddWarenkorb() {
		String kategorie = "";
		double geschenkBetrag = 0;
		System.out.println("Please enter: [Sp]ar-Korb | [M]itarbeiterprogramm | [U]18 | [O]eko-Prinzip | [D]efault");
		kategorie = sc.next();
		
		//Prüfen ob die eingabe stimmt
		 while(!kategorie.equalsIgnoreCase("Sp") && !kategorie.equalsIgnoreCase("M") && !kategorie.equalsIgnoreCase("u") && !kategorie.equalsIgnoreCase("o") && !kategorie.equalsIgnoreCase("d")) {
 	    	System.out.println("Wrong input. Please try again");
 	    	kategorie = sc.next();
 	    }
		//Tatsächliche Kategorie einfügen
		if(kategorie.equalsIgnoreCase("Sp")) {
			kategorie = "Spar-Korb";
		} else if (kategorie.equalsIgnoreCase("M")) {
			kategorie = "Mitarbeiterprogramm";
		} else if(kategorie.equalsIgnoreCase("U")){
			kategorie = "U18";
		} else if(kategorie.equalsIgnoreCase("O")){
			kategorie = "Öko-Prinzip";
		} else {
			kategorie = "Standard";
		}
			
		// Abfragen: Geschenk oder nicht 
		System.out.println("Would you like to choose the gift option for this cart? \n [Y/N]");
		String option = sc.next();
		//Prüfen ob die eingabe stimmt
		 while(!option.equalsIgnoreCase("y") && !option.equalsIgnoreCase("n")) {
	 	    	System.out.println("Wrong input. Please try again");
	 	    	option = sc.next();
	 	    }
		 // Code durchführen, wenn die eingabe = ja, es passiert nichts, wenn der Antwort nein ist.
		if(option.equalsIgnoreCase("y")) {
		  //Geschenkbetrag auswählen
		  System.out.println("Please choose the sum for your gift cart: [ 10 | 20 | 50 ]");
		  geschenkBetrag = sc.nextDouble();
		  //Prüfen ob die eingabe stimmt
		  while(geschenkBetrag != 10 && geschenkBetrag != 20 && geschenkBetrag != 50) {
	 	    	System.out.println("Wrong input. Please try again");
	 	    	geschenkBetrag = sc.nextDouble();
	 	    }
		}
		//Warenkorb einfügen
		myVerwaltung.addWarenkorb(kategorie, geschenkBetrag);
		clear();
		System.out.println(myVerwaltung.getLast() + " has been added");
	}
	
	/**
	 * Waren kaufen.
	 */
	public static void warenKaufen() {
		
		int ware_id = 0;
		System.out.println("Please choose the id of the item that you want to buy");
		ware_id = sc.nextInt();
		while(ware_id> 12 || ware_id < 1) {
			System.out.println("Wrong input. Please try again");
			ware_id = sc.nextInt();
		}
		clear();
		Waren pickedItem = myVerwaltung.getMeineWaren().get(ware_id-1);
		if(myVerwaltung.warenEinfuegen(ware_id-1)) {
			System.out.println(pickedItem.getName()+ " has been added to " + myVerwaltung.getAusgewaehlteWarenkorb());
		}else {
			System.out.println("Item is not suitable for categorie:" + myVerwaltung.getAusgewaehlteWarenkorb().getKategorie());
		}
	}
	
	/**
	 * View all warenkorben.
	 */
	public static void viewAllWarenkorben() {
		System.out.println("| ID |        Kategorie       | Gesamtwert");
		System.out.println("-------------------------------------------");
		String line = "";
		for (int i = 0; i< myVerwaltung.getWarbenkorben().size(); i++) {
			// Offset for ID
			line += "| "+ (i+1) ;
			line += ((i+1)<10) ? "  ": " ";
			// Offset for Name
			line += "|   "+ myVerwaltung.getWarbenkorben().get(i).getKategorie();
			for (int x = 0; x <= 20 - myVerwaltung.getWarbenkorben().get(i).getKategorie().length(); x++) {
				line += " ";
			}
			//Offset for Preis
			line += "|   "+ myVerwaltung.getWarbenkorben().get(i).getWert() + "\n";
		}
		System.out.print(line);
	}
	
	/**
	 * Warenkorb wechseln.
	 */
	public static void warenkorbWechseln() {
		viewAllWarenkorben();
		System.out.println("Please choose which the index for the cart that you want");
		int index = sc.nextInt();
		while(index< 0 || index>myVerwaltung.getWarbenkorben().size()) {
			System.out.println("Wrong input. Please try again");
			index = sc.nextInt();
		}
		myVerwaltung.setWarenkorb(index-1);
		clear();
	}
	
	/**
	 * Bezahlen.
	 */
	public static void bezahlen() {
		clear();
		viewAllWarenkorben();
		System.out.println("Which cart do you want to pay for? Please select the ID of the cart");
		int warenkorb_id = sc.nextInt();
		while(warenkorb_id < 1 || warenkorb_id > myVerwaltung.getWarbenkorben().size()) {
			System.out.println("Wrong input. Please try again");
			warenkorb_id = sc.nextInt();
		}
		clear();
		if(!myVerwaltung.bezahlenLogik(warenkorb_id-1)) {
			System.out.println("There is nothing to pay for");
		} else {
			System.out.println("Payment successfull");
		}
	}
	
	/**
	 * Ausgewaehlte warenkorb greifen.
	 */
	public static void ausgewaehlteWarenkorbGreifen() {
		clear();
		Warenkorb auswahl = myVerwaltung.getAusgewaehlteWarenkorb();
		System.out.println("Warbenkorb: " + auswahl+ "\n");
		auswahl.getLaegsteMindesthaltbarkeitsdatum();
		auswahl.getGeringsteRecyclingAnteil();
		printProduct(auswahl.getMeineWaren());
		System.out.println("\n Summe: "+ auswahl.getWert());
		System.out.println("------------------------------------------");
		System.out.println("Function menu: [E]xit | [R]emove | [P]ay" );
		String option = sc.next();
		 while(!option.equalsIgnoreCase("e") && !option.equalsIgnoreCase("p") && !option.equalsIgnoreCase("r")) {
	 	    	System.out.println("Wrong input. Please try again");
	 	    	option = sc.next();
	 	    }
		if(option.equalsIgnoreCase("p")) {
			int index = myVerwaltung.getWarbenkorben().indexOf(auswahl);
			clear();
			if(!myVerwaltung.bezahlenLogik(index)) {
				System.out.println("There is nothing to pay for");
			} else {
				System.out.println("Payment successfull");
			}
		} else if(option.equalsIgnoreCase("r")){
				System.out.println("Please choose the index of the item that you would like to remove");
				int index = sc.nextInt();
				while((index< 0 || index>auswahl.getMeineWaren().size()) && !auswahl.getMeineWaren().isEmpty()) {
					System.out.println("Wrong input. Please try again");
					index = sc.nextInt();
				}
				clear();
				if(myVerwaltung.warenEntfernen(index-1)) {
					System.out.println("Item has been removed");
				} else {
					System.out.println("Cart is empty");
				}	
		} else {
			clear();
		}
		
	}
	
	/**
	 * Clear.
	 */
	public static void clear() {
		for(int i = 0; i<=50; i++) {
			System.out.println("\n");
		}
	}


}
