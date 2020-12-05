package ChessLogic;

import java.util.ArrayList;
import java.util.HashMap;

public class MoveValidator {
	private static HashMap<Integer, Runnable> pieces = new HashMap<>();
	

	/**
	 * Returns a list of possible moves.
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	public static ArrayList<int[]> getMoves(int[][] board, int x, int y){
		ArrayList<int[]> moves= new ArrayList<>();
		switch (board[x][y]) {
		case Board.PAWN_BLACK:
			moves = getPawnMoves(board, x, y);
			return moves;
		case Board.ROOK_BLACK:
			moves = getRookMoves(board,x,y);
			return moves;
		case Board.KNIGHT_BLACK:
			moves = getKightMoves(board,x,y);
			return moves;
		case Board.BISHOP_BLACK:
			moves = getBishopMoves(board, x, y);
			return moves;
		case Board.QUEEN_BLACK:
			moves.addAll(getRookMoves(board,x,y));
			moves.addAll(getBishopMoves(board, x, y));
			return moves;
		case Board.KING_BLACK:
			moves = new ArrayList<>();
			return moves;		
		case Board.PAWN_WHITE:
			moves = getPawnMoves(board, x, y);
			return moves;
		case Board.ROOK_WHITE:
			moves = getRookMoves(board, x, y);
			return moves;
		case Board.QUEEN_WHITE:
			moves.addAll(getRookMoves(board,x,y));
			moves.addAll(getBishopMoves(board, x, y));
			return moves;
		case Board.BISHOP_WHITE:
			moves.addAll(getRookMoves(board,x,y));
			moves.addAll(getBishopMoves(board, x, y));
			return moves;
		case Board.KNIGHT_WHITE:
			moves = getKightMoves(board,x,y);
			return moves;
		
		default:
			return new ArrayList<>();
		}
		
	}


	
	private static ArrayList<int[]> getKightMoves(int[][] board, int x, int y) {
		ArrayList<int[]> list = new ArrayList<>(10);
		 boolean color = false;;
		if(Board.isWhite(board[x][y])) {
			color = Board.WHITE;
		}
		if(x-1>=0&&y-2>=0
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x-1,y-2});
		}
			
		if(x+1<board.length&&y-2>=0
				&&Board.isSameTeam(board, x, y, color)==false) {
			 list.add(new int[] {x+1,y-2});
		}
		
		if(x-1>=0&&y+2>=0
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x-1,y+2});
		}
		if(x+1<board.length&&y+2<board.length
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x+1,y+2});
		}
		
		if(x-2>=0&&y-1>=0
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x-2,y-1});
		}
		if(x-2>=0&&y+1<board.length
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x-2,y+1});
		}
		
		if(x+2<board.length&&y-1>=0
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x+2,y-1});
		}
		if(x+2<board.length&&y+1<board.length
				&&Board.isSameTeam(board, x, y, color)==false) {
			list.add(new int[] {x+2,y+1});
		}
	
		
		return list;
	}



	private static ArrayList<int[]> getRookMoves(int[][] board, int x, int y) {
		ArrayList<int[]> list = new ArrayList<int[]>(20);
		 boolean color = false;;
		if(Board.isWhite(board[x][y])) {
			color = Board.WHITE;
		}
		// Rechts vom Turm
		int tx = x+1;
		while(tx<board.length-1&&board[tx][y]==0) {
			list.add(new int[] {tx,y});
			tx++;
		}
		if(tx<board.length&&Board.isSameTeam(board, tx, y, color)==false) {
			list.add(new int[] {tx,y});
		}
		//Links vom Turm
		tx = x-1;
		while(tx>=0&&board[tx][y]==0) {
			list.add(new int[] {tx,y});
			tx--;
		}
		if(tx>=0&&Board.isSameTeam(board, tx, y, color)==false) {
			list.add(new int[] {tx,y});
		}
		//Unterhalb vom Turm
		int ty = y+1;
		while(ty<board.length&&board[x][ty]==0) {
			list.add(new int[] {x,ty});
			ty++;
		}
		if(ty<board.length&&Board.isSameTeam(board, x, ty, color)==false) {
			list.add(new int[] {x,ty});
		}
		
		//Oberhalb vom Turm
		ty = y-1;
		while(ty>=0&&board[x][ty]==0) {
			list.add(new int[] {x,ty});
			ty--;
		}
		if(ty>=0&&Board.isSameTeam(board, x, ty, color)==false) {
			list.add(new int[] {x,ty});
		}
		return list;
	}
	
	private static ArrayList<int[]> getBishopMoves(int[][] board, int x, int y) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		 boolean color = false;;
		if(Board.isWhite(board[x][y])) {
			color = Board.WHITE;
		}
		// Rechts unten von Bishop
		int tx = x+1;
		int ty = y+1;
		while(tx<board.length-1&&ty<board.length&&board[tx][ty]==0) {
			list.add(new int[] {tx,ty});
			tx++;
			ty++;
		}
		if(tx<board.length&&ty<board.length&&Board.isSameTeam(board, tx, ty, color)==false) {
			list.add(new int[] {tx,ty});
		}
		
		//Links unten von Bishop
		tx = x-1;
		ty = y+1;
		while(tx>=0&&ty<board.length&&board[tx][ty]==0) {
			list.add(new int[] {tx,ty});
			tx--;
			ty++;
		}
		if(tx>=0&&ty<board.length&&Board.isSameTeam(board, tx, ty, color)==false) {
			list.add(new int[] {tx,ty});
		}
		
		//Links oben von Bishop
		tx = x-1;
		ty = y-1;
		while(tx>=0&&ty>0&&board[tx][ty]==0) {
			list.add(new int[] {tx,ty});
			tx--;
			ty--;
		}
		if(tx>=0&&ty>=0&&Board.isSameTeam(board, tx, ty, color)==false) {
			list.add(new int[] {tx,ty});
		}
		//Rechts oben von Bishop
		tx = x+1;
		ty = y-1;
		while(tx<board.length&&ty>0&&board[tx][ty]==0) {
			list.add(new int[] {tx,ty});
			tx++;
			ty--;
		}
		if(tx<board.length&&ty>=0&&Board.isSameTeam(board, tx, ty, color)==false) {
			list.add(new int[] {tx,ty});
		}
		return list;
	}



	/**
	 * 
	 * @param board
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private static boolean canMoveHere(int[][] board, int x, int y, boolean isWhite) {
		if(board[x][y]==0) {
			return true;
		}
		if(isWhite&& Board.isBlack(board[x][y])) {
			return true;
		}
		if(isWhite==false&&Board.isWhite(board[x][y])) {
			return true;
		}
		else {
			return false;
		}
	}
	

	private static ArrayList<int[]> getPawnMoves(int[][] board, int x, int y) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		if(Board.isBlack(board[x][y])) {
			if(y==board.length-1) {
				return moves;
			}
			//eins nach vorne
			if(board[x][y+1]==0) {
				
				moves.add(new int[] {x,y+1});
			}
			//diagonal
			if(x<board.length-1 &&canMoveHere(board, x+1, y+1, false)
					&&Board.isWhite(board[x+1][y+1])) {
				moves.add(new int[] {x+1,y+1});
			}
			//diagonal
			if(x>0 &&canMoveHere(board, x-1, y+1, false)
					&&Board.isWhite(board[x-1][y+1])) {
				moves.add(new int[] {x-1,y+1});
			}
			if(y==1&&board[x][y+2]==0) {
				 moves.add(new int[]{x,y+2});
			}
			return moves;
		}
		if(Board.isWhite(board[x][y])) {
			if(y==0) {
				return moves;
			}
			//eins nach vorne
			if(board[x][y-1]==0) {
				moves.add(new int[] {x,y-1});
			}
			//diagonal
			if(x>0&&canMoveHere(board, x-1, y-1, true)
				&&Board.isBlack(board[x-1][y-1])) {
				moves.add(new int[] {x-1,y-1});
			}
			//diagonal
			if(x<board.length-1 &&canMoveHere(board, x+1, y-1, true)
					&&Board.isBlack(board[x+1][y-1])) {
				moves.add(new int[] {x+1,y-1});
			}
			if(y==board.length-2&&board[x][y-2]==0) {
				 moves.add(new int[]{x,y-2});
			}
		} 
			
		
		
		return moves;
	}

	

	
	
}
