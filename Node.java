public class Node
{
    // instance variables
    int number;
    String value;
    boolean isNull = true;
    int connections = 0;
    // methods
    public Node(int n)
    {
        number = n;
    }
    public int getNumber()
    {
        return number;
    }
    public void setNumber(int n)
    {
        number = n;
    }
    public String getValue()
    {
        if(isNull == true)
        {
            System.out.println("this node is empty");
            return " ";
        }
        return value;
    }
    public void setValue(String s)
    {
        value = s;
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
            System.out.printf("Node %d now has value\n", number);
        }
        else
        {
            isNull = true;
            System.out.printf("Node %d now is empty\n", number);
        }
    }
    public int getConnections()
    {
        return connections;
    }
    
    public void resetConnection()
    {
        connections = 0;
    }
    
    public void addConnection()
    {
        connections++;
    }
    public void subtractConnection()
    {
        connections--;
    }
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
}
