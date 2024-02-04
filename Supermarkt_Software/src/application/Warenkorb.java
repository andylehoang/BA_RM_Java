package application;
import java.util.*;

public class Warenkorb {
   private static int counter = 0;
   private ArrayList<String> waren;
   private double Wert;
   private String Kategorie;
   
   private int id; 
   
   public Warenkorb() {
	   this.waren = new ArrayList<String>();
	   this.Wert = 0.0;
	   this.id = ++counter;
	   
   }
   public int getID() {
	   return this.id;
   }
}
