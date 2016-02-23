package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonsPanel  extends JPanel  {
	
	JButton button = new JButton("Line");
	private static JComboBox petList;
	
//	void add(button);
	
	public ButtonsPanel(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		String[] petStrings = { "Line", "Rectangle", "Circle" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		petList = new JComboBox(petStrings);
//		petList.setSelectedIndex(4);
//		petList.addActionListener(this);
		
		this.add(petList);
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(100, 600);
	}
	
	public static int getSelection(){
		return petList.getSelectedIndex();
	}

}
