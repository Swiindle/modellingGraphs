public class Node
{
    // instance variables
    int number;
    String value;
    int connection = 0;
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
        return this.value;
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
    /*
     * Mutator method, increments connection by one
     */
    public void connectionAdd()
    {
        this.connection++;
    }
    /*
     * Mutator method, decrements connection by one
     */
    public void connectionMinus()
    {
        this.connection--;
    }
    /*
     * Acessor method gets number of connections
     */
    public int getConnection()
    {
        return this.connection;
    }
}
