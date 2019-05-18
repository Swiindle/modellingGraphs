public class Edge
{
    private int number;
    private int nodeOne;
    private int nodeTwo;
    //double length;
    String type;
    private String direction;           // The direction of the self arc
    boolean isNull = true;
    
    
    public Edge(int n)
    {
        number = n;
    }
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
    public String getType()
    {
        return type;
    }
    /**
     * Obtains the size of this Ball.
     * @return the diameter of this Ball,in pixels.
     */
    public String getDirection()
    {
        return direction;
    }
    
    /**
     * Changes the size of this Ball to the given value.
     * @param s The new size of the Ball.
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
    public int getNodeOne()
    {
        return nodeOne;
    }
    public int getNodeTwo()
    {
        return nodeTwo;
    }
    /**
     * This method should always come before Node Two
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
    /*
    public void setLength(double n)
    {
        n = length;
    }
    public double getLength()
    {
        return length;
    }*/
    /**
     * Gets the opposite node
     * @param node you want from
     */
    public int getNode(int n)
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
    /**
     * Checks to see if the edge is between two nodes
     */
    public boolean betweenNode(Node a, Node b)
    {
        if(a.getNumber() == nodeOne && b.getNumber() == nodeTwo)
        {
            return true;
        }
        return false;
    }
    public boolean getNull()
    {
        return isNull;
    }
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
