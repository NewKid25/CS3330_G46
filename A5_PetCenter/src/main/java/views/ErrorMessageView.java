package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ErrorMessageView extends JFrame {
	
	public ErrorMessageView (String msg)
	{
	
		setTitle("Error Message");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		
		var panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		
		var message = new JTextArea(msg);
		message.setBounds(50, 50, 500, 100);
		message.setWrapStyleWord(true);
		message.setEditable(false);
		panel.add(message);
		
		this.setVisible(true);
	}

}
