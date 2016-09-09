
import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeVC t;
	
	public void startNewGame() {
		t = new TicTacToeVC();
	}
	
	public void markLocation(int row, int column) {
		t.model.setMove(row,column);
	}
	
	public String getMark(int row, int column) {
		return t.model.getMove(row,column);
	}
    
	public String getWinner() {
		return t.model.getWinner();
	}
}
