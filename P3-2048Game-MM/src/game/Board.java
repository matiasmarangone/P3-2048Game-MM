package game;

public class Board {
	
	//-----------Board properties---------------------
	
	//A board is made of Nodes in a 2D Array
	public Node[][] board;
	//Used to iterate the array, we need to know the size of the grid
	int grid;
	//Global variable used in the movement methods 
	int boardLimit;
	
	//Default constructor method. We create a node with initial value of 0
	public Board(int gridSize)
    {
		//Set the gridsize
        this.grid = gridSize;
        //Create a board made of nodes and using the grid size
        board = new Node[this.grid][this.grid];
        //Iterate the board rows
        for ( int i = 0; i < board.length; i++ )
        {
        	//Iterate the board columns
            for ( int j = 0; j < board[i].length; j++ )
            {
            	//Create the node (the default constructor will create it with value of 0
                board[i][j] = new Node();
            }
        }
    }

	//-----------Get methods---------------------
	
	//Returns the array containing all the nodes of the board
	public Node[][] getBoard()
	{
		return board;
	}
	
	//Returns the highest value of all the nodes in the board
	public int getHighestNode()
	{
	        int highValue = board[0][0].getNodeValue();
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                if ( board[i][j].getNodeValue() > highValue )
	                {
	                	highValue = board[i][j].getNodeValue();
	                }
	            }
	        }
	        return highValue;
	}

	//Similar to Node to string, we need the board in a string format for UI rendering
	public String toString()
	{
		 String s = "";
		 for ( int i = 0; i < board.length; i++ )
		 {
			 for ( int j = 0; j < board[i].length; j++ )
			 {
				 s += board[i][j].toString() + " ";
			 }
			 s += "\n";
		 }
		 return s;
	}

	//Add a node in a random empty position of the board
    public void addRandomNode()
    {
    	//variable to iterate
        boolean isNodeEmpty = true;
        while ( isNodeEmpty )
        {
        	//we receive a random number for row and column
            int row = (int)(Math.random() * 4);
            int column = (int)(Math.random() * 4);
            
            //This random will help us determine if we place a node with value 2 or 4
            double randomNumber = Math.random();
            
            //If we find a node that is empty
            if ( board[row][column].getNodeValue() == 0 )
            {
            	//based on the random number value we put a 4 or a 2 
                if ( randomNumber < 0.2 )
                {
                    board[row][column] = new Node(4);
                    isNodeEmpty = false;
                }
                else
                {
                    board[row][column] = new Node(2);
                    isNodeEmpty = false;
                }
            }

        }

    }
    
    //Check in the board if it's possible to make a next move with current values
    public boolean nextMoveCapacity()
    {	
    	
        int nodesWithoutMoves = 0;
        
        //iterate rows
        for ( int row = 0; row < board.length; row++ )
        {
        	//iterate columns
            for ( int column = 0; column < board[row].length; column++ )
            {
            	
            	//check if the element I'm in has value
                if ( board[row][column].getNodeValue() > 0 )
                {
                	//this is only used on the first element of the board, "top left corner"
                    if ( row == 0 && column == 0 )
                    {
                    	//if element on the right and below don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row + 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column + 1].getNodeValue() )
                        {
                        	//add one to the counter
                        	nodesWithoutMoves++;
                        }
                    }
                    //this is only used on the last element of the first row, "top right corner"
                    else if ( row == 0 && column == 3 )
                    {
                    	//If element below and left don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row + 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column - 1].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                    //this is only used on the last element of the board, "bottom right corner
                    else if ( row == 3 && column == 3 )
                    {
                    	//If element above and left don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column - 1].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                    //this is only used on the last row, first column, "bottom left corner"
                    else if ( row == 3 && column == 0 )
                    {
                    	//If element above and left don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column + 1].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                  //this is only used on the first row, middle columns, "top between corners"
                    else if ( row == 0 && ( column == 1 || column == 2 ) )
                    {
                    	//If element below and left/right don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row + 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column + 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column - 1].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                  //this is only used on the last row, middle columns, "bottom between corners"
                    else if ( row == 3 && ( column == 1 || column == 2 ) )
                    {
                    	//If element below and left/right don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column + 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column - 1].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                    //this will start checking lateral movements in the middle, first column middle rows
                    else if ( column == 0 && ( row == 1 || row == 2 ) )
                    {
                    	//if element at the right, or rows above or below don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row][column + 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row + 1][column].getNodeValue() )
                        {
                        	//add one to the counter
                            nodesWithoutMoves++;
                        }
                    }
                    //this will start checking lateral movements in the middle, last column middle rows
                    else if ( column == 3 && ( row == 1 || row == 2 ) )
                    {
                    	//if element at the left, or rows above or below don't have the same value (with the != operator), meaning they can't be added
                        if ( board[row][column].getNodeValue() != board[row][column - 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row + 1][column].getNodeValue() )
                        {
                            nodesWithoutMoves++;
                        }
                    }
                    //this is a default case, in a 4x4 matrix all the cases above should cover it
                    else
                    {
                        if ( board[row][column].getNodeValue() != board[row][column - 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row][column + 1].getNodeValue()
                            && board[row][column].getNodeValue() != board[row - 1][column].getNodeValue()
                            && board[row][column].getNodeValue() != board[row + 1][column].getNodeValue() )
                        {
                            nodesWithoutMoves++;
                        }
                    }
                }
            }
        }
        
        //after checking all the moves, if the counter is 16 means all nodes can't make a move
        if ( nodesWithoutMoves == 16 )
        {
            return false;
        }else {
        	return true;
        }
        
    }

    // When the user press the UP in the keyboard, we go through the array and for each node we execute the method vertical movement
    public void moveUp()
    {
        for ( int i = 0; i < grid; i++ )
        {
            boardLimit = 0;
            for ( int j = 0; j < grid; j++ )
            {
                if ( board[j][i].getNodeValue() != 0 )
                {
                    if ( boardLimit <= j )
                    {
                    	verticalMovement( j, i, "up" );
                    }
                }
            }
        }
    }
    
    // When the user press the DOWN in the keyboard, we go through the array and for each node we execute the method vertical movement
    public void moveDown()
    {
        for ( int i = 0; i < grid; i++ )
        {
        	//in a 4x4 grid size this will always be 3, so we iterate from 3 to zero
        	boardLimit = ( grid - 1 );
        	
            for ( int j = grid - 1; j >= 0; j-- )
            {
            	
                if ( board[j][i].getNodeValue() != 0 )
                {
                	//System.out.println("Valor de J : " + j );
                	//System.out.println("Valor de I : " + i );
                	//System.out.println("Valor del nodo: " + board[j][i].getNodeValue());
                	//System.out.println("Valor de boardLimit: " + boardLimit);
                	
                	
                    if ( boardLimit >= j )
                    {
                        verticalMovement( j, i, "down" );
                    }
                }
            }
        }
    }
    
    //Method that makes the comparison between two nodes vertically and decides if they merge or stay the same
    private void verticalMovement( int row, int column, String direction )
    {
    	// The main node we'll use for the validation
        Node primary = board[boardLimit][column];
        
        //the second node that will compare against the primary
        Node secondary = board[row][column];
        
        //If primary is 0 that means that the secondary can take the position (when a number gets over a blank position)
        //If both nodes value is equal that means they are eligible for adding
        if ( primary.getNodeValue() == 0 || primary.getNodeValue() == secondary.getNodeValue() )
        {
        	//System.out.println("board limit: " + boardLimit + " primary node value: " + primary.getNodeValue() + " secondary node: " + secondary.getNodeValue() );
            if ( row > boardLimit || ( direction.equals( "down" ) && ( row < boardLimit ) ) )
            {
                int sumOfNodesValue = primary.getNodeValue() + secondary.getNodeValue();
                
                //The node will get the sum of both nodes
                primary.setNodeValue(sumOfNodesValue);
                
                //Since the nodes are merged, the second one gets turn to 0
                secondary.setNodeValue(0);
            }
        }
        else
        {
            if ( direction.equals( "down" ) )
            {
            	boardLimit--;
            	//System.out.println(boardLimit + "boardlimit--");
            }
            else
            {
            	boardLimit++;
            	//System.out.println(boardLimit + "boardlimit++");
            }
            verticalMovement( row, column, direction );
        }
    }

    // When the user press the LEFT in the keyboard, we go through the array and for each node we execute the method horizontal movement
    public void moveLeft()
    {
        for ( int i = 0; i < grid; i++ )
        {
        	boardLimit = 0;
            for ( int j = 0; j < grid; j++ )
            {
                if ( board[i][j].getNodeValue() != 0 )
                {
                    if ( boardLimit <= j )
                    {
                        horizontalMovement( i, j, "left" );
                    }
                }
            }
        }
    }
    
    // When the user press the RIGHT in the keyboard, we go through the array and for each node we execute the method horizontal movement
    public void moveRight()
    {
        for ( int i = 0; i < grid; i++ )
        {
        	boardLimit = ( grid - 1 );
            for ( int j = ( grid - 1 ); j >= 0; j-- )
            {
                if ( board[i][j].getNodeValue() != 0 )
                {
                    if ( boardLimit >= j )
                    {
                        horizontalMovement( i, j, "right" );
                    }
                }
            }
        }
    }
    
    //Method that makes the comparison between two nodes horizontally and decides if they merge or stay the same
    private void horizontalMovement( int row, int column, String direction )
    {
    	// The main node we'll use for the validation
        Node primary = board[row][boardLimit];
        // the second node that will compare against the primary
        Node secondary = board[row][column];
        
        //If primary is 0 that means that the secondary can take the position (when a number gets over a blank position)
        //If both nodes value is equal that means they are eligible for adding
        if ( primary.getNodeValue() == 0 || primary.getNodeValue() == secondary.getNodeValue() )
        {
            if ( column > boardLimit || ( direction.equals( "right" ) && ( column < boardLimit ) ) )
            {
                int sumOfNodesValue = primary.getNodeValue() + secondary.getNodeValue();
               
                //The node will get the sum of both nodes
                primary.setNodeValue( sumOfNodesValue );
                
                //Since the nodes are merged, the second one gets turn to 0
                secondary.setNodeValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "right" ) )
            {
            	boardLimit--;
            }
            else
            {
            	boardLimit++;
            }
            horizontalMovement( row, column, direction );
        }
    }

}
