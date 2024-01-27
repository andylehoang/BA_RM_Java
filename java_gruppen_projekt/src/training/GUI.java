package training;
import javax.swing.*;

public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("My first GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		JButton button = new JButton("Press");
		frame.getContentPane().add(button);
		frame.setVisible(true);
	
	}

}
