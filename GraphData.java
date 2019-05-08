import java.lang.Math;
public class GraphData
{
    // instance variables
    private int numberNodes = 0;
    private int numberEdges = 0;
    private int maxNodes = 10;
    // instantiation
    private Node[] node = new Node[maxNodes];
    private Edge[] edge = new Edge[maxNodes];
    // methods
    public GraphData(int n)
    {
        maxNodes = n;
    }
    public void initialize()
    {
        for(int i = 0 ; i < maxNodes ; i++)
        {
            node[i] = new Node(i);
            if(i > 0)
            {
                edge[i] = new Edge(i);
            }
        }
    }
    /*
     * Adds a node to a list, adds into a node into the list
     */
    public void addNode()
    {
        for(int i = 0; i < maxNodes ; i++)
        {
            System.out.printf("looking at %d\n",i);
            if(node[i].getNull() == true)
            {
                System.out.printf("node %d is created\n",i);
                node[i].setValue((int)(Math.random()*((4-1)+1))+1);
                node[i].toggleNull();
                i = maxNodes;
                numberNodes++;
            }
            else
            {
                System.out.printf("%d is full\n",i);
            }
        }
    }
    /*
     * Removes a specific node
     */
    public void removeNode(int n)
    {
        System.out.printf("removing %d\n",n);
        if(n < maxNodes)
        {
            for(int i = 0 ; i < maxNodes ; i++)
            {
                if(n == i)
                {
                    node[i].toggleNull();
                    numberNodes--;
                }
            }
        }
        else
        {
            System.out.printf("you're trying to remove a number bigger than maxNodes\n");
        }
    }
    public void addEdge(int a, int b)
    {
        for(int i = 0; i < maxNodes ; i++)
        {
            System.out.printf("looking at %d\n",i);
            if(edge[i].getNull() == true)
            {
                System.out.printf("edge %d is created\n",i);
                edge[i].setNodeOne(a);
                edge[i].setNodeTwo(b);
                edge[i].toggleNull();
                i = maxNodes;
                numberEdges++;
            }
            else
            {
                System.out.printf("%d is full\n",i);
            }
        }
    }
    public void removeEdge(int n)
    {
        System.out.printf("removing %d\n",n);
        if(n < maxNodes)
        {
            for(int i = 0 ; i < maxNodes ; i++)
            {
                if(n == i)
                {
                    edge[i].toggleNull();
                    numberEdges--;
                }
            }
        }
        else
        {
            System.out.printf("you're trying to remove a number bigger than maxNodes\n");
        }
    }
    public boolean adjacent(Node a, Node b)
    {
        for(int i = 0 ; i < maxNodes ; i++)
        {
            if(a.isConnected(edge[i]) == true && b.isConnected(edge[i]) == true)
            {
                return true;
            }
        }
        return false;
    }
    /*public void getNeighbors(int n)
    {
        for(int i = 0 ; i < maxNodes ; i++)
        {
            
        }
    }*/
    /*
     * Returns the number of nodes
     */
    public int getNumberNodes()
    {
        return numberNodes;
    }
    /*
     * Returns the number of edges
     */
    public int getNumberEdges()
    {
        return numberEdges;
    }
    /**
     * Gets the value of a particular node
     */
    public String getNodeValue(int n)
    {
        return node[n].getValue();
    }
    public int getMaxNodes()
    {
        return maxNodes;
    }
}
