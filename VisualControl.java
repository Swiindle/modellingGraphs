import java.lang.Math;
public class VisualControl
{

    // instance variables
    int maxNodes = 10;                                  // the total number of nodes
    // instantiation
    private GameArena ga = new GameArena(1000,1000);
    private GraphData gd = new GraphData(10);
    private Ball[] ball = new Ball[maxNodes];
    private Line[] line = new Line[maxNodes];
    private Text[] text = new Text[maxNodes];
    // methods
    public VisualControl(int n)
    {
        maxNodes = n;
    }
    public void open()
    {
        int currentGraph = 0;                               // the current graph the visualizer is viewing
        gd.initialize();
        openGraphDataOne();
        openVisualOne();
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
            if(i == 2)
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
        while(true)
        {
          ga.update();
        }
    }
    /*
    private void openGraphDataTwp()
    {
        
    }
    private void openVisualTwo()
    {
        
    }
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
}
