public class Node
{
    // instance variables
    int number;
    String value;
    boolean isNull = true;
    // methods
    public Node(int n)
    {
        number = n;
    }
    public int getNumber()
    {
        return this.number;
    }
    public void setNumber(int n)
    {
        this.number = n;
    }
    public String getValue()
    {
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
