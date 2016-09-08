package edu.jsu.mcis;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	private char [][] board = new char [3][3];
	private char player = 'O';
	private String winner = " ";
	private boolean ongoingGame = false;
	
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
