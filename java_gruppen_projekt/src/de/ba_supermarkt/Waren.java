/*
 * 
 */
package de.ba_supermarkt;

 // TODO: Auto-generated Javadoc
/**
  * The Class Waren.
  */
 public class Waren {
	
	/** The counter. */
	private static int counter= 0;
    
    /** The id. */
    private int id;
    
    /** The verkauf preis. */
    private double einkaufPreis, verkaufPreis;
    
    /** The name. */
    private String name;
    
    /**
     * Instantiates a new waren.
     *
     * @param name the name
     * @param EK the ek
     * @param VK the vk
     */
    public Waren(String name, double EK, double VK) {
    	this.id = ++counter;
    	this.name = name;
    	this.einkaufPreis = EK;
    	this.verkaufPreis = VK;
    } 
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
    	return this.id;
    }
    
    /**
     * Gets the ek.
     *
     * @return the ek
     */
    public double getEK() {
    	return this.einkaufPreis;
    }
    
    /**
     * Gets the vk.
     *
     * @return the vk
     */
    public double getVK() {
    	return this.verkaufPreis;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
    	return this.getName();
    }
}