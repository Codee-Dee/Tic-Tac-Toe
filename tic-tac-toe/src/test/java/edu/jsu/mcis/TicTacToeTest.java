package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	private TicTacToe ttt;
	
	@Before
	public void setup () {
		ttt = new TicTacToe();
		ttt.setNewBoard();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		assertTrue(ttt.setNewBoard());
	}
	@Test
	public void testThatBoardIsDisplayed(){
		assertTrue(ttt.displayBoard());
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		ttt.setPlayer();
		ttt.setMove(0,2);
		assertEquals("X",ttt.getMove(0,2));	
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		ttt.setMove(2,0);
		assertEquals("O",ttt.getMove(2,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		ttt.setMove(2,0);
		ttt.setMove(2,0);
		assertTrue(ttt.checkForValidMove(2,0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		ttt.setMove(2,0);
		assertTrue(ttt.ongoingGame());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		ttt.setPlayer();
		ttt.setMove(0,0);
		ttt.setMove(0,1);
		ttt.setMove(0,2);
		ttt.checkForHorizontalWin();
		assertEquals(ttt.getWinner(),"X");
	}
	
	@Test
	public void testThatGameIsWonDiagonally(){
		ttt.setPlayer();
		ttt.setMove(0,0);
		ttt.setMove(1,1);
		ttt.setMove(2,2);
		ttt.checkForDiagonalWin();
		assertEquals(ttt.getWinner(),"X");
	}
	@Test
	public void testThatGameIsWonDiagonally2(){
		ttt.setPlayer();
		ttt.setMove(0,2);
		ttt.setMove(1,1);
		ttt.setMove(2,0);
		ttt.checkForDiagonalWin();
		assertEquals(ttt.getWinner(),"X");
		
	}
	
	@Test
	public void testThatGameIsWonVertically(){
		ttt.setPlayer();
		ttt.setMove(0,0);
		ttt.setMove(1,0);
		ttt.setMove(2,0);
		ttt.checkForVerticalWin();
		assertEquals(ttt.getWinner(),"X");
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		ttt.setPlayer();
		ttt.setMove(0,0);
		ttt.setPlayer();
		ttt.setMove(0,1);
		ttt.setPlayer();
		ttt.setMove(0,2);
		ttt.setPlayer();
		ttt.setMove(2,0);
		ttt.setPlayer();
		ttt.setMove(2,1);
		ttt.setPlayer();
		ttt.setMove(2,2);
		ttt.setPlayer();
		ttt.setMove(1,0);
		ttt.setPlayer();
		ttt.setMove(1,1);
		ttt.setPlayer();
		ttt.setMove(1,2);
		ttt.checkForTie();
		assertEquals(ttt.getWinner(), "TIE");
	}
}
