package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Pet;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;

public class PetView extends JFrame {
	private JPanel panel;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton detailsButton;
	public JList<Object> adoptList;
	private JButton saveButton;
	private JLabel adoptLabel;
	
	public PetView(List<Pet> petList) {
		setTitle("Animal Adaption Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		adoptButton = new JButton("Adopt");
		adoptButton.setBounds(164, 62, 117, 29);
		panel.add(adoptButton);
		
		adoptList = new JList<Object>(petList.toArray());
		adoptList.setBounds(24, 35, 128, 214);
		panel.add(adoptList);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(164, 104, 117, 29);
		panel.add(removeButton);
		
		detailsButton = new JButton("View Details");
		detailsButton.setBounds(164, 145, 117, 29);
		panel.add(detailsButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(164, 185, 117, 29);
		panel.add(saveButton);
		
		adoptLabel = new JLabel("Pets to Adopt");
		adoptLabel.setBounds(37, 18, 92, 16);
		panel.add(adoptLabel);
		
		JList adoptedList = new JList();
		adoptedList.setBounds(325, 35, 128, 214);
		panel.add(adoptedList);
		
		JLabel adoptedLabel = new JLabel("Pets Adopted");
		adoptedLabel.setBounds(346, 18, 92, 16);
		panel.add(adoptedLabel);
		
		this.setVisible(true);
	}
}
