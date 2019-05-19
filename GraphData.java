/**
 * Class containing the GRAPH ADT
 * Use this alongside 'edges' and 'nodes' classes
 * Can represent basic graphs up to 20 nodes and edges
 * Can traverse basic graphs
 */
 public class GraphData
{
    private int numberNodes = 0;                    // the current ammount of nodes that the ADT has
    private int numberEdges = 0;                    // the current ammount of edges that the ADT has
    private int maxElements = 20;                   // the maximum ammount of edges and nodes

    private Node[] node = new Node[maxElements];    // array of nodes (see Node.java)
    private Edge[] edge = new Edge[maxElements];    // array of edges (see Edge.java)

    /**
     * Constructor. Automatically sets the Max elements to 20.
     */
    public GraphData()
    {
        maxElements = 20;
    }
    
    /**
     * Initializes the ADT by instantiating all edges and nodes.
     * Call this method first before using any other methods.
     */
    public void initialize()
    {
        for(int i = 0 ; i < maxElements ; i++)
        {
            node[i] = new Node(i);
            edge[i] = new Edge(i);
        }
    }
    
    /**
     * Adds a node to the ADT. Gives the first avalible node a specified value.
     * @param s the value of the added Node
     */
    public void addNode(String s)
    {
        for(int i = 0; i < maxElements ; i++)
        {
            //System.out.printf("looking at node %d\n",i);
            if(node[i].getNull() == true)
            {
                node[i].setValue(s);
                node[i].toggleNull(false);
                System.out.printf("node %d is created with value %s\n",i,node[i].getValue());
                i = maxElements;
                numberNodes++;
            }
            else
            {
                //System.out.printf("%d is full\n",i);
            }
        }
    }
    
    /**
     * Removes the specifed node.
     * @param n the index of the Node that you want to remove
     */
    public void removeNode(int n)
    {
        System.out.printf("removing node %d\n",n);
        if(n < maxElements)
        {
            for(int i = 0 ; i < maxElements ; i++)
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
            System.out.printf("you're trying to remove a number bigger than maxElements\n");
        }
    }
    
    /**
     * Adds an edge of a certain type to the ADT, connecting two Nodes which are not null
     * @param a the index to the first node
     * @param b the index to the second node
     * @param type the edge type you want to set the edge to
     */
    public void addEdge(int a, int b, String type)
    {
        for(int i = 0; i < maxElements ; i++)
        {
            //System.out.printf("looking at edge %d\n",i);
            if(edge[i].getNull() == true)
            {
                edge[i].toggleNull(false);
                edge[i].setType(type);
                edge[i].setNodes(node[a],node[b]);
                System.out.printf("Edge %d is created connecting %d and %d and is type %s\n",i,edge[i].getNodeOne(),edge[i].getNodeTwo(),type);
                i = maxElements;
                if(type.equals("directed"))
                {
                    node[a].addConnection();
                }
                else
                {
                    node[a].addConnection();
                    node[b].addConnection();
                }
                numberEdges++;
            }
            else
            {
                //System.out.printf("edge %d is full\n",i);
            }
        }
    }
    
    /**
     * Removes the specific edge from the ADT and modifies the nodes that it is connected to
     * @param n the index of the edge
     */
    public void removeEdge(int n)
    {
        System.out.printf("removing edge %d\n",n);
        if(n < maxElements)
        {
            for(int i = 0 ; i < maxElements ; i++)
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
            System.out.printf("you're trying to remove a number bigger than maxElements\n");
        }
    }
    
    /**
     * Used to automatically remove all nodes from this ADT
     */
    public void resetNodes()
    {
        numberNodes = 0;
        for(int i = 0 ; i < maxElements ; i++)
        {
            if(node[i].getNull() == false)
            {
                node[i].toggleNull(true);
                node[i].resetConnection();
            }
        }
    }
    
    /**
     * Used to automatically remove all edges from this ADT
     */
    public void resetEdges()
    {
        numberEdges = 0;
        for(int i = 0 ; i < maxElements ; i++)
        {
            if(edge[i].getNull() == false)
            {
                edge[i].toggleNull(true);
            }
        }
    }
   
    /**
     * Returns the current number of nodes in the ADT
     * @return the number of nodes
     */
    public int getNumberNodes()
    {
        return numberNodes;
    }
    
    /**
     * Returns the current number of edges in the ADT
     * @return the number of edges
     */
    public int getNumberEdges()
    {
        return numberEdges;
    }
    
    /**
     * Gets the value of a particular node
     * @param n the index of the node that you want to retrieve value from
     * @return the value of the specified node
     */
    public String getNodeValue(int n)
    {
        return node[n].getValue();
    }
    
    /**
     * Returns the index of the node which is connected to the specified edge. (See getNode from Edge.java)
     * @param n the index of the edge
     * @param m 1 or 2 depending on retrieving index of node one or node two
     * @return the value of the edge
     */
    public int getNodeIndexFromEdge(int n, int m)
    {
        return edge[n].getNode(m);
    }
    
    /**
     * Returns the type of the edge with the specified value.
     * @param n the index of the edge
     * @return the type of the edge
     */
    public String getEdgeType(int n)
    {
        return edge[n].getType();
    }
    
    /**
     * Sets the specified self-arc edge to have a certain direction. Make sure that the edge has type "selfarc" before using this method. (See setDirection from Edge.java)
     * @param n index of the array
     * @param s the direction that you want to set
     */
    public void setEdgeDirection(int n , String s)
    {
        edge[n].setDirection(s);
    }
    
    /**
     * Returns the direction of the specified edge
     * @param n index of the edge
     * @return direction of edge
     */
    public String getEdgeDirection(int n)
    {
        return edge[n].getDirection();
    }
    
    /**
     * Returns the max elements of this ADT
     * @return the max elements of this ADT
     */
    public int getmaxElements()
    {
        return maxElements;
    }
    
