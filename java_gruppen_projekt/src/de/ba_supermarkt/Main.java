package de.ba_supermarkt;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verwaltung myVerwaltung = new Verwaltung();
		Scanner sc = new Scanner(System.in);
		
		// Add a new Warenkorb
		System.out.println("Welcome to BA Supermarket");
		printMenu();
		
		

	}
	
	public static void printMenu() {
		System.out.println("-------------");
		System.out.println("Function menu: [A]dd new Cart | [C]hange cart; | [V]iew all cart | [G]rab information of current cart" );
		System.out.println("-------------");
		
	}

}
