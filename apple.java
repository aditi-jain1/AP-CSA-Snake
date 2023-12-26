package Snake;
import utilities.GDV5;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class apple extends Rectangle{
	private int xCoord;
	private int yCoord;
	private int sizeStep = 1;
	private int appleShineSize = 10;
	private int appleSizeCounter = 0;
	private int blockDirection;
	private int appleSize = 40;
	private int moveCounter = 0;
	//private images lotus = new images();
	//private images lotus2 = new images();
	private Color red = new Color (229,79,36);
	private Color green = new Color (73,197,39);
	private Color pink = new Color (238,117,92);
	private Color darkGreen = new Color (140,199,107);
	private Color purple = new Color(156,108,224);
	private Color purpleHighlight = new Color(195,145,230);
	private Color blue = new Color(78,122,235);
	private boolean poisonousApple = false;
	static boolean underwaterMode = false;
	
	public apple(int xCoordinate, int yCoordinate) {
		super(xCoordinate,yCoordinate,30, 30);
		xCoord = xCoordinate;
		yCoord = yCoordinate;
	}
	
	public void setPoisonousApple(boolean x) {
		poisonousApple = x;
	}
	
	public static void setUnderWaterMode(boolean isUnderWater) {
		underwaterMode = isUnderWater;
	}
	
	public int getXCoord() {
		return xCoord;
	}
	public int getYCoord() {
		return yCoord;
	}
	public void drawApple(Graphics2D win) {
		/*
		if (underwaterMode == false) {
			win.setColor(darkGreen);
			win.fillOval(xCoord, yCoord+10, appleSize,appleSize);
			win.setColor(green);
			win.fillPolygon(new int[] {xCoord+13, xCoord+23, xCoord+30}, new int[] {yCoord, yCoord-4, yCoord-16}, 3);
			win.fillPolygon(new int[] {xCoord+13, xCoord+20, xCoord+30}, new int[] {yCoord, yCoord-12, yCoord-16}, 3);
			win.setColor(red);
			win.fillOval(xCoord, yCoord, appleSize, appleSize);
			win.setColor(pink);
			win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
			if (poisonousApple == true) {
				win.setColor(purple);
				win.fillOval(xCoord, yCoord, appleSize, appleSize);
				win.setColor(purpleHighlight);
				win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
			}
		}
		else {
			win.drawImage(lotus.lotus, xCoord-12, yCoord-20, 70,70,null);
			if (poisonousApple == true) {
				win.drawImage(lotus2.lotus2, xCoord-12, yCoord-20, 70,70,null);
			}
		}
		*/
		win.setColor(darkGreen);
		win.fillOval(xCoord, yCoord+10, appleSize,appleSize);
		win.setColor(green);
		win.fillPolygon(new int[] {xCoord+13, xCoord+23, xCoord+30}, new int[] {yCoord, yCoord-4, yCoord-16}, 3);
		win.fillPolygon(new int[] {xCoord+13, xCoord+20, xCoord+30}, new int[] {yCoord, yCoord-12, yCoord-16}, 3);
		win.setColor(red);
		win.fillOval(xCoord, yCoord, appleSize, appleSize);
		win.setColor(pink);
		win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
		if (poisonousApple == true) {
			win.setColor(purple);
			win.fillOval(xCoord, yCoord, appleSize, appleSize);
			win.setColor(purpleHighlight);
			win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
		}
		
	}
	int appleDirection =1;
	public void moveApples() {
		//moveCounter++;
		if (moveCounter%160==0) {
			appleDirection = (int) (Math.random()*8+1);
		}
		moveCounter++;
		if (appleDirection == 1) {
			xCoord++;
		}
		if (appleDirection == 2) {
			yCoord++;
		}
		if (appleDirection ==3) {
			xCoord--;
		}
		if (appleDirection == 4) {
			xCoord--;
		}
		if (appleDirection == 5) {
			xCoord++;
			yCoord++;
		}
		if (appleDirection == 6) {
			xCoord++;
			yCoord--;
		}
		if (appleDirection ==7) {
			xCoord--;
			yCoord++;
		}
		if (appleDirection == 8) {
			xCoord--;
			yCoord--;
		}
		if (xCoord +100 >= 800) {
			appleDirection = 3;
		}
		if (xCoord  <= 40) {
			appleDirection = 1;
		}
		if (yCoord +80 >= 800) {
			appleDirection = 4;
		}
		if (yCoord  <= 40) {
			appleDirection = 2;
		}
	}
	
	public void drawGameOverApple(Graphics2D win) {
		win.setColor(green);
		win.fillPolygon(new int[] {xCoord+13, xCoord+23, xCoord+30}, new int[] {yCoord, yCoord-4, yCoord-16}, 3);
		win.fillPolygon(new int[] {xCoord+13, xCoord+20, xCoord+30}, new int[] {yCoord, yCoord-12, yCoord-16}, 3);
		win.setColor(red);
		win.fillOval(xCoord, yCoord, appleSize, appleSize);
		win.setColor(pink);
		win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
		if (poisonousApple == true) {
			win.setColor(purple);
			win.fillOval(xCoord, yCoord, appleSize, appleSize);
			win.setColor(purpleHighlight);
			win.fillOval(xCoord+5, yCoord+5, appleShineSize,appleShineSize);
		}
	}
	
	public void drawScoreApple(Graphics2D win) {
		if (underwaterMode == false) {
			win.setColor(green);
			win.fillPolygon(new int[] {xCoord+13, xCoord+23, xCoord+30}, new int[] {yCoord, yCoord-2, yCoord-8}, 3);
			win.fillPolygon(new int[] {xCoord+13, xCoord+20, xCoord+30}, new int[] {yCoord, yCoord-6, yCoord-8}, 3);
			win.setColor(red);
			win.fillOval(xCoord, yCoord, 25, 25);
			win.setColor(pink);
			win.fillOval(xCoord+5, yCoord+5, 10, 10);
			
		}
		else {
			//win.drawImage(lotus.lotus, xCoord, yCoord-15, 45,45,null);
		}
		win.setColor(blue);
		win.fillRect(xCoord+80,yCoord-5,80,30);
		win.fillOval(xCoord+80-15,yCoord-5,30,30);
		win.fillOval(xCoord+80+80-15,yCoord-5,30,30);
	}
	
	public void drawEatenApple(Graphics2D win) {
		win.setColor(blue);
		win.fillOval(xCoord-5, yCoord-5, 50,50);
	}
	
	public void drawSplashApple(Graphics2D win) {
		win.setColor(green);
		
		//win.fillPolygon(new int[] {xCoord+13+20, xCoord+30+40, xCoord+13+20,xCoord+30+40}, new int[] {yCoord, yCoord-40,yCoord, yCoord-40}, 4);
		//win.fillPolygon(new int[] {xCoord+13+20, xCoord+20+40, xCoord+30+50}, new int[] {yCoord, yCoord-10, yCoord-15}, 3);
		win.setColor(red);
		win.fillOval(xCoord, yCoord, 90, 90);
		win.setColor(pink);
		win.fillOval(xCoord+20, yCoord+20, 30, 30);
		
	}
	
	
	
	public void appleShiver() {
		appleSizeCounter++;
		if (appleSizeCounter%8==0) {
			appleSize +=sizeStep;
		}
		if (appleSizeCounter%12 == 0) {
			appleShineSize+=sizeStep;
		}
		if (appleSizeCounter%32==0) {
			sizeStep*=-1;
		}
	}

}

