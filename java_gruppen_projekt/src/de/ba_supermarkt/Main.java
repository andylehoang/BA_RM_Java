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
		
		
	  do {
	    try {
	    		printMenu();
	    	    String input = sc.next();
	    	   //Check if input is valid
	    	    while(!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("v") && !input.equalsIgnoreCase("g") && !input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("b")) {
	    	    	System.out.println("Wrong input. Please try again");
	    	    	printMenu();
	    	    	input = sc.next();
	    	    }
	    	    //Check if user want to exit
		          if(input.equalsIgnoreCase("a")) {
		        	  menuAddWarenkorb();
		        	  System.out.println("Info from cart: " + myVerwaltung.getAusgewaehlteWarenkorb());
		        	  System.out.println(myVerwaltung.getAusgewaehlteWarenkorb().getMeineWaren());
		          } else if(input.equalsIgnoreCase("g")) {
		        	 
		          } else {
		        	  exit = true;
		          }
		    
	    	    System.out.println(input);
		    } catch (InputMismatchException e) {
		    	System.out.println("Wrong input type");
		    	System.out.println("Process Canceled \n \n");
		    	sc.next();
		    	
		    }
	    	
	    } while(!exit);
	    
	    System.out.print("Exited");
	}
	
	
	
	
	
	
	
	
	public static void printMenu() {
		System.out.println("-------------");
		System.out.println("Function menu: [A]dd new Cart | [C]hange cart; | [V]iew all cart | [G]rab information of current cart | [E]xit | [B]uy" );
		System.out.println("-------------");
			
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
			kategorie = "Öko Prinzip";
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
	


}
