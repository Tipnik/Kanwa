package main;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
//        System.out.println("Created GUI on EDT? "+
//                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("DemoPaint");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,600);
        f.setLayout(new FlowLayout());
        
        JButton button = new JButton("Line");
        ButtonsPanel bPanel = new ButtonsPanel();
//        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.PAGE_AXIS));
        bPanel.add(button);
        
        f.add(new DrawPanel());
        f.add(bPanel);
        f.pack();
        
        f.setVisible(true);
    }

}
