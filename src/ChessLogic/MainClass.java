package ChessLogic;

import java.util.Arrays;



public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] board = Board.startNewGame();
		
		ValueCalculator.init();

		int valueWhite = ValueCalculator.getValueWhite(board);
		int valueBlack = ValueCalculator.getValueBlack(board);
		Status status = new Status(null, valueWhite, valueBlack);
		System.out.println(status);
		for(int i=0;i<45;i++) {
			status = Engine.move(board,5,Board.BLACK,status);
			if(status.move==null) {
				System.out.println("buuu "+status);
				break;
				
			}
			System.out.println("BLACK: "+status);
			Board.move(board,status.move);
			
			Printer.printBaord(board);
			status = Engine.move(board,5,Board.WHITE,status);
			if(status.move==null) break;
			Board.move(board,status.move);
			Printer.printBaord(board);
			System.out.println("WHITE "+status);
			System.out.println("----------");
		}

	
		

	}

}
