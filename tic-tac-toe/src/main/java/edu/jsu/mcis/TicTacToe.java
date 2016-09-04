package edu.jsu.mcis;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	private char [][] board = new char [3][3];
	public char player = 'O';
	private String winner = " ";
	public boolean ongoingGame = false;
	
	public  boolean setNewBoard(){
        boolean newBoard = false;
        for (int row = 0; row < board.length;row++){
            Arrays.fill(board[row], ' ');
            
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][2] == ' '){
                newBoard = true;
            }
            else{ 
                newBoard = false;
            }
        }
        return newBoard;
    }
	public boolean displayBoard(){
		boolean boardDisplayed = false;
		for (int row =0; row < board.length; row++){
			for (int column = 0; column< board[0].length; column++){
				System.out.print("\t" + board[row][column]);
				if (column == 0){
					System.out.print("|");
				}
				
				else if (column == 1){
					System.out.print("\t" + "|");
				}
				
				else {
					boardDisplayed = true;
					break;
				}
			}
			if (row == 0 || row == 1){
				System.out.print("\n------------------------------------------\n");
				boardDisplayed = true;
			}
		}
		System.out.println();
		return boardDisplayed;
	}
	public void askPlayer(char player){
		Scanner keyboard = new Scanner(System.in);
		int row, column;
		do{
			System.out.printf("Player %s Please enter a row (0-2): ", player);
			row = keyboard.nextInt();
			
			System.out.printf("Please %s enter a column (0-2): ", player);
			column = keyboard.nextInt();
		}
		while(checkForValidMove(row,column));
			System.out.println("\n");
			setMove(row,column);
	}
	
		
	public char setPlayer(){
		if (player == 'O'){
			player = 'X';
		}
		else 
			player = 'O';
		return player;
	}
	public boolean ongoingGame(){
		ongoingGame = true;
		return ongoingGame;
	}
	
	public void setMove(int row, int column){
		if (row >= 0 && row <= 2 && column >= 0 && column <= 2){
			if (board[row][column] == ' '){
				board[row][column] = player;
			}
		}
	}
	
	public String getMove(int row, int column){
		String move = Character.toString(board[row][column]);
        return move;
	}
	
	public boolean checkForValidMove(int row, int column){
		boolean valid = false;

		if (row < 0 || row > 2 && column < 0 || column > 2 || board[row][column] !=' '){
			valid = true;
			return valid;
		}
		return valid;
	}
	
	public void checkForHorizontalWin(){
		for (int i = 0; i < board.length; i++){
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){
				winner = Character.toString(player);
				ongoingGame = false;
			}
		}
	}
	
	public void checkForVerticalWin(){
		for (int i = 0; i < board.length; i++){
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != ' '){
				winner = Character.toString(player);
				ongoingGame = false;
			}
		}
	}
	
	public  void checkForDiagonalWin(){
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0]!= ' '){
			winner = Character.toString(player);
			ongoingGame = false;
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '){
			winner = Character.toString(player);
			ongoingGame = false;
		}
	}
	
	public void checkForTie(){
		int count = 0;
		for (int row = 0; row < board.length;row++){
			if (board[row][0]!= ' ' && board[row][1] != ' ' && board[row][2] != ' '){
				count++;
				if (count == 3){
				winner = "TIE";
				ongoingGame = false;
				}
			}
		}
	}
	
	public String getWinner(){
		return winner;
	}
	
}
