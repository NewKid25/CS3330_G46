package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.NormalAnimal;

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
	public int getPetDetails() {
		PetView petview = new PetView();
		int index = petview.adoptList.getSelectedIndex();
//		petview.adoptList.getSelectedValue().getClass().getName();
//		petview.adoptList.getSelectedValue().getClass().getId();
//		petview.adoptList.getSelectedValue().getClass().gettype();
//		petview.adoptList.getSelectedValue().getClass().getspecies();
//		petview.adoptList.getSelectedValue().getClass().getage();
		return 0;
	}
	
}
