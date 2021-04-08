package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		
		//Crear nodo constructor defecto
		Node node = new Node();
		assertTrue(node.value==0);
		
		//Crear nodo constructor con valor
		Node nodeWithValue = new Node(2);
		assertTrue(nodeWithValue.value==2);
	}

}