    /**
     * Checks to see if an array contains a particular integer. Returns true or false depending on whether the integer is contained within the array.
     * @param array the array which you would like to search
     * @param n the number which you would like to search
     * @return true or false depending on whether integer was found
     */
    private boolean contains(int[] array, int n) {
        
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
    
    /**
     * Checks to see if two nodes are connected by an edge. Returns a true or false value depending on the result of the search.
     * Itirates through all the edges in the ADT - comparing them with the provided the nodes
     * @param a the first node
     * @param b the second node
     * @return the boolean
     */
    private boolean adjacent(Node a, Node b)
    {
        boolean isAdjacent = false;
        for(int i = 0 ; i < numberEdges ; i++)
        {
            if((edge[i].getType()).equals("selfarc") == false && a.getNumber() == b.getNumber())
            {
                System.out.printf("1 Node %d is not connected to node %d\n",a.getNumber(),b.getNumber());
                return false;
            }
            if((edge[i].getType()).equals("directed") == true)
            {
                System.out.printf("Edge %d connected Node %d and Node %d\n",edge[i].getNumber(),edge[i].getNodeOne(),edge[i].getNodeTwo());
                if(a.isConnected(edge[i]) == true && b.isConnected(edge[i]) == true) // if connected to the same edge
                {
                    if(edge[i].getNodeOne() == b.getNumber() && edge[i].getNodeTwo() == a.getNumber())
                    {
                        System.out.printf("2 Node %d is not connected to node %d\n",a.getNumber(),b.getNumber());
                        return false;
                    }
                    else
                    {
                        System.out.printf("True, Edge %d is directed, nodeOne is %d, nodeTwo is %d\n",edge[i].getNumber(),edge[i].getNodeOne(),edge[i].getNodeTwo());
                        return true;
                    }
                }
                else
                {
                    System.out.printf("3 Node %d is not connected to node %d\n",a.getNumber(),b.getNumber());
                }
            }
            else
            {
                if(a.isConnected(edge[i]) == true && b.isConnected(edge[i]) == true) // if connected to the same edge
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Returns an array containing the neighbours a particular node has
     * Does this by comparing the provided Node with all other nodes in the ADT
     * @param thisNode the specific node that you want to find neighbours of
     * @return array containing the indexes to the nodes that the specified node is neighbours with
     */
    private int[] getNeighbours(Node thisNode)
    {
        System.out.printf("Getting Neighbours of Node %d ...\n",thisNode.getNumber());
        int[] indexOfNeighbours = new int[thisNode.getConnections()];
        int index = 0;
        for(int i = 0 ; i < numberNodes ; i++)
        {
            //System.out.printf("Another Loop\nChecking if Node %d is adjacent to Node%d\n",thisNode.getNumber(),node[i].getNumber());
            if(adjacent(thisNode,node[i]) == true)
            {
                //System.out.printf("Node %d is adjacent to Node %d\n",thisNode.getNumber(),node[i].getNumber());
                indexOfNeighbours[index] = node[i].getNumber();
                index++;
            }
        }
        System.out.printf("Node %d is neighbours with: \n",thisNode.getNumber());
        for(int i = 0 ; i < thisNode.getConnections() ; i++)
        {
            System.out.printf("Node %d\n",indexOfNeighbours[i]);
        }
        return indexOfNeighbours;
    }
    
    /**
     * Performs a depth first traversal of the graph that is currently stored within the ADT
     * Outputs the results of the traversal. Automatically starts at the index of 0.
     * @param currentGraph the number of this graph - makes the ouput look nicer
     */
    public void traverseGraph(int currentGraph)
    {
        // INITIAL
        System.out.printf("\n\n\nTRAVERSING GRAPH %d ...\n",currentGraph);
        
        int[] visitedNodes = new int[numberNodes];          // array containing visited nodes
        boolean graphNotTraversed = true;                   // whether the graph has finished its traversal
        int visitCount = 0;                                 // counts how many visits to a node the traversal has done
        int index = 0;                                      // the index to the node currently being visited
        
        for(int i = 0 ; i < numberNodes ; i++)              // ensures the visited array is '-1' - representing null
        {
            visitedNodes[i] = -1; // -1 means empty
        }
        
        ////////////////////PROGRAM//////////////////////
        while(graphNotTraversed == true)                    // performs traversal until traversal is done
        {
            int[] neighbourNodes = new int[node[index].getConnections()];
            neighbourNodes = getNeighbours(node[index]);    // gets the neighbours of the node
            if(contains(visitedNodes,node[index].getNumber()) == false) // ensures that no node is in the visited array twice
            {
               visitedNodes[visitCount] = node[index].getNumber();   // adds the visited node to the visited array
            }
            index = traverseNode(node[index],visitedNodes,neighbourNodes); // make the traversal and find the next node
            visitCount++;
            System.out.printf("Visiting Node %d next (if -1, traversal finished)\n",index);
            
            // to check if graph has been traversed
            for(int i : visitedNodes)                   // a check to see if the graph traversal is finished
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
    
    /**
     * Seperated from the above method for clarity... performs a depth first traversal on a particular node.
     * Returns the index to the next node that should be visited in the traversal.
     * @param n the index of the node
     * @param the array containing all previously visited nodes
     * @param the array containing all neighbouring nodes
     * @return the index to the node that will be visited next
     */
    private int traverseNode(Node thisNode, int[] visitedNodes, int[] neighbourNodes)
    {
        int visit = -1;
        boolean contains = true;
        
        System.out.printf("Size of visited nodes: %d \nSize of Neighbour nodes: %d \n",numberNodes,thisNode.getConnections());
        if(thisNode.getConnections() == 0)              // if no connections are found go to the start
        {
            return visit = 0;
        }
        for(int i = 0 ; i < thisNode.getConnections() ; i++) // finds the node to go to 
        {
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
