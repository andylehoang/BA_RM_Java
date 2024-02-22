/*
 * 
 */
package de.ba_supermarkt;


// TODO: Auto-generated Javadoc
/**
 * The Class Sonstige.
 */
public class Sonstige extends Waren {
	
	/** The fsk. */
	private int FSK;
	
	/**
	 * Instantiates a new sonstige.
	 *
	 * @param name the name
	 * @param EK the ek
	 * @param VK the vk
	 * @param FSK the fsk
	 */
	public Sonstige(String name, double EK, double VK, int FSK) {
		super(name,EK,VK);
		this.FSK = FSK;
	}

}
