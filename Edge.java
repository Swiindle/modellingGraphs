/**
 * This is a representation of a 'Edge', which is part of the Graph ADT
 * It is best used in combination with the 'Graph ADT' class
 */
public class Edge
{
    private int number;                 // the index of the this edge
    private int nodeOne;                // the index to the first node the edge connects to
    private int nodeTwo;                // the index to the second node the edge connects to
    private String type;                // the type of edge
    private String direction;           // the direction of the self arc
    boolean isNull = true;              // whether this edge is active or not within the ADT
    
    /**
     * Constructor. Each edge should have a unique index value.
     * @param n makes edge with index n
     */
    public Edge(int n)
    {
        number = n;
    }
    /**
     * Obtains the value of the number of this edge
     * @return The number of this edge
     */
    public int getNumber()
    {
        return number;
    }
    /**
     * Sets the type of this edge
     * Supports only "normal", "directed" or "selfarc" edges
     * @param s sets the type to s
     */
    public void setType(String s)
    {
        if(s.equals("normal") == true)
        {
            type = s;
        }
        else if(s.equals("directed") == true)
        {
            type = s;
        }
        else if(s.equals("selfarc") == true)
        {
            type = s;
        }
        else
        {
            System.out.printf("Node type not valid\n");
        }
    }
    /**
     * Returns the edge type
     * @return a string containing the edge type
     */
    public String getType()
    {
        return type;
    }
    /**
     * Returns the direction which the self-arc edge is facing
     * @return the direction which the self-arc edge is facing
     */
    public String getDirection()
    {
        return direction;
    }
    
    /**
     * Sets the direction of the self-arc edge
     * Only supports "up", "right", "left" and "down"
     * @param s the direction you want to set.
     */
    public void setDirection(String s)
    {
        if(s.equals("up") == true || s.equals("right") == true || s.equals("left") == true || s.equals("down") == true)
        {
            direction = s;
        }
        else
        {
            System.out.printf("Cannot set %s direction to this type\n",s);
        }
    }
    /**
     * Returns the index of the first connected node
     * @return the index of Node One
     */
    public int getNodeOne()
    {
        if(isNull == true)
        {
            System.out.printf("Edge %d: Node One is empty\n",number);
            return -1;
        }
        else
            return nodeOne;
    }
    /**
     * Returns the index of the second connected node
     * @return the index of Node Two
     */
    public int getNodeTwo()
    {
        if(isNull == true)
        {
            System.out.printf("Edge %d: Node Two is empty\n",number);
            return -1;
        }
        else
            return nodeTwo;
    }
    /**
     * Takes the nodes 'a' and 'b' and stores their index values.
     * If this is a directed arc, place the first node in a and the second in b
     * If this is a selfarc, ensure that both nodes are the same
     * @param a the first node
     * @param b the second node
     */
    public void setNodes(Node a, Node b)
    {
        if(type.equals("selfarc") == true && a.getNumber() != b.getNumber())
        {
            System.out.printf("This edge is a selfarc, both nodes need to be the same\n");
        }
        else
        {
            nodeOne = a.getNumber();
            nodeTwo = b.getNumber();
        }
    }
    /**
     * Gets the respective opposite node. E.g if asking for node one, get node two.
     * @param n the initial node
     * @return the opposite node
     */
    public int getNode(int n)
    {
        if(isNull == true)
        {
            System.out.println("this edge is null at the momment");
            return -1;
        }
        else
        {
            if(n == 1)
            {
                return nodeOne;
            }
            else if(n == 2)
            {
                return nodeTwo;
            }
            System.out.printf("should not get here\n");
            return -1;
        }
    }
    /**
     * Returns true or false if a and b are connected by the same edge
     * @param a the first node
     * @param b the second node
     * @return true or false depending if Node a and Node b are connected
     */
    public boolean betweenNode(Node a, Node b)
    {
        if(a.getNumber() == nodeOne && b.getNumber() == nodeTwo)
        {
            return true;
        }
        return false;
    }
    /**
     * Returns a true or false if edge is currently active or not
     * @return true or false if edge is Null
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
            System.out.printf("Edge %d now has value\n", number);
        }
        else
        {
            isNull = true;
            System.out.printf("Edge %d now is empty\n", number);
        }
    }
}
