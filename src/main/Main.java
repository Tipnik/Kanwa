package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		JFrame f = new JFrame("DemoPaint");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1060, 600);

		JPanel mainPanel = new JPanel();
		
		ButtonsPanel bPanel = new ButtonsPanel();
		DrawPanel drawPanel = new DrawPanel();
		
		mainPanel.add(drawPanel);
		mainPanel.add(bPanel);
		f.add(mainPanel);
		f.pack();

		f.setVisible(true);
	}

}
