/**
 * This class simulates a node with a value in a graph ADT.
 * Used best with the graphADT class
 */
public class Node
{
    private int number;                     // index of this node
    private String value;                   // the value of the node
    private boolean isNull = true;          // whether this node is active or not within the ADT
    private int connections = 0;            // the amount of connections the node has with other nodes
    
    /**
     * Constructor. Each node should have a unique index value
     * @param n makes the node with index n
     */
    public Node(int n)
    {
        number = n;
    }
    
    /**
     * Returns the index of this node
     * @return the index of this node
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Returns the value of the node
     * @return the value of the node
     */
    public String getValue()
    {
        if(isNull == true)
        {
            System.out.println("this node is empty");
            return " ";
        }
        return value;
    }
    
    /**
     * Sets the value of the node
     * @param s the string containing the value of the node
     */
    public void setValue(String s)
    {
        value = s;
    }
    
    /**
     * Returns the amount of connections that this node has made with other nodes
     * @return the amount of connections
     */
    public int getConnections()
    {
        return connections;
    }
    
    /**
     * Resets the number of connections that this node has made with other nodes. Best used when removing a node.
     */
    public void resetConnection()
    {
        connections = 0;
    }
    
    /**
     * Adds to the count of connections to the node. Best used when adding an edge.
     */
    public void addConnection()
    {
        connections++;
    }
    
    /**
     * Subtracts to the count of connections to the node. Best used when removing an edge.
     */
    public void subtractConnection()
    {
        connections--;
    }
    
    /**
     * Returns a true or false depending on whether this node is connected to another node via the specified edge
     * @param e the edge that this node may or may not be connected to
     * @return true or false depending on result
     */
    public boolean isConnected(Edge e)
    {
        if(number == e.getNodeOne() || number == e.getNodeTwo())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returns a true or false if node is currently active or not
     * @return true or false if node is Null
     */
    public boolean getNull()
    {
        return isNull;
    }
    
    /**
     * Sets the edge to be active or inactive
     * @param b true for inactive false for active
     */
    public void toggleNull(Boolean b)
    {
        if(b == false)
        {
            isNull = false;
            System.out.printf("Node %d now has value\n", number);
        }
        else
        {
            isNull = true;
            System.out.printf("Node %d now is empty\n", number);
        }
    }
}
