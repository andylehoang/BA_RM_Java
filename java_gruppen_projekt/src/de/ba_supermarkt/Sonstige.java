package de.ba_supermarkt;


public class Sonstige extends Waren {
	private int FSK;
	public Sonstige(String name, double EK, double VK, int FSK) {
		super(name,EK,VK);
		this.FSK = FSK;
	}

}