package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import figures.Point;

public class ButtonsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] figuresStrings = { "Line", "Rectangle", "Circle" };
	private String[] colorsStrings = { "Black", "Red", "Green", "Blue", "White" };
	private static JComboBox<String> figuresList;
	private static JComboBox<String> colorsList;
	private static JCheckBox filled;
	private static JCheckBox equalProportions;
	private static JTextField xField;
	private static JLabel xFieldLabel;
	private static JTextField yField;
	private static JLabel yFieldLabel;
	private static JTextField xEField;
	private static JLabel xEFieldLabel;
	private static JTextField yEField;
	private static JLabel yEFieldLabel;
	private static JButton drawButton;
	private static JButton backButton;
	private static JButton editButton;
	

	public ButtonsPanel() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel tempPanel1 = new JPanel();
		tempPanel1.setLayout(new BoxLayout(tempPanel1, BoxLayout.Y_AXIS));

		figuresList = new JComboBox<String>(figuresStrings);
		figuresList.setMaximumSize(new Dimension(130, 50));
		
		colorsList = new JComboBox<String>(colorsStrings);
		colorsList.setMaximumSize(new Dimension(130, 50));

		equalProportions = new JCheckBox("Eq. prop.?");

		equalProportions.setEnabled(false);
		filled = new JCheckBox("Filled?");
		filled.setEnabled(false);

		JPanel tempPanel2 = new JPanel();
		tempPanel2.setLayout(new BoxLayout(tempPanel2, BoxLayout.Y_AXIS));

		xFieldLabel = new JLabel("Start X");
		xField = new JTextField("0", 3);
		xField.setMaximumSize(new Dimension(120, 30));

		yFieldLabel = new JLabel("Start Y");
		yField = new JTextField("0", 3);
		yField.setMaximumSize(new Dimension(120, 30));

		xEFieldLabel = new JLabel("End X");
		xEField = new JTextField("0", 3);
		xEField.setMaximumSize(new Dimension(120, 30));

		yEFieldLabel = new JLabel("End Y");
		yEField = new JTextField("0", 3);
		yEField.setMaximumSize(new Dimension(120, 30));

		figuresList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (figuresList.getSelectedIndex() != 0) {
					filled.setEnabled(true);
					equalProportions.setEnabled(true);
				} else {
					filled.setEnabled(false);
					equalProportions.setEnabled(false);
				}
			}

		});

		JPanel tempPanel3 = new JPanel();
		tempPanel3.setSize(160, 60);

		drawButton = new JButton("Draw");
		backButton = new JButton("Back");
		editButton = new JButton("Edit");

		tempPanel1.add(figuresList);
		tempPanel1.add(colorsList);
		tempPanel1.add(filled);
		tempPanel1.add(equalProportions);

		this.add(tempPanel1);

		tempPanel2.add(xFieldLabel);
		tempPanel2.add(xField);
		tempPanel2.add(yFieldLabel);
		tempPanel2.add(yField);
		tempPanel2.add(xEFieldLabel);
		tempPanel2.add(xEField);
		tempPanel2.add(yEFieldLabel);
		tempPanel2.add(yEField);

		this.add(tempPanel2);

		tempPanel3.add(drawButton);
		tempPanel3.add(editButton);
		tempPanel3.add(backButton);

		this.add(tempPanel3);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(160, 600);
	}

	public static int getSelection() {
		return figuresList.getSelectedIndex();
	}

	public static Boolean getFilled() {
		return filled.isSelected();
	}

	public static Boolean getProportions() {
		return equalProportions.isSelected();
	}
	
	public static Color getColor(){
		switch (colorsList.getSelectedIndex()) {
		case 0:
			
			return Color.BLACK;
			
		case 1:
			
			return Color.RED;
			
		case 2:
			
			return Color.GREEN;
			
		case 3:
			
			return Color.BLUE;
			
		case 4:
			
			return Color.WHITE;

		default:
			break;
		}
		
		return Color.PINK;
	}

	public static JButton getDrawButton() {
		return drawButton;
	}
	
	public static JButton getBackButton() {
		return backButton;
	}
	
	public static JButton getEditButton() {
		return editButton;
	}

	public static Point getStartPoint() throws Exception {
		return new Point(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()));
	}

	public static Point getEndPoint() throws Exception {

		return new Point(Integer.parseInt(xEField.getText()), Integer.parseInt(yEField.getText()));
	}

}
