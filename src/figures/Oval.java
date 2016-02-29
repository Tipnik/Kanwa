package figures;

import java.awt.Graphics;

public class Oval extends Figure {
	
public Oval(int x, int y, int xE, int yE, Boolean filled){
		
		super(x, y, xE, yE);
		
		this.filled = filled;
	}

	@Override
	public void draw(Graphics g) {
		if (filled)
			g.fillOval(X, Y, XE, YE);
		else
			g.drawOval(X, Y, XE, YE);

	}

}
