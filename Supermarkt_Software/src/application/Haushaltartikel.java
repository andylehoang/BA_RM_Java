package application;

public class Haushaltartikel extends Waren{
	private String[] recylingAnteil;
	
    public Haushaltartikel(String name, double EK, double VK, String[] anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
}
