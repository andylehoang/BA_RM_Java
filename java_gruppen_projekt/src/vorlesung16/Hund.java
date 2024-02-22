/*
 * 
 */
package vorlesung16;

// TODO: Auto-generated Javadoc
/**
 * The Class Hund.
 */
public class Hund {
	
	/** The name. */
	private String name;
	
	/** The age. */
	private float age;
	
	/**
	 * Instantiates a new hund.
	 *
	 * @param name the name
	 * @param age the age
	 */
	public Hund(String name, float age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Diese Hund heißt " + this.name + " und ist " + this.age +" Jahre alt";
		
	}

}
