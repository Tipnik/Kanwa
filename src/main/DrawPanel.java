package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;

class DrawPanel extends JPanel {

	// private int squareX = 50;
	// private int squareY = 50;
	// private int squareW = 20;
	// private int squareH = 20;
	private int X = 0;
	private int Y = 0;
	private int EX = 0;
	private int EY = 0;

	public void startDraw(int x, int y) {
		
		switch (ButtonsPanel.getSelection()) {
		case 0:
			X = x;
			Y = y;
			
			break;
			
		case 1:
			X = x;
			Y = y;
			
			break;

		default:
			break;
		}

		
		
	};

	public void endDraw(int x, int y) {

		switch (ButtonsPanel.getSelection()) {
		case 0:
			EX = x;
			EY = y;
			
			break;
			
		case 1:
			EX = x;
			EY = y;
			
			break;

		default:
			break;
		}
		

	};

	// public void dragLine(int x, int y) {
	//
	// };

	public DrawPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// moveSquare(e.getX(), e.getY());

				startDraw(e.getX(), e.getY());
				
//				System.out.println("Start " + e.getX() + " " + e.getY());

			}

		});

		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				// moveSquare(e.getX(), e.getY());

				endDraw(e.getX(), e.getY());
				
//				System.out.println("End " + e.getX() + " " + e.getY());

			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {

				// moveSquare(e.getX(), e.getY());

				endDraw(e.getX(), e.getY());
				
				repaint(0, 0, 900, 600);

//				System.out.println("Drag " + e.getX() + " " + e.getY());
			}
		});

	}

	// private void moveSquare(int x, int y) {
	// int OFFSET = 1;
	// if ((squareX != x) || (squareY != y)) {
	// repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
	// squareX = x;
	// squareY = y;
	// repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
	// }
	// }

	public Dimension getPreferredSize() {
		return new Dimension(900, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Text
		// g.drawString("This is my custom Panel!",10,20);
		// Ken Joy
		// coursera.org

		// g.setColor(Color.RED);
		// g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		// g.drawRect(squareX, squareY, squareW, squareH);

		switch (ButtonsPanel.getSelection()) {
		case 0:
			g.drawLine(X, Y, EX, EY);
			
			break;

		case 1:
			g.fillRect(X, Y, EX - X, EY - Y);
			break;
			
		case 2:
			g.fillRect(X, Y, EX - X, EY - Y);
			break;
			
		default:
			break;
		}
		
		
//		System.out.println(lineX +" "+ lineY +" "+ lineEX +" "+ lineEY);
		
//		g.drawLine(0, 0, 500, 500);

	}
}