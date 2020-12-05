package ChessLogic;

import java.util.HashMap;

public class Board {

	
	public static final int PAWN_WHITE = 1;
	public static final int ROOK_WHITE = 2;
	public static final int KNIGHT_WHITE = 3;
	public static final int BISHOP_WHITE = 4;
	public static final int QUEEN_WHITE= 5;
	public static final int KING_WHITE = 6;
	
	public static final int PAWN_BLACK = 7;
	public static final int ROOK_BLACK = 8;
	public static final int KNIGHT_BLACK = 9;
	public static final int BISHOP_BLACK = 10;
	public static final int QUEEN_BLACK = 11;
	public static final int KING_BLACK = 12; 
	
	public static final boolean BLACK = false;
	public static final boolean WHITE = true;
			
	
	public Board() {
		
	}
	
	public final static int[][] startNewGame() {
		
		return reset();
	}
	
	public static boolean isWhite(int figure) {
		if(figure<0||figure>12) {
			throw new IllegalArgumentException("Invalid figure");
		}
		return (figure>0&&figure<=6);
	}
	
	public static boolean isBlack(int figure) {
		if(figure<0||figure>12) {
			throw new IllegalArgumentException("Invalid figure");
		}
		return (figure>6);
	}
	

	
	private static int[][] reset() {
		int[][] board = new int[8][8];
		board[0][0] = ROOK_BLACK;
		board[1][0] = KNIGHT_BLACK;
		board[2][0] = BISHOP_BLACK;
		board[3][0] = QUEEN_BLACK;
		board[4][0] = KING_BLACK;
		board[5][0] = BISHOP_BLACK;
		board[6][0] = KNIGHT_BLACK;
		board[7][0] = ROOK_BLACK;
		for(int i=0;i<8;i++) {
			board[i][1] = PAWN_BLACK;
		}
		
		board[0][board.length-1] = ROOK_WHITE;
		board[0][board.length-1] = ROOK_WHITE;
		board[1][board.length-1] = KNIGHT_WHITE;
		board[2][board.length-1] = BISHOP_WHITE;
		board[3][board.length-1] = QUEEN_WHITE;
		board[4][board.length-1] = KING_WHITE;
		board[5][board.length-1] = BISHOP_WHITE;
		board[6][board.length-1] = KNIGHT_WHITE;
		board[7][board.length-1] = ROOK_WHITE;
		for(int i=0;i<8;i++) {
			board[i][board.length-2] = PAWN_WHITE;
		}
		return board;
	}
	


	
	public static void move(int[][] board, Move move) {
		board[move.toX][move.toY] = board[move.fromX][move.fromY];
		board[move.fromX][move.fromY] = 0;
	}
	
	public static void move(int[][] board, Move move,Status status) {
		
		status.move= move;
		if(isBlack(board[move.toX][move.toY])) {
			int value = ValueCalculator.pieces[board[move.toX][move.toY]];
			
			status.subFrom(BLACK, value);
		}
		if(isWhite(board[move.toX][move.toY])) {
			int value = ValueCalculator.pieces[board[move.toX][move.toY]];
			status.subFrom(WHITE, value);
		}
		
		board[move.toX][move.toY] = board[move.fromX][move.fromY];
		board[move.fromX][move.fromY] = 0;
	}
	
	public static boolean isSameTeam(final int[][] board,final int x, final int y, final boolean color ) {
		if(board[x][y]==0) return false;
		if(isWhite(board[x][y])&&color ==WHITE) {
			return true;
		}
		if(isBlack(board[x][y])&&color==BLACK) {
			return true;
		}
		return false;
	}
	
}
