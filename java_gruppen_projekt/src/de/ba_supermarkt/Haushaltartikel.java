package de.ba_supermarkt;

public class Haushaltartikel extends Waren{
	private int recylingAnteil;
	
    public Haushaltartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
    
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




