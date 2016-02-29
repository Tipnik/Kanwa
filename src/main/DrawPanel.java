package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import figures.Figure;
import figures.Line;
import figures.Oval;
import figures.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.LinkedList;

class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean DEBUG = false;

	private int X = 0;
	private int Y = 0;
	private int EX = 0;
	private int EY = 0;

	private LinkedList<Figure> figureList = new LinkedList<Figure>();

	public DrawPanel() {

		setSize(900, 600);

		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				startDraw(e.getX(), e.getY());

				if (DEBUG)
					System.out.println("Start " + e.getX() + " " + e.getY());

			}

		});

		addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {

				endDraw(e.getX(), e.getY());

				if (DEBUG)
					System.out.println("End " + e.getX() + " " + e.getY());

				figureList.add(newFigure(ButtonsPanel.getSelection()));

				X = Y = EX = EY = -1;

			}

		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {

				endDraw(e.getX(), e.getY());

				repaint(0, 0, 900, 600);

				if (DEBUG)
					System.out.println("Drag " + e.getX() + " " + e.getY());
			}
		});

		JButton button = ButtonsPanel.getDrawButton();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					addFigure(ButtonsPanel.getStartPoint().getX(), ButtonsPanel.getStartPoint().getY(),
							ButtonsPanel.getEndPoint().getX(), ButtonsPanel.getEndPoint().getY());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		button = ButtonsPanel.getBackButton();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				popFigure();

			}
		});
		
		button = ButtonsPanel.getEditButton();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					editFigure(ButtonsPanel.getStartPoint().getX(), ButtonsPanel.getStartPoint().getY(),
							ButtonsPanel.getEndPoint().getX(), ButtonsPanel.getEndPoint().getY());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

	}
	
	public void startDraw(int x, int y) {

		X = x;
		Y = y;

	};

	public void endDraw(int x, int y) {

		EX = x;
		EY = y;

	};
	
	private void editFigure(int x, int y, int xE, int yE){
		
		Figure editedFigure = figureList.pollLast();
		
		if (editedFigure==null){
			return;
		}
		
		figureList.add(newFigure(x, y, xE, yE));
		
		repaint(0, 0, 900, 600);
		
	}

	private void popFigure() {

		figureList.pollLast();

		repaint(0, 0, 900, 600);

	}

	private void addFigure(int x, int y, int xE, int yE) {

		try {

			figureList
					.add(newFigure(ButtonsPanel.getStartPoint().getX(), ButtonsPanel.getStartPoint().getY(),
							ButtonsPanel.getEndPoint().getX(), ButtonsPanel.getEndPoint().getY()));

			if (DEBUG) {
				System.out.println(ButtonsPanel.getStartPoint());
				System.out.println(ButtonsPanel.getEndPoint());
			}

			repaint(0, 0, 900, 600);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	Figure newFigure(int selection) {

		Figure returnedFigure = null;

		int tempX, tempY, tempEX, tempEY;

		tempEX = Math.abs(EX - X);
		tempEY = Math.abs(EY - Y);

		if (ButtonsPanel.getProportions()) {
			tempX = X < EX ? X : X - Math.min(tempEX, tempEY);
			tempY = Y < EY ? Y : Y - Math.min(tempEX, tempEY);

			tempEX = tempEY = Math.min(tempEX, tempEY);

		} else {

			tempX = X < EX ? X : EX;
			tempY = Y < EY ? Y : EY;
		}

		switch (ButtonsPanel.getSelection()) {
		case 0:
			returnedFigure = new Line(X, Y, EX, EY);
			break;

		case 1:
			returnedFigure = new Rectangle(tempX, tempY, tempEX, tempEY, ButtonsPanel.getFilled());
			break;

		case 2:
			returnedFigure = new Oval(tempX, tempY, tempEX, tempEY, ButtonsPanel.getFilled());
			break;

		default:
			returnedFigure = new Line(0, 0, 0, 0);
			break;
		}
		
		returnedFigure.setColor(ButtonsPanel.getColor());

		return returnedFigure;
	}

	public Figure newFigure(int x, int y, int xE, int yE) {

		Figure returnedFigure = null;

		int tempX, tempY, tempEX, tempEY;

		tempEX = Math.abs(xE - x);
		tempEY = Math.abs(yE - y);

		if (ButtonsPanel.getProportions()) {
			tempX = x < xE ? x : x - Math.min(tempEX, tempEY);
			tempY = y < yE ? y : y - Math.min(tempEX, tempEY);

			tempEX = tempEY = Math.min(tempEX, tempEY);

		} else {

			tempX = x < xE ? x : xE;
			tempY = y < yE ? y : yE;
		}

		switch (ButtonsPanel.getSelection()) {
		case 0:
			returnedFigure = new Line(x, y, xE, yE);
			break;

		case 1:
			returnedFigure = new Rectangle(tempX, tempY, tempEX, tempEY, ButtonsPanel.getFilled());
			break;

		case 2:
			returnedFigure = new Oval(tempX, tempY, tempEX, tempEY, ButtonsPanel.getFilled());
			break;

		default:
			returnedFigure = new Line(0, 0, 0, 0);
			break;
		}

		returnedFigure.setColor(ButtonsPanel.getColor());
		
		return returnedFigure;
	}

	public Dimension getPreferredSize() {
		return new Dimension(900, 600);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.setColor(Color.BLACK);
		
		drawFigures(g);

		if (X == -1 && Y == -1 && EX == -1 && EY == -1) {
			return;
		}

		drawTempFigure(g);

	}
	
	private void drawFigures(Graphics g){
		for (Figure f : figureList) {
			
			g.setColor(f.getColor());
			
			f.draw(g);

			if (DEBUG) {
				System.out.println("Drawing " + f.getClass());
			}
		}
	}
	
	private void drawTempFigure(Graphics g){
		
		g.setColor(ButtonsPanel.getColor());
		
		int tempX, tempY, tempEX, tempEY;

		tempEX = Math.abs(EX - X);
		tempEY = Math.abs(EY - Y);

		if (ButtonsPanel.getProportions()) {
			tempX = X < EX ? X : X - Math.min(tempEX, tempEY);
			tempY = Y < EY ? Y : Y - Math.min(tempEX, tempEY);

			tempEX = tempEY = Math.min(tempEX, tempEY);

		} else {

			tempX = X < EX ? X : EX;
			tempY = Y < EY ? Y : EY;
		}
		

		switch (ButtonsPanel.getSelection()) {
		case 0:
			g.drawLine(X, Y, EX, EY);
			
			g.setColor(Color.RED);
			
			g.drawString("("+X+","+Y+")", X, Y);
			
			g.drawString("("+EX+","+EY+")", EX, EY);
			
			g.setColor(ButtonsPanel.getColor());
			
			return;
			
//			break;

		case 1:
			
			
			
			if (ButtonsPanel.getFilled())
				g.fillRect(tempX, tempY, tempEX, tempEY);
			else
				g.drawRect(tempX, tempY, tempEX, tempEY);
			break;

		case 2:
			
			g.setColor(Color.RED);
			
			g.drawString("("+(tempEX/2+tempX)+","+(tempEY/2+tempY)+")", tempEX/2+tempX, tempEY/2+tempY);
			
			if (ButtonsPanel.getFilled())
				g.fillOval(tempX, tempY, tempEX, tempEY);
			else
				g.drawOval(tempX, tempY, tempEX, tempEY);
			break;

		default:
			break;
		}
		
		g.setColor(Color.RED);
		
		g.drawString("("+tempX+","+tempY+")", tempX, tempY);
		
		g.drawString("("+(tempEX+tempX)+","+(tempEY+tempY)+")", tempEX+tempX, tempEY+tempY);
		
		g.setColor(ButtonsPanel.getColor());
	}
	
	

}