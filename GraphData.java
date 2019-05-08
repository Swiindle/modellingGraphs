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
        this.numberEdges++;
    }/*
    public void removeEdge(int a, int b)
    {
      node[a].connectionMinus();
      node[b].connectionMinus();
      this.numberEdges--;
    }
    public boolean adjacent(int n, int m)
    {
        
    }
    public void getNeighbors(int n)
    {
        
    }*/
    public int getNumberNodes()
    {
        return numberNodes;
    }
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
