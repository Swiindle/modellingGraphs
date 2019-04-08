public class Node
{
    int number;
    int value;
    int connections = 0;
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
    public int getValue()
    {
        return value;
    }
    public void setValue(int n)
    {
        value = n;
    }
}
