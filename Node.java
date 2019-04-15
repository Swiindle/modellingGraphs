public class Node
{
    // instance variables
    int number;
    int value;
    int connection = 0;
    // methods
    public Node(int n)
    {
        this.number = n;
    }
    public int getNumber()
    {
        return this.number;
    }
    public void setNumber(int n)
    {
        this.number = n;
    }
    public int getValue()
    {
        return this.value;
    }
    public void setValue(int n)
    {
        this.value = n;
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
