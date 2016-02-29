package figures;

import java.awt.Graphics;

public class Rectangle extends Figure {
	
	public Rectangle(int x, int y, int xE, int yE, Boolean filled){
		
		super(x, y, xE, yE);
		
		this.filled = filled;
	}

	@Override
	public void draw(Graphics g) {
		if (filled)
			g.fillRect(X, Y, XE, YE);
		else
			g.drawRect(X, Y, XE, YE);

	}

}
