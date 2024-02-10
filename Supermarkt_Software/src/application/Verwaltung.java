package application;
import java.util.*;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Verwaltung {
    private ObservableList<Warenkorb> Warenkorben;
    private ArrayList<String> globalValue = new ArrayList<String>(FXCollections.observableArrayList("Apple", "Banana", "Pie"));
    
    public Verwaltung() {
    	Warenkorben = FXCollections.observableArrayList();
    	Warenkorben.addListener(new ListChangeListener<Warenkorb>() {
    		  public void onChanged(Change<? extends Warenkorb> c) {
    			 ArrayList<String> i = new ArrayList<String>();
    		    for(Warenkorb w:Warenkorben) {
    		    	i.add(w.getKategorie()+ w.getID());
    		    }
    		    System.out.println(i);	
    		  }
    		});
    }
    
    public void addWarenkorb(Warenkorb warenkorb) {
    	this.Warenkorben.add(warenkorb);	
    }
    
    public ArrayList<String> getGlobalValue(){
    	return this.globalValue;
    }
   }
