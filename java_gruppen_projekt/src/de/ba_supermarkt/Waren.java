package de.ba_supermarkt;

public class Waren {
	private static int counter= 0;
    private int id;
    private double einkaufPreis, verkaufPreis;
    private String name;
    
    public Waren(String name, double EK, double VK) {
    	this.id = ++counter;
    	this.name = name;
    	this.einkaufPreis = EK;
    	this.verkaufPreis = VK;
    } 
    public int getId() {
    	return this.id;
    }
    
    public double getEK() {
    	return this.einkaufPreis;
    }
    
    public double getVK() {
    	return this.verkaufPreis;
    }
    
    public String getName() {
    	return this.name;
    }
    
    @Override
    public String toString() {
    	return this.getId() + "." + this.getName();
    }
}