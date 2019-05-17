import java.lang.Math;
public class GraphData
{
    // instance variables
    private int numberNodes = 0;
    private int numberEdges = 0;
    private int maxNodes = 20;
    // instantiation
    private Node[] node = new Node[maxNodes];
    private Edge[] edge = new Edge[maxNodes];
    // methods
    public GraphData()
    {
        maxNodes = 20;
    }
    public void initialize()
    {
        for(int i = 0 ; i < maxNodes ; i++)
        {
            node[i] = new Node(i);
            edge[i] = new Edge(i);
        }
    }
    /*
     * Adds a node to a list, adds into a node into the list
     */
    public void addNode(String s)
    {
        for(int i = 0; i < maxNodes ; i++)
        {
            //System.out.printf("looking at node %d\n",i);
            if(node[i].getNull() == true)
            {
                node[i].setValue(s);
                node[i].toggleNull(false);
                System.out.printf("node %d is created with value %s\n",i,node[i].getValue());
                i = maxNodes;
                numberNodes++;
            }
            else
            {
                //System.out.printf("%d is full\n",i);
            }
        }
    }
    /*
     * Removes a specific node
     */
    public void removeNode(int n)
    {
        System.out.printf("removing node %d\n",n);
        if(n < maxNodes)
        {
            for(int i = 0 ; i < maxNodes ; i++)
            {
                if(n == i)
                {
                    node[i].toggleNull(true);
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
            //System.out.printf("looking at edge %d\n",i);
            if(edge[i].getNull() == true)
            {
                edge[i].setNodeOne(node[a]);
                edge[i].setNodeTwo(node[b]);
                edge[i].toggleNull(false);
                System.out.printf("edge %d is created connecting %d and %d\n",i,edge[i].getNodeOne(),edge[i].getNodeTwo());
                i = maxNodes;
                numberEdges++;
            }
            else
            {
                //System.out.printf("edge %d is full\n",i);
            }
        }
    }
    public void removeEdge(int n)
    {
        System.out.printf("removing edge %d\n",n);
        if(n < maxNodes)
        {
            for(int i = 0 ; i < maxNodes ; i++)
            {
                if(n == i && edge[i].getNull() == false)
                {
                    edge[i].toggleNull(true);
                    numberEdges--;
                }
            }
        }
        else
        {
            System.out.printf("you're trying to remove a number bigger than maxNodes\n");
        }
    }
    public void resetEdges()
    {
        numberEdges = 0;
        for(int i = 0 ; i < maxNodes ; i++)
        {
            if(edge[i].getNull() == false)
            {
                edge[i].toggleNull(true);
            }
        }
    }
    public void resetNodes()
    {
        numberNodes = 0;
        for(int i = 0 ; i < maxNodes ; i++)
        {
            if(node[i].getNull() == false)
            {
                node[i].toggleNull(true);
            }
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
    public void getNeighbors()
    {
        /*
         * Returns an array. The array in this method contains all the nodes that this
         * node is connected to.
         */
        System.out.printf("hello\n");
    }
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
    public int getEdgeValue(int n, int m)
    {
        return edge[n].getNode(m);
    }
    public int getMaxNodes()
    {
        return maxNodes;
    }
}
