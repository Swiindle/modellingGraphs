import java.lang.Math; 
public class GraphData
{
    private Node[] node = new Node[10];
    private Edge[] edge = new Edge[10];
    int numberNodes = 0;
    int numberEdges = 0;
    int maxNodes = 10;
    public void addNode(int n)
    {
        node[n] = new Node(n);
        node[n].setValue((int)(Math.random()*((4-1)+1))+1);
        this.numberNodes++;
    }/*
    public void removeNode(int n)
    {
        
    }
    public void addEdge(int n, int m)
    {
        
    }
    public void removeEdge(int n, int m)
    {
        
    }
    public boolean adjacent(int n, int m)
    {
        
    }
    public void int getNeighbors(int n)
    {
        
    }*/
    public int getNumberNodes()
    {
        return numberNodes;
    }
    public void resetData()
    {
        this.numberNodes = 0;
        this.numberEdges = 0;
    }
    public int getNodeValue(int n)
    {
        return node[n].getValue();
    }
}
