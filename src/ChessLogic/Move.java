package ChessLogic;

public class Move {
	
	public int fromX;
	public int fromY;
	
	public int toX;
	public int toY;
	public Move(int fromX, int fromY, int toX, int toY) {
		super();
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}
	
	public Move copy() {
		Move nMove = new Move(fromX, fromY, toX, toY);
		return nMove;
	}


	@Override
	public String toString() {
		return "Move [fromX=" + fromX + ", fromY=" + fromY + ", toX=" + toX + ", toY=" + toY + "]";
	}
	
}