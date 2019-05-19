import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener
public class VisualControl implements ActionListener
{
    // instance variables
    private int maxNodes = 20;                                  // the total number of nodes
    private int currentGraph = 0;
    // instantiation
    private JFrame frame = new JFrame("Control");                   // frame
    private JPanel panel = new JPanel();                            // panel
    private GridLayout layout = new GridLayout(2,2);                // gridlayout, 8x8
    private JButton[] b = new JButton[4];
    private GameArena ga = new GameArena(1000,800);
    private GraphData gd = new GraphData();
    
    private Ball[] ball = new Ball[maxNodes];
    private Line[] line = new Line[maxNodes];
    private Text[] text = new Text[maxNodes];
    private Arrow[] arrow = new Arrow[maxNodes];
    private SelfArc[] selfarc = new SelfArc[maxNodes];
    
    // methods
    public VisualControl()
    {
        maxNodes = 20;
    }
    /**
     * Puts together all the classes and initializes everything necessary.
     */
    public void open()
    {
        // CONTROL FRAME
        frame.setSize(400,400);                   // sets the dimensions of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        frame.setContentPane(panel);                            // connects frame and panel
        panel.setLayout(layout);                                // connects the panel and the layout
        for(int i = 0 ; i < 4 ; i++)
        {
            if(i == 0)
            {
                b[i] = new JButton("Home");
                b[i].addActionListener(this);
            }
            else if(i == 1)
            {
                b[i] = new JButton("Traverse this Graph");
                b[i].addActionListener(this);
            }
            else if(i == 2)
            {
                b[i] = new JButton("Previous Graph");
                b[i].addActionListener(this);
            }
            else
            {
                b[i] = new JButton("Next Graph");
                b[i].addActionListener(this);
            }
            panel.add(b[i]);
        }
        frame.setVisible(true);                                 // makes frame visible
        // Graph Data
        gd.initialize();
        
        System.out.printf("VC - Current graph: %d\n",currentGraph);
        openGraph(currentGraph);
        // Game Arena
        while(true)
        {
            ga.update();
        }
    }
    
    public void actionPerformed(ActionEvent action)
    {
        if(action.getSource() == b[0])
        {
            currentGraph = 0;
            openGraph(currentGraph);
        }
        else if(action.getSource() == b[1])
        {
            if(currentGraph != 0)
            {
                gd.traverseGraph(currentGraph);
            }
            else
            {
                System.out.printf("You cannot traverse the Home page\n");
            }
        }
        else if(action.getSource() == b[2])
        {
            System.out.printf("Previous graph\n");
            if(currentGraph <= 0)
            {
                System.out.printf("ERROR:There are no more graphs\n");
            }
            else
            {
                currentGraph--;
                System.out.printf("VC - Current graph: %d\n",currentGraph);
                openGraph(currentGraph);
            }
        }
        else
        {
            System.out.printf("next graph\n");
            if(currentGraph == 6)
            {
                System.out.printf("ERROR: There are no more graphs\n");
            }
            else
            {
                currentGraph++;
                System.out.printf("VC - Current graph: %d\n",currentGraph);
                openGraph(currentGraph);
            }
        }
    }
    /**
     * Function for controlling which current graph is currently opened
     */
    public void openGraph(int n)
    {
        if(n == 0)
        {
            openHome();
        }
        if(n == 1)
        {
            openGraphDataOne();
            openVisualOne();
        }
        if(n == 2)
        {
            openGraphDataTwo();
            openVisualTwo();
        }
        if(n == 3)
        {
            openGraphDataThree();
            openVisualThree();
        }
        if(n == 4)
        {
            openGraphDataFour();
            openVisualFour();
        }
        if(n == 5)
        {
            openGraphDataFive();
            openVisualFive();
        }
        /*
         if(n == 6) // custom graph
         {
         
         }
        */
    }
    private void openHome()
    {
        removeAllGameArena();
        text[0] = new Text("SCC110 Graphs",220,220,80,"red");
        text[1] = new Text("please use the control panel",200,500,50,"white");
        ga.addText(text[0]);
        ga.addText(text[1]);
    }

