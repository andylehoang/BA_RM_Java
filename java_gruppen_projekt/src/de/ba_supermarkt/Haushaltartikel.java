/*
 * 
 */
package de.ba_supermarkt;

// TODO: Auto-generated Javadoc
/**
 * The Class Haushaltartikel.
 */
public class Haushaltartikel extends Waren{
	
	/** The recyling anteil. */
	private int recylingAnteil;
	
    /**
     * Instantiates a new haushaltartikel.
     *
     * @param name the name
     * @param EK the ek
     * @param VK the vk
     * @param anteile the anteile
     */
    public Haushaltartikel(String name, double EK, double VK, int anteile) {
    	super(name,EK,VK);
    	this.recylingAnteil = anteile;
    }
    
    /**
     * Gets the recyling anteile.
     *
     * @return the recyling anteile
     */
    public int getRecylingAnteile() {
    	return this.recylingAnteil;
    }
}




