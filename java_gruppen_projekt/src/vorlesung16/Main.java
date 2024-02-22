/*
 * 
 */
package vorlesung16;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Hund> someList = new ArrayList<Hund>();
		someList.add(new Hund("A",1));
		someList.add(new Hund("B",2));
		someList.add(new Hund("A",3));
		ListIterator iterator = someList.listIterator();
		
		while(iterator.hasNext()) {
			Hund hund = (Hund) iterator.next();
			System.out.println(hund);
		}

	}

}