    private void openGraphDataOne()
    {
        int nodes = 4;
        String valueNode = "A";
        
        gd.resetNodes();
        gd.resetEdges();
        
        for(int i = 0 ; i < nodes ; i++)
        {
            gd.addNode(valueNode);
            if(i == 1)
            {
                valueNode = "B";
            }
            else if(i == 2)
            {
                valueNode = "C";
            }
            else
            {
                valueNode = "D";
            }
        }
        gd.addEdge(0,1,"normal");
        gd.addEdge(0,2,"normal");
        gd.addEdge(1,3,"normal");
        gd.addEdge(2,3,"normal");
    }
    private void openVisualOne()
    {
        double xPos = 150;
        double yPos = 150;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos+10,30,"white");
            if(i == 1)
            {
                xPos = -350;
                yPos = yPos + 500;
            }
            xPos = xPos + 500;
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                arrow[i] = new Arrow(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else
            {
                if((gd.getEdgeDirection(i)).equals("up") == true)
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition() + 20,20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("left"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition() - 20 ,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("right"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition()+ 20,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition()-20,20,"white");
                }
            }
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                ga.addLine(line[i]);
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                ga.addArrow(arrow[i]);
            }
            else
            {
                ga.addSelfArc(selfarc[i]);
            }
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
        }
    }
    private void openGraphDataTwo()
    {
        int nodes = 5;                      // there are 5 nodes in this graph
        int connections = nodes;            // each node is connected each other node
        String valueNode = "E";
        
        gd.resetNodes();
        gd.resetEdges();
        
        // adding nodes
        for(int currentNodeIndex = 0 ; currentNodeIndex < nodes ; currentNodeIndex++)
        {
            int pointerNodeIndex = currentNodeIndex + 1;
            if(currentNodeIndex == 0)
            {
                valueNode = "E";
            }
            if(currentNodeIndex == 1)
            {
                valueNode = "F";
            }
            if(currentNodeIndex == 2)
            {
                valueNode = "G";
            }
            if(currentNodeIndex == 3)
            {
                valueNode = "H";
            }
            if(currentNodeIndex == 4)
            {
                valueNode = "I";
            }
            gd.addNode(valueNode);

            while(pointerNodeIndex < connections)
            {
                if(pointerNodeIndex != currentNodeIndex)
                {
                    gd.addEdge(currentNodeIndex,pointerNodeIndex,"normal");
                }
                pointerNodeIndex++;
            }
        }
    }
    
    private void openVisualTwo()
    {
        double xPos = 500;
        double yPos = 100;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(i == 1)
            {
                xPos = 250;
                yPos = 400;
            }
            if(i == 2)
            {
                xPos = xPos + 500;
            }
            if(i == 3)
            {
                xPos = 400;
                yPos = 700;
            }
            if(i == 4)
            {
                xPos = xPos+200;
            }
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos+10,30,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                arrow[i] = new Arrow(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else
            {
                if((gd.getEdgeDirection(i)).equals("up") == true)
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition() + 20,20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("left"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition() - 20 ,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("right"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition()+ 20,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition()-20,20,"white");
                }
            }
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                ga.addLine(line[i]);
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                ga.addArrow(arrow[i]);
            }
            else
            {
                ga.addSelfArc(selfarc[i]);
            }
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
        }
    }
    private void openGraphDataThree()
    {
        int nodes = 4;
        String valueNode = "J";
        
        gd.resetNodes();
        gd.resetEdges();
        
        for(int i = 0 ; i < nodes ; i++)
        {
            gd.addNode(valueNode);
            if(i == 1)
            {
                valueNode = "K";
            }
            else if(i == 2)
            {
                valueNode = "L";
            }
            else
            {
                valueNode = "M";
            }
        }
        gd.addEdge(0,1,"directed");
        gd.addEdge(1,2,"directed");
        gd.addEdge(2,3,"directed");
        gd.addEdge(3,0,"directed");
    }
    private void openVisualThree()
    {
        double xPos = 500;
        double yPos = 100;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(i == 1)
            {
                xPos = 200;
                yPos = 300;
            }
            if(i == 2)
            {
                xPos = 500;
                yPos = 600;
            }
            if(i == 3)
            {
                xPos = 700;
                yPos = 300;
            }
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos+10,30,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                arrow[i] = new Arrow(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else
            {
                selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                ga.addLine(line[i]);
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                ga.addArrow(arrow[i]);
            }
            else
            {
                if((gd.getEdgeDirection(i)).equals("up") == true)
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition() + 20,20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("left"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition() - 20 ,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("right"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition()+ 20,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition()-20,20,"white");
                }
            }
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
        }
    }
    private void openGraphDataFour()
    {
        int nodes = 4;
        int edges = 7;
        String valueNode = "J";
        
        gd.resetNodes();
        gd.resetEdges();
        
        for(int i = 0 ; i < nodes ; i++)
        {
            gd.addNode(valueNode);
            if(i == 1)
            {
                valueNode = "K";
            }
            else if(i == 2)
            {
                valueNode = "L";
            }
            else
            {
                valueNode = "M";
            }
        }
        for(int i = 0 ; i < 3 ; i++) // adding edges 0-2 (3 edges)
        {
            int j = i + 1;
            gd.addEdge(i,j,"directed");
        }
        gd.addEdge(0,3,"normal"); // 4th edge ([3])
        gd.addEdge(1,1,"selfarc"); // 5th edge
        gd.setEdgeDirection(4,"left");
        gd.addEdge(3,3,"selfarc"); //6th edge
        gd.setEdgeDirection(5,"right");
    }
    private void openVisualFour()
    {
        double xPos = 500;
        double yPos = 100;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(i == 1)
            {
                xPos = 200;
                yPos = 300;
            }
            if(i == 2)
            {
                xPos = 500;
                yPos = 600;
            }
            if(i == 3)
            {
                xPos = 700;
                yPos = 300;
            }
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos+10,30,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                arrow[i] = new Arrow(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else
            {
                if((gd.getEdgeDirection(i)).equals("up") == true)
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition() + 20,20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("left"))
                        {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition() - 20 ,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("right"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition()+ 20,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition()-20,20,"white");
                }
            }
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                ga.addLine(line[i]);
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                ga.addArrow(arrow[i]);
            }
            else
            {
                ga.addSelfArc(selfarc[i]);
            }
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
            ga.addSelfArc(selfarc[i]);
        }
    }
    private void openGraphDataFive()
    {
        gd.resetEdges();
        gd.resetNodes();
        
        int nodes = 6;
        int edges = 8;
        
        for(int i = 0 ; i < nodes ; i++)
        {
            gd.addNode(Integer.toString(i));
        }
        gd.addEdge(0,1,"directed");     // 0
        gd.addEdge(1,3,"directed");     // 1
        gd.addEdge(0,2,"normal");       // 2
        gd.addEdge(2,4,"directed");     // 3
        gd.addEdge(4,1,"directed");     // 4
        gd.addEdge(4,3,"directed");     // 5
        gd.addEdge(4,5,"directed");     // 6
        gd.addEdge(5,5,"selfarc");      // 7
        gd.setEdgeDirection(7,"right");
    }
    private void openVisualFive()
    {
        removeAllGameArena();
        int xPos = 450;
        int yPos = 200;
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(i == 1)
            {
                xPos = 150;
            }
            if(i == 2)
            {
                xPos = 750;
            }
            if(i == 3)
            {
                xPos = 150;
                yPos = yPos + 400;
            }
            if(i == 4)
            {
                xPos = 450;
            }
            if(i == 5)
            {
                xPos = 750;
            }
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos+10,30,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                arrow[i] = new Arrow(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
            }
            else
            {
                if((gd.getEdgeDirection(i)).equals("up") == true)
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition() + 20,20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("left"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition() - 20 ,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else if((gd.getEdgeDirection(i)).equals("right"))
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition()+ 20,ball[gd.getEdgeValue(i,2)].getYPosition(),20,"white");
                }
                else
                {
                    selfarc[i] = new SelfArc(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition()-20,20,"white");
                }
            }
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            if((gd.getEdgeType(i)).equals("normal") == true)
            {
                ga.addLine(line[i]);
            }
            else if((gd.getEdgeType(i)).equals("directed") == true)
            {
                ga.addArrow(arrow[i]);
            }
            else
            {
                ga.addSelfArc(selfarc[i]);
            }
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
            ga.addSelfArc(selfarc[i]);
        }
    }
    /*
     private void openGraphDataCustom()
     {
     }
     private void openVisualCustom()
     {
     }
     */
    /**
     * Removes all Game Arena elements from the screen, useful before moving to a new graph.
     */
    private void removeAllGameArena()
    {
        System.out.printf("Removing all GA elements\n");
        for(int i = 0 ; i < maxNodes ; i++)
        {
            Rectangle rect = new Rectangle(500,400,1000,1000,"black");
            arrow[i] = new Arrow(10,10,10,10,1,"black");
            selfarc[i] = new SelfArc(10,10,50,"black");
            
            ga.removeText(text[i]);
            ga.removeLine(line[i]);
            ga.removeBall(ball[i]);
            ga.removeArrow(arrow[i]);
            ga.removeSelfArc(selfarc[i]);
            ga.addRectangle(rect);
        }
    }
}
