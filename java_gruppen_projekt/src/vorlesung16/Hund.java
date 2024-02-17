package vorlesung16;

public class Hund {
	private String name;
	private float age;
	
	public Hund(String name, float age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Diese Hund heißt " + this.name + " und ist " + this.age +" Jahre alt";
		
	}

}
