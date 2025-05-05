package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import models.NormalAnimal;
import models.Pet;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class PetView extends JFrame {
	private JPanel panel;
	private JButton addButton;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton detailsButton;
	public JList<Pet> adoptList;
	private JButton saveButton;
	private JLabel adoptLabel;
	private JComboBox comboBox;

	/**
	 * sets up the main window when users start the program
	 * @param petList
	 */
	public PetView(List<Pet> petList) {
		setTitle("Animal Adaption Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		
		int btnStartY = 260;
		int btnSpacingY = 40;
		
		addButton = new JButton("Add");
		addButton.setBounds(164, btnStartY+btnSpacingY*0, 117, 29);
		panel.add(addButton);
		
		adoptButton = new JButton("Adopt");
		adoptButton.setBounds(164, btnStartY+btnSpacingY*1, 117, 29);
		panel.add(adoptButton);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(164, btnStartY+btnSpacingY*2, 117, 29);
		panel.add(removeButton);
		
		detailsButton = new JButton("View Details");
		detailsButton.setBounds(164,  btnStartY+btnSpacingY*3, 117, 29);
		panel.add(detailsButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(164,  btnStartY+btnSpacingY*4, 117, 29);
		panel.add(saveButton);
		
		adoptList = new JList<Pet>(petList.toArray(new Pet[0]));
		adoptList.setBounds(25, 35, 450, 214);
		panel.add(adoptList);
		
		adoptLabel = new JLabel("Pets in the Pet Center");
		adoptLabel.setBounds(37, 18, 150, 16);
		panel.add(adoptLabel);
		
		String[] dropdown = {"Sort by", "id", "name","type", "species", "age"};
		comboBox = new JComboBox<String>(dropdown);
		comboBox.setToolTipText("");
		comboBox.setBounds(199, 6, 98, 27);
		panel.add(comboBox); 
		
		
		this.setVisible(true);
	}
	
	/**
	 * adds actions listener to add button
	 * @param listener
	 */
	public void addActionListenerToAddButton(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	/**
	 * adds actions listener to remove button
	 * @param listener
	 */
	public void addActionListenerToRemoveButton(ActionListener listener) {
		removeButton.addActionListener(listener);
	}
	/**
	 * adds actions listener to adopt button
	 * @param listener
	 */
	public void addActionListenerToAdoptButton(ActionListener listener) {
		adoptButton.addActionListener(listener);
	}
	/**
	 * adds actions listener to details button
	 * @param listener
	 */
	public void addActionListenerToDetailsButton(ActionListener listener) {
		detailsButton.addActionListener(listener);
	}
	/**
	 * adds actions listener to save button
	 * @param listener
	 */
	public void addActionListenerToSaveButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	/**
	 * adds actions listener to combo box
	 * @param listener
	 */
	public void addActionListenerToComboBox(ActionListener listener) {
		comboBox.addActionListener(listener);
	}
	/**
	 * gets the model
	 * @return
	 */
	public ListModel<Pet> getUserList() {
		return adoptList.getModel();
	}
	/**
	 * sets up the pet list in the pop-up window
	 * @param petList
	 */
	public void setPetList(List<Pet> petList)
	{
		var model = new DefaultListModel<Pet>();
		for(var pet : petList)
		{
			model.addElement(pet);
		}
		adoptList.setModel(model);
	}
	/**
	 * gets selected index of a pet
	 * @return
	 */
	public int getSelectedPetIndex() {
		System.out.println("Selected user index: " + adoptList.getSelectedIndex());
		return adoptList.getSelectedIndex();
	}
	/**
	 * gets selected multiple indices of pets selected
	 * @return
	 */
	public int[] getSelectedPetsIndices() {
		return adoptList.getSelectedIndices();
	}
	
	public String getSelectedSortType()
	{
		return (String) comboBox.getSelectedItem();
	}
}
