import java.lang.Math;
public class VisualControl
{

    // instance variables
    int maxNodes = 10;                                  // the total number of nodes
    int currentGraph = 0;                               // the current graph the visualizer is viewing
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
        System.out.printf("max nodes %d\n",maxNodes);
        openData(maxNodes);
        openVisual();
    }
    /*
     * Controls the data aspect of the software
     * @param the number of nodes
     */
    private void openData(int n)
    {
        gd.initialize();
        for(int i = 0 ; i < maxNodes ; i++)
        {
            gd.addNode();
        }
        gd.removeNode(2);
        gd.addNode();
    }
    /*
     * Controls the visual aspect of the software.
     */
    private void openVisual()
    {
        int xPosNew = 500;
        int yPosNew = 10;
        int xPosOld = xPosNew;
        int yPosOld = yPosNew;
        // balls = nodes
        if(gd.getNumberNodes() == 0)
        {
            System.out.printf("THERE ARE NO NODES, can't visualize\n");
        }
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            text[i] = new Text(gd.getNodeValue(i),xPosNew,yPosNew,20,"white");
            ball[i] = new Ball(xPosNew,yPosNew,20,gd.getNodeValue(i));
            ga.addText(text[i]);
            ga.addBall(ball[i]);
            xPosNew = (int)(Math.random()*((1000-1)+1))+1;
            yPosNew = yPosNew + 80;
            if(i < 9)
            {
                line[i] = new Line(xPosNew,yPosNew,xPosOld,yPosOld,2,"white");
                ga.addLine(line[i]);
            }
            xPosOld = xPosNew;
            yPosOld = yPosNew;
        }
        while(true)
        {
            ga.update();
        }
    }
}
