import java.lang.Math;
public class GraphData
{
    // instantiation
    private Node[] node = new Node[10];
    private Edge[] edge = new Edge[10];
    // instance variables
    int numberNodes = 0;
    int numberEdges = 0;
    int maxNodes = 10;
    // methods
    public void addNode(int n)
    {
        node[n] = new Node(n);
        node[n].setValue((int)(Math.random()*((4-1)+1))+1);
        this.numberNodes++;
    }/*
    public void removeNode(int n)
    {
        node[n].setValue(0);
        this.numberEdges--;
    }*/
    public void addEdge(int a, int b)
    {
        edge[numberEdges] = new Edge(numberEdges,a,b);
        node[a].connectionAdd();
        node[b].connectionAdd();
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
    /**
     * Sets the maximum amount of nodes
     */
    public void setMaxNodes(int n)
    {
        maxNodes = n;
    }
    public int getMaxNodes()
    {
        return maxNodes;
    }
}
