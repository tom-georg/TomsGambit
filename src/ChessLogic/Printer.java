package ChessLogic;

public class Printer {
	
	//	public static final int PAWN_WHITE = 1;
	//	public static final int ROOK_WHITE = 2;
	//	public static final int KNIGHT_WHITE = 3;
	//	public static final int BISHOP_WHITE = 4;
	//	public static final int QUEEN_WHITE= 5;
	//	public static final int KING_WHITE = 6;
//	public static final int PAWN_BLACK = 7;
//	public static final int ROOK_BLACK = 8;
//	public static final int KNIGHT_BLACK = 9;
//	public static final int BISHOP_BLACK = 10;
//	public static final int QUEEN_BLACK = 11;
//	public static final int KING_BLACK = 12; 
	
	private final static char[] pieces = {'_','♙','♖','♘','♗','♕','♔','♟','♜','♞','♝','♛','♚'};
	
	public static void printBaord(int[][] board) {
		String output="";
		for (int y = 0;y<board.length;y++) {
			for (int x = 0;x<board.length;x++) {
				output += pieces[board[x][y]] + " ";
			}
			output+="\n";
		}
		System.out.println(output);
	}
}
