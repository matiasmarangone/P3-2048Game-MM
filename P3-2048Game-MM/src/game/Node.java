package game;

public class Node {

	//-----------Node properties---------------------

	//Value of the node
	int value;


	//Default constructor method. We create a node with initial value of 0
	public Node()
	{
		value = 0;
	}
	
	//Create a node with a different value. Used for random nodes appearing in the game
	public Node(int nodeValue)
	{    
		value = nodeValue;
	}

	//-----------Get methods---------------------

	//Returns the value of the node
    public int getNodeValue()
    {
        return value;
    }
    
    //Returns the node value in string method. Used to display in the UI
    public String toString()
    {
        return "" + value;
    }
    
    //-----------Set methods---------------------
    
    public void setNodeValue(int nodeValue)
    {
        this.value = nodeValue;
    }
    
}
