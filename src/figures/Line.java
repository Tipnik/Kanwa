package figures;

import java.awt.Graphics;

public class Line extends Figure {
	
	public Line(int x, int y, int xE, int yE){
		
		super(x, y, xE, yE);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(X, Y, XE, YE);
		
	}

}
