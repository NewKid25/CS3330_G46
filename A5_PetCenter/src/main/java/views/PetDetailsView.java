package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.NormalAnimal;
import models.Pet;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PetDetailsView extends JFrame {
	private JPanel panel;
	public JTextField petName;
	public JTextField petID;
	public JTextField petType;
	public JTextField petSpecies;
	public JTextField petAge;

	public PetDetailsView(Pet pet, boolean isEditable) throws HeadlessException {
		setTitle("Animal Details Page");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 200, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(94, 40, 61, 16);
		panel.add(nameLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(94, 81, 61, 16);
		panel.add(idLabel);
		
		JLabel typeLabel = new JLabel("Type:");
		typeLabel.setBounds(94, 117, 61, 16);
		panel.add(typeLabel);
		
		JLabel speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(94, 158, 61, 16);
		panel.add(speciesLabel);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setBounds(94, 200, 61, 16);
		panel.add(ageLabel);
		
		petName = new JTextField();
		petName.setEditable(isEditable);
		petName.setBounds(167, 35, 130, 26);
		panel.add(petName);
		petName.setColumns(10);
		
		petID = new JTextField();
		petID.setEditable(isEditable);
		petID.setColumns(10);
		petID.setBounds(167, 76, 130, 26);
		panel.add(petID);
		
		petType = new JTextField();
		petType.setEditable(isEditable);
		petType.setColumns(10);
		petType.setBounds(167, 112, 130, 26);
		panel.add(petType);
		
		petSpecies = new JTextField();
		petSpecies.setEditable(isEditable);
		petSpecies.setColumns(10);
		petSpecies.setBounds(167, 153, 130, 26);
		panel.add(petSpecies);
		
		petAge = new JTextField();
		petAge.setEditable(isEditable);
		petAge.setColumns(10);
		petAge.setBounds(167, 195, 130, 26);
		panel.add(petAge);
		
		if(pet != null)
		{			
			setTextFeilds(pet);
		}
		
		this.setVisible(true);
	}
	
	public void setTextFeilds(Pet pet)
	{
		petName.setText(pet.getName());
		petID.setText(Integer.toString(pet.getId()));
		petType.setText(pet.getType());
		petSpecies.setText(pet.getSpecies());
		petAge.setText(Integer.toString(pet.getAge()));
		
	}
	

}
