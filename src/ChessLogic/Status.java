package ChessLogic;

public class Status {
	
	Move move;
	
	private int valueWhite;
	private int valueBlack;
	
	
	
	public Status(Move move, int valueWhite, int valueBlack) {
		super();
		this.move = move;
		this.valueWhite = valueWhite;
		this.valueBlack = valueBlack;
	}

	public int getValue(final boolean COLOR) {
		if(COLOR == Board.WHITE) {
			return valueWhite;
		}
		if(COLOR == Board.BLACK) {
			return valueBlack;
		}
		return -1; 
	}
	
	public int getScore(final boolean COLOR) {
		if(COLOR == Board.WHITE) {
			return valueWhite-valueBlack;
		}
		if(COLOR == Board.BLACK) {
			return valueBlack-valueWhite;
		}
		return -1; 
	}
	
	public int setValue(final boolean COLOR, int value) {
		if(COLOR == Board.WHITE) {
		 valueWhite = value;
		}
		if(COLOR == Board.BLACK) {
		 valueBlack = value;
		}
		return -1;
	}
	
	public void subFrom(final boolean COLOR, int points) {
		if(COLOR == Board.WHITE) {
			 valueWhite -= points;
			}
			if(COLOR == Board.BLACK) {
			 valueBlack -= points;
			}
	}


	public Status copy() {
		Move tMove = null;
		
		Status nStatus = new Status(tMove, valueWhite, valueBlack);
		return nStatus;
	}

	@Override
	public String toString() {
		return "Status [move=" + move + ", valueWhite=" + valueWhite + ", valueBlack=" + valueBlack + "]";
	}
	
	
}
