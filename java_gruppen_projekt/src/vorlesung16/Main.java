package vorlesung16;
import java.util.*;

public class Main {

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