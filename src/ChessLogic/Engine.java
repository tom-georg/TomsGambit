package ChessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Engine {

	
	
	public static Status move(int[][] board, int debth, final boolean COLOR, Status status) {
	//	System.out.println("Color   "+COLOR);
		if(debth==0) {
			return status;
		}
		
		ArrayList<int[]> pieces = new ArrayList<int[]>();
		pieces = getPieces(board, COLOR);
		
		int score = -100000;

		ArrayList<Move> moves = new ArrayList<Move>();
		for (int[] piece : pieces) {
			ArrayList<int[]> possiblePieceMoves= MoveValidator.getMoves(board, piece[0], piece[1]);

			for (int[] destination : possiblePieceMoves) {

				Move nMove = new Move(piece[0], piece[1],destination[0],destination[1]);

				int[][] tBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
				Status tStatus = status.copy();
				Board.move(tBoard, nMove,tStatus);

				Status nStatus = move(tBoard, debth-1, !COLOR, tStatus);

				if(nStatus.getScore(COLOR)>score) {
				//	System.out.println(" Score! "+Board.pieces[board[piece[0]][piece[1]]]+"-"+nMove);
					score = nStatus.getScore(COLOR);
					moves.clear();
				}
				if(nStatus.getScore(COLOR)>=score) {

					moves.add(nMove);
				}
			//	System.out.println(moves);

			}

			
		}
		if(debth==4){
			System.out.println(moves);
		}
		Move move = null;
		if(moves.size()>0) {
			move = moves.get(new Random().nextInt(moves.size()));
			ValueCalculator.updateStatusForMove(board, move, status);
		}
		status.move = move;
		
		return status;
		
	}
	
	public static ArrayList<int[]> getPieces(int[][] board, final boolean COLOR){
		ArrayList<int[]> pieces = new ArrayList<int[]>();
		for(int x = 0; x < board.length;x++) {
			for(int y = 0;y<board[0].length;y++) {
				if(COLOR == Board.WHITE&&board[x][y] >0 && board[x][y]<=6) {
					pieces.add(new int[]{x,y});
				}
				if(COLOR == Board.BLACK&&board[x][y] >0 && board[x][y]>6) {
					pieces.add(new int[]{x,y});
				}
			}
		}
		return pieces;
	}
}




