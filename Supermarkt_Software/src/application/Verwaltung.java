package application;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Verwaltung {
    private ObservableList<Warenkorb> Warenkorben;
    
    public Verwaltung() {
    	Warenkorben = FXCollections.observableArrayList();
    	Warenkorben.addListener(new ListChangeListener<Warenkorb>() {
    		  public void onChanged(Change<? extends Warenkorb> c) {
    			 ArrayList<Integer> i = new ArrayList<Integer>();
    		    for(Warenkorb w:Warenkorben) {
    		    	i.add(w.getID());
    		    }
    		    System.out.println(i);	
    		  }
    		});
    }
    
    public void addWarenkorb(Warenkorb warenkorb) {
    	this.Warenkorben.add(warenkorb);	
    }
   }
