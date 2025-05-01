package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PetDetailsView extends JFrame {
	private JPanel panel;

	public PetDetailsView() throws HeadlessException {
		setTitle("Animal Details Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
	}
	public void getPetDetails() {
		//gets the detail of the animal selected and prints them on the window
	}
	
}
