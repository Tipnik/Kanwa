package figures;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	
	protected int X;
	protected int Y;
	protected int XE;
	protected int YE;
	
	protected Boolean filled = false;
	
	protected Color color = null;
	
	public Figure(int x, int y, int xE, int yE){
		
		X = x;
		Y = y;
		XE = xE;
		YE = yE;
	}
	
	public abstract void draw(Graphics g);
	
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getXE() {
		return XE;
	}
	public void setXE(int xE) {
		XE = xE;
	}
	public int getYE() {
		return YE;
	}
	public void setYE(int yE) {
		YE = yE;
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color c){
		this.color = c;
	}
	
}
