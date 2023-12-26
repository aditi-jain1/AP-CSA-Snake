package Snake;

import java.awt.Color;
import java.awt.Graphics2D;

public class bush {
	private int x;
	private int y;
	private Color darkGreen = new Color (140,199,107);
	private Color green = new Color(39,150,111);
	public bush(int xCoord, int yCoord) {
		x = xCoord;
		y = yCoord;
	}
	
	public void drawBush(Graphics2D win) {
		win.setColor(darkGreen);
		win.fillRect(x, y+10, 40,40);
		win.setColor(green);
		win.fillRect(x, y, 40,40);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
