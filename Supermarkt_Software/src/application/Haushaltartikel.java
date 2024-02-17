package application;

public class Haushaltartikel extends Waren{
	private int recylingAnteil;
	
    public Haushaltartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
}
