package edu.jsu.mcis;
public class TicTacToeMain{
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		int turns = 0;
		t.setNewBoard();
		t.ongoingGame();
		
		while (t.ongoingGame == true && turns != 9){
			t.setPlayer();
			t.askPlayer(t.player);
			t.displayBoard();
			turns++;
			t.checkForVerticalWin();
			t.checkForHorizontalWin();
			t.checkForDiagonalWin();
			if (turns == 9 && t.ongoingGame == true){
				t.checkForTie();
				t.displayBoard();
			}
			if (t.ongoingGame == false){
				t.displayBoard();
				t.getWinner();
			}
		}
	}
}