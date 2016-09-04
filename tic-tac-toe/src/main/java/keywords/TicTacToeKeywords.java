
import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToe t = new TicTacToe();
	
	public void startNewGame() {
		t.setNewBoard();
	}
	
	public void markLocation(int row, int column) {
		t.setPlayer();
		t.setMove(row,column);
	}
	
	public String getMark(int row, int column) {
		return t.getMove(row,column);
	}
    
	public String getWinner() {
		t.checkForTie();
		t.checkForVerticalWin();
		t.checkForHorizontalWin();
		t.checkForDiagonalWin();

		return t.getWinner();
	}
}
