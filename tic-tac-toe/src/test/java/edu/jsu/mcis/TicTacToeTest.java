package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;

public class TicTacToeTest {
	
	private TicTacToe ttt;
	
	@Before
	public void setup () {
		ttt = new TicTacToe();
		ttt.setNewBoard();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals(" ", ttt.getMove(i, j));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		ttt.setMove(0,2);
		assertEquals("X",ttt.getMove(0,2));	
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		ttt.setMove(0,2);
		ttt.setMove(2,0);
		assertEquals("O",ttt.getMove(2,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		ttt.setMove(2,0);
		ttt.setMove(2,0);
		assertEquals("X", ttt.getMove(2,0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		ttt.setMove(2,0);
		assertEquals(" ", ttt.getWinner());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		ttt.setMove(0,0);
		ttt.setMove(1,0);
		ttt.setMove(0,1);
		ttt.setMove(1,1);
		ttt.setMove(0,2);
		assertEquals("X", ttt.getWinner());
	}
	
	@Test
	public void testThatGameIsWonDiagonally(){
		ttt.setMove(0,0);
		ttt.setMove(0,2);
		ttt.setMove(1,1);
		ttt.setMove(0,1);
		ttt.setMove(2,2);
		assertEquals("X", ttt.getWinner());
	}
	@Test
	public void testThatGameIsWonDiagonally2(){
		ttt.setMove(0,2);
		ttt.setMove(0,0);
		ttt.setMove(1,1);
		ttt.setMove(0,1);
		ttt.setMove(2,0);
		assertEquals("X", ttt.getWinner());
		
	}
	
	@Test
	public void testThatGameIsWonVertically(){
		ttt.setMove(0,0);
		ttt.setMove(0,1);
		ttt.setMove(1,0);
		ttt.setMove(0,2);
		ttt.setMove(2,0);
		assertEquals("X", ttt.getWinner());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		ttt.setMove(0,0);
		ttt.setMove(0,1);
		ttt.setMove(0,2);
		ttt.setMove(2,0);
		ttt.setMove(2,1);
		ttt.setMove(2,2);
		ttt.setMove(1,0);
		ttt.setMove(1,1);
		ttt.setMove(1,2);
		assertEquals("TIE", ttt.getWinner());
	}
}
