package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
//import to 'hear' the keys entered by the player
import java.awt.event.KeyListener;
//import for screen rendering
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener {

	 //We create a board where the game is going to be played
	static Board gameBoard = new Board(4);
	//We create a game itself
	static Gameplay game = new Gameplay();
	//To render in the UI, we need the board in a string format
	String gameRender = gameBoard.toString();
	//We need a frame where we are going to add the content
	static JFrame frame = new JFrame();

	public static void startGame()
	{
		//The game will start and it will be waiting for the user to start using the keyboard
		frame.addKeyListener(game);
		//With this line we add an object (in this case our gameto the JPanel contained by the JFrame)
		frame.add(game);
		//This parameter is used to set an initial size of the window
		frame.setSize( 600, 400 );
		//I don't know why but you need to set this parameter so the window is visible
		frame.setVisible( true );

		//gameBoard = new Board(4);
		gameBoard.addRandomNode();
		gameBoard.addRandomNode();
		frame.repaint();
	}

	@Override
	public void keyPressed( KeyEvent key )
	{
		//The key UP was pressed
		if (key.getKeyCode() == KeyEvent.VK_UP)
		{
			//makes the movement
			gameBoard.moveUp();
			//add a random node to the board
			gameBoard.addRandomNode();
			//saves in the game render a string version of the current status of the board
			gameRender = gameBoard.toString();
			//refresh the frame in the screen to reflect the changes
			frame.repaint();
		}
		//The key DOWN was pressed
		else if (key.getKeyCode() == KeyEvent.VK_DOWN)
		{
			//makes the movement
			gameBoard.moveDown();
			//add a random node to the board
			gameBoard.addRandomNode();
			//saves in the game render a string version of the current status of the board
			gameRender = gameBoard.toString();
			//refresh the frame in the screen to reflect the changes
			frame.repaint();
		}
		//The key LEFT was pressed
		else if (key.getKeyCode() == KeyEvent.VK_LEFT)
		{
			//makes the movement
			gameBoard.moveLeft();
			//add a random node to the board
			gameBoard.addRandomNode();
			//saves in the game render a string version of the current status of the board
			gameRender = gameBoard.toString();
			//refresh the frame in the screen to reflect the changes
			frame.repaint();
		}
		//The key RIGHT was pressed
		else if (key.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			//makes the movement
			gameBoard.moveRight();
			//add a random node to the board
			gameBoard.addRandomNode();
			//saves in the game render a string version of the current status of the board
			gameRender = gameBoard.toString();
			//refresh the frame in the screen to reflect the changes
			frame.repaint();
		}

		//TO DO
		/*
		 * else if ( e.getKeyCode() == KeyEvent.VK_ENTER ) { game = new Board();
		 * game.spawn(); game.spawn(); frame.repaint(); }
		 */
	}
	
	public void paint( Graphics graphic )
    {
		//Here we call the 'paint' mehtod of JPanel
        super.paint(graphic);
        
        //with this line we create a variable using a subclass of graphics used for
        //Graphics2D g2 = (Graphics2D)graphic;
        
        graphic.drawString( "Bienvenido al juego 2048", 250, 20 );
       
        graphic.drawString( "Use las flechas de su teclado para comenzar a jugar", 180, 335 );
        
        //  https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#fillRect(int,%20int,%20int,%20int)
        graphic.setColor( Color.gray );
        
        graphic.fillRect( 140, 50, 250, 250 );
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                renderNode( graphic, gameBoard.board[i][j], j * 60 + 150, i * 60 + 60 );
            }
        }
        if ( gameBoard.nextMoveCapacity() )
        {
        	graphic.drawString("GAME OVER", 260, 260);
        	
        }
    }
	
	 public void renderNode( Graphics graphic, Node node, int x, int y )
	    {
	        int nodeValue = node.getNodeValue();
	        int length = String.valueOf(nodeValue).length();
	        
	        graphic.setColor( Color.black );
	        graphic.drawString( "" + nodeValue, x + 25 - 3 * length, y + 25 );
	    }


	public static void main( String[] args )
	{
		startGame();
	}


	//This overrides are generated and requested when we implement the KeyListener, we only use and override keyPressed
	@Override
	public void keyTyped(KeyEvent e) {
		// Not used
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// Not used
	}

}
