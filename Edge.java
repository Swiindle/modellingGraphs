public class Edge
{
    int number;
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
    public void setNodeOne(int n)
    {
        nodeOne = n;
    }
    public void setNodeTwo(int n)
    {
        nodeTwo = n;
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
        if(nodeOne == n)
        {
            return nodeTwo;
        }
        else if(nodeTwo == n)
        {
            return nodeOne;
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
}
