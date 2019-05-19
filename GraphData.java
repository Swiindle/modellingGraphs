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
                    for(int j = 0 ; j < numberEdges ; j++)
                    {
                        if(edge[j].getNodeOne() == node[i].getNumber() || edge[j].getNodeTwo() == node[i].getNumber())
                        {
                            edge[j].toggleNull(true);
                        }
                    }
                }
            }
        }
        else
        {
            System.out.printf("you're trying to remove a number bigger than maxNodes\n");
        }
    }
    public void addEdge(int a, int b, String type)
    {
        for(int i = 0; i < maxNodes ; i++)
        {
            //System.out.printf("looking at edge %d\n",i);
            if(edge[i].getNull() == true)
            {
                edge[i].toggleNull(false);
                edge[i].setType(type);
                edge[i].setNodes(node[a],node[b]);
                System.out.printf("edge %d is created connecting %d and %d\n",i,edge[i].getNodeOne(),edge[i].getNodeTwo());
                i = maxNodes;
                node[a].addConnection();
                node[b].addConnection();
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
                    node[edge[i].getNodeOne()].subtractConnection();
                    node[edge[i].getNodeTwo()].subtractConnection();
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
                node[i].resetConnection();
            }
        }
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
    public String getEdgeType(int n)
    {
        return edge[n].getType();
    }
    public void setEdgeDirection(int n , String s)
    {
        edge[n].setDirection(s);
    }
    public String getEdgeDirection(int n)
    {
        return edge[n].getDirection();
    }
    public int getMaxNodes()
    {
        return maxNodes;
    }
    
    //
    
    public boolean contains(int[] array, int n) {
        
        boolean result = false;
        
        for(int i : array)
        {
            if(i == n)
            {
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public boolean adjacent(Node a, Node b)
    {
        for(int i = 0 ; i < numberNodes ; i++)
        {
            if(a.isConnected(edge[i]) == true && b.isConnected(edge[i]) == true)
            {
                return true;
            }
        }
        return false;
    }
    /*
     * Returns an array. The array in this method contains all the nodes that this
     * node is connected to.
     */
    public int[] getNeighbours(Node thisNode)
    {
        System.out.printf("Getting Neighbours of Node %d ...\n",thisNode.getNumber());
        int[] indexOfNeighbours = new int[thisNode.getConnections()]; // assume max amount of connections is 10
        int index = 0;
        for(int i = 0 ; i < numberNodes ; i++)
        {
            if(adjacent(thisNode,node[i]) == true && i != thisNode.getNumber())
            {
                indexOfNeighbours[index] = node[i].getNumber();
                index++;
            }
        }
        return indexOfNeighbours;
    }
    
    public void traverseGraph(int currentGraph)
    {
        // INITIAL
        System.out.printf("\n\n\nTRAVERSING GRAPH %d ...\n",currentGraph);
        int[] visitedNodes = new int[numberNodes];          // array containing visited nodes
        boolean graphNotTraversed = true;
        int visitCount = 0;
        int index = 0;
        
        for(int i = 0 ; i < numberNodes ; i++)
        {
            visitedNodes[i] = -1; // -1 means empty
        }
        
        ////////////////////PROGRAM//////////////////////
        while(graphNotTraversed == true)
        {
            int[] neighbourNodes = new int[node[index].getConnections()];
            neighbourNodes = getNeighbours(node[index]); // array containing the neighbours
            visitedNodes[visitCount] = node[index].getNumber();
            index = traverseNode(index,visitedNodes,neighbourNodes);
            visitCount++;
            System.out.printf("Visiting Node %d next (if -1, traversal finished)\n",index);
            
            // to check if graph has been traversed
            for(int i : visitedNodes)
            {
                if(contains(visitedNodes,-1) == true)
                {
                    System.out.printf("Graph not yet traversed.\n");
                    graphNotTraversed = true;
                    break;
                }
                else
                {
                    graphNotTraversed = false;
                    break;
                }
            }
        }
        
        // FINAL OUTPUT
        System.out.printf("These nodes have been visited: \n");
        for(int i = 0 ; i < numberNodes ; i++)
        {
            if(visitedNodes[i] != -1)
            {
                System.out.printf("Node %d\n",visitedNodes[i]);
            }
        }
        System.out.printf("Graph traversed.\n");
    }
    public int traverseNode(int n, int[] visitedNodes, int[] neighbourNodes)
    {
        int visit = -1;
        boolean contains = true;
        //System.out.printf("Check - Node %d is neighbours with: \n",node[n].getNumber());
        for(int i = 0 ; i < node[n].getConnections() ; i++)
        {
            //System.out.printf("Node %d\n",neighbourNodes[i]);
            if(contains == false)
            {
                break;
            }
            if(contains(visitedNodes,neighbourNodes[i]) == true)
            {
                System.out.printf("Node %d has been found in visited array\n",neighbourNodes[i]);
                contains = true;
            }
            else
            {
                System.out.printf("Node %d has not been found in visited array \n",neighbourNodes[i]);
                contains = false;
                visit = neighbourNodes[i];
                break;
            }
        }
        return visit;
    }
}
