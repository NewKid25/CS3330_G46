package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class PetView extends JFrame {
	private JPanel panel;
	
	public PetView() {
		setTitle("Animal Adaption Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JButton adoptButton = new JButton("Adopt");
		adoptButton.setBounds(238, 62, 117, 29);
		panel.add(adoptButton);
		
		JList list = new JList();
		list.setBounds(24, 35, 202, 214);
		panel.add(list);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(238, 103, 117, 29);
		panel.add(removeButton);
		
		JButton detailsButton = new JButton("View Details");
		detailsButton.setBounds(238, 144, 117, 29);
		panel.add(detailsButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(238, 186, 117, 29);
		panel.add(saveButton);
		
	}
}
