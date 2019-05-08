public class Node
{
    // instance variables
    int number;
    String value;
    int connection = 0;
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
    public void setValue(int n)
    {
        if(n == 1)
        {
            value = "red";
        }
        else if(n == 2)
        {
            value = "blue";
        }
        else if(n == 3)
        {
            value = "green";
        }
        else if(n == 4)
        {
            value = "yellow";
        }
    }
    public boolean getNull()
    {
        return isNull;
    }
    public void toggleNull()
    {
        if(isNull == true)
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
