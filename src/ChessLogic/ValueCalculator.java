package ChessLogic;

import java.util.HashMap;



public class ValueCalculator {
	
	//
	//	public static final int PAWN_WHITE = 1;
	//	ROOK_WHITE = 2;
	//	KNIGHT_WHITE = 3;
	//	BISHOP_WHITE = 4;
	//	QUEEN_WHITE= 5;
	//	KING_WHITE = 6;
	//		
	//	PAWN_BLACK = 7;
	//	ROOK_BLACK = 8;
	//	KNIGHT_BLACK = 9;
	//	BISHOP_BLACK = 10;
	//	QUEEN_BLACK = 11;
	//	KING_BLACK = 12;
	//
	public static final int[] pieces = new int[13];
	

	public static void init() {
		pieces[1] = 1;  //PAWN_WHITE = 1;
		pieces[2] = 5;  //ROOK_WHITE = 2;
		pieces[3] = 3;  //KNIGHT_WHITE = 3;
		pieces[4] = 3;    //BISHOP_WHITE = 4;
		pieces[5] = 9;   //QUEEN_WHITE= 5;
		pieces[6] = 1000; //KING_WHITE = 6;
		pieces[7] = 1;    //PAWN_BLACK = 7;
		pieces[8] = 5;   //ROOK_BLACK = 8;
		pieces[9] = 3;  //KNIGHT_BLACK = 9;
		pieces[10] = 3;  //BISHOP_BLACK = 10;
		pieces[11] = 9;   //QUEEN_BLACK = 11;
		pieces[12] = 1000; //KING_BLACK = 12;
		
		
	}
	
	public static int getValueWhite(int[][] board) {
		int value = 0;
		for(int[] spalte : board) {
			for(int i:spalte) {
				if(i<=6) {
					value +=pieces[i];
				}
			}
		}
		return value;
	}
	
	public static void updateStatusForMove(int[][] board, Move move, Status status) {
		status.move= move;
		if(Board.isBlack(board[move.toX][move.toY])) {
			int value = ValueCalculator.pieces[board[move.toX][move.toY]];
			
			status.subFrom(Board.BLACK, value);
		}
		if(Board.isWhite(board[move.toX][move.toY])) {
			int value = ValueCalculator.pieces[board[move.toX][move.toY]];
			status.subFrom(Board.WHITE, value);
		}
	}
	
	public static int getValueBlack(int[][] board) {
		int value = 0;
		for(int[] spalte : board) {
			for(int i:spalte) {
				if(i>6) {
					value +=pieces[i];
				}
			}
		}
		
		return value;
	}
	
	public static int getScoreWhite(int board[][]) {
		int valueWhite = 0;
		int valueBlack = 0;
		for(int[] spalte : board) {
			for(int i:spalte) {
				if(i<=6) {
					valueWhite +=pieces[i];
				}
				else {
					valueBlack +=pieces[i];
				}
			}
		}	
		return valueWhite-valueBlack;
	}
	
	public static int getScoreBlack(int board[][]) {
		int valueWhite = 0;
		int valueBlack = 0;
		for(int[] spalte : board) {
			for(int i:spalte) {
				if(i<=6) {
					valueWhite +=pieces[i];
				}
				else {
					valueBlack +=pieces[i];
				}
			}
		}	
		return valueBlack-valueWhite;
	}
	

}
