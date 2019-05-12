public class Edge
{
    int number;
    boolean isNull = true;
    int nodeOne;
    int nodeTwo;
    double length;
    public Edge(int n)
    {
        number = n;
    }
    public int getNodeOne()
    {
        return nodeOne;
    }
    public int getNodeTwo()
    {
        return nodeTwo;
    }
    public void setNodeOne(Node n)
    {
        nodeOne = n.getNumber();
    }
    public void setNodeTwo(Node n)
    {
        nodeTwo = n.getNumber();
    }
    public void setLength(double n)
    {
        n = length;
    }
    public double getLength()
    {
        return length;
    }
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
        return 1;
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
