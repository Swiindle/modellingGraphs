import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener
public class VisualControl implements ActionListener
{
    // instance variables
    int maxNodes = 20;                                  // the total number of nodes
    int currentGraph = 0;
    // instantiation
    private JFrame frame = new JFrame("Control");                   // frame
    private JPanel panel = new JPanel();                            // panel
    private GridLayout layout = new GridLayout(2,2);                // gridlayout, 8x8
    private JButton[] b = new JButton[4];
    private GameArena ga = new GameArena(1000,1000);
    private GraphData gd = new GraphData();
    
    private Ball[] ball = new Ball[maxNodes];
    private Line[] line = new Line[maxNodes];
    private Text[] text = new Text[maxNodes];
    
    // methods
    public VisualControl()
    {
        maxNodes = 20;
    }
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
            //gd.traverseGraph(currentGraph);
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
        /*
        if(n == 3)
        {
            openHome();
        }
        if(n == 4)
        {
            openGraphDataOne();
            openVisualOne();
        }
        if(n == 5)  // custom graph
        {
            openGraphDataTwo();
            
        }
        */
    }
    private void openHome()
    {
        removeAllGameArena();
        text[0] = new Text("HOME",500,500,50,"red");
        ga.addText(text[0]);
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
        gd.addEdge(0,1);
        gd.addEdge(0,2);
        gd.addEdge(1,3);
        gd.addEdge(2,3);
    }
    private void openVisualOne()
    {
        int nodes = 4;
        double xPos = 150;
        double yPos = 150;
        double xPosOld = xPos;
        double yPosOld = yPos;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos-10,30,"white");
            if(i == 1)
            {
                xPos = -350;
                yPos = yPos + 500;
            }
            xPos = xPos + 500;
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            ga.addLine(line[i]);
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
                    gd.addEdge(currentNodeIndex,pointerNodeIndex);
                }
                pointerNodeIndex++;
            }
        }
    }
    
    private void openVisualTwo()
    {
        double xPos = 500;
        double yPos = 200;
        
        removeAllGameArena();
        
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(i == 1)
            {
                xPos = 250;
                yPos = 500;
            }
            if(i == 2)
            {
                xPos = 750;
                yPos = 500;
            }
            if(i == 3)
            {
                xPos = 400;
                yPos = 800;
            }
            if(i == 4)
            {
                xPos = 600;
                yPos = 800;
            }
            ball[i] = new Ball(xPos,yPos,20,"red");
            text[i] = new Text(gd.getNodeValue(i),xPos-10,yPos-10,30,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            line[i] = new Line(ball[gd.getEdgeValue(i,1)].getXPosition(),ball[gd.getEdgeValue(i,1)].getYPosition(),ball[gd.getEdgeValue(i,2)].getXPosition(),ball[gd.getEdgeValue(i,2)].getYPosition(),5,"white");
        }
        for(int i = 0 ; i < gd.getNumberEdges() ; i++)
        {
            ga.addLine(line[i]);
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            ga.addBall(ball[i]);
            ga.addText(text[i]);
        }
    }
    /*
    private void openGraphDataThree()
    {
        
    }
    private void openVisualThree()
    {
        
    }
    private void openGraphDataFour()
    {
        
    }
    private void openVisualFour()
    {
        
    }
    private void openGraphDataFive()
    {
        
    }
    private void openVisualFive()
    {
        
    }*/
    /*
     private void openGraphDataCustom()
     {
     }
     private void openVisualCustom()
     {
     }
     */
    private void removeAllGameArena()
    {
        System.out.printf("Removing all GA elements\n");
        for(int i = 0 ; i < maxNodes ; i++)
        {
            ga.removeText(text[i]);
            ga.removeLine(line[i]);
            ga.removeBall(ball[i]);
        }
    }
}
