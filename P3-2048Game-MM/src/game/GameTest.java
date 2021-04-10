package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGridCreation() {
	
		//Only works with a 4x4 grid
		Board gameBoard = new Board(4);
		assertTrue(gameBoard.board.length==4);
		assertTrue(gameBoard.board[0].length==4);
		assertTrue(gameBoard.board[1].length==4);
		assertTrue(gameBoard.board[2].length==4);
		assertTrue(gameBoard.board[3].length==4);
		

	}
	
	@Test
	public void testNodeCreation() {
		//Crear nodo constructor defecto
		Node node = new Node();
		assertTrue(node.value==0);
		
		//Crear nodo constructor con valor
		Node nodeWithValue = new Node(2);
		assertTrue(nodeWithValue.value==2);
	}
	

}
