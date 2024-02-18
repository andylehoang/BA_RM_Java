package de.ba_supermarkt;

import java.util.*;


public class Main {
	 
	 private static Verwaltung myVerwaltung;
	 private static Scanner sc = new Scanner(System.in);
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myVerwaltung = new Verwaltung();
		boolean exit = false;
		System.out.println("Welcome to BA Supermarket");
		
		
		while(!exit){
	      try {
	    		printProduct();
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
		        	  viewAllWarenkorben();
		       	      System.out.println("[R]eturn");
		       	      input = sc.next();
		       	      while(!input.equalsIgnoreCase("r")) {
		       		    System.out.println("Wrong input");
		       		    input = sc.next();
		       	      }
		          }else {
		        	  exit = true;
		          }  
		    } catch (InputMismatchException e) {
	           sc.next();
		    	System.out.println("Wrong input type");
		    	System.out.println("Process Canceled \n \n");
		    }
	    	
	    } 
	    
	    System.out.print("Exited");
	}
	
	
	
	
	
	
	
	
	public static void printMenu() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Current cart: " + myVerwaltung.getAusgewaehlteWarenkorb());
		System.out.println("-----------------------------------------------------");
		System.out.println("Function menu: [A]dd new Cart | [C]hange cart; | [V]iew all cart | [G]rab information of current cart | [E]xit | [B]uy | [P]ay" );
		System.out.println("-----------------------------------------------------");		
	}
	
	public static void printProduct() {
		System.out.println("| ID |          Name         | Preis");
		System.out.println("------------------------------------");
		String line = "";
		for (Waren ware: myVerwaltung.getMeineWaren()) {
			// Offset for ID
			line += "| "+ ware.getId() ;
			line += (ware.getId() < 10) ? "  ": " ";
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
	 	    	kategorie = sc.next();
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
	}
	
	public static void warenKaufen() {
		int ware_id = 0;
		System.out.println("Please choose the id of the item that you want to buy");
		ware_id = sc.nextInt();
		while(ware_id > 12 || ware_id < 1) {
			System.out.println("Wrong input. Please try again");
			ware_id = sc.nextInt();
		}
		myVerwaltung.warenEinfuegen(ware_id);
	}
	
	public static void viewAllWarenkorben() {
		System.out.println("| ID |        Kategorie       | Gesamtwert");
		System.out.println("-------------------------------------------");
		String line = "";
		for (Warenkorb korb: myVerwaltung.getWarbenkorben()) {
			// Offset for ID
			line += "| "+ korb.getID() ;
			line += (korb.getID()<10) ? "  ": " ";
			// Offset for Name
			line += "|   "+ korb.getKategorie();
			for(int i = 0; i<= 20 - korb.getKategorie().length(); i++) {
				line += " ";
			}
			//Offset for Preis
			line += "|   "+ korb.getWert() + "\n";
		}
		System.out.print(line);
	}
	
	public static void warenkorbWechseln() {
		viewAllWarenkorben();
		System.out.println("Please choose which the index for the cart that you want");
		int index = sc.nextInt();
		while(index< 0 || index>myVerwaltung.getWarbenkorben().size()) {
			System.out.println("Wrong input. Please try again");
			index = sc.nextInt();
		}
		myVerwaltung.setWarenkorb(index-1);
	}
	
	public void bezahlen() {
		
	}


}
