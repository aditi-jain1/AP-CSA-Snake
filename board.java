package Snake;

public class board {
	private int x;
	private int y;
	private int movementDirection;
	private boolean didTurn = false;
	public board(int xCoord, int yCoord, int direction) {
		x = xCoord;
		y = yCoord;
		movementDirection = direction;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setDidTurn(boolean x) {
		didTurn = x;
	}
	
	public boolean getDidTurn() {
		return didTurn;
	}
	public void setDirection(int direction) {
		movementDirection = direction;
	}
	
	public int getDirection() {
		return movementDirection;
	}

}
