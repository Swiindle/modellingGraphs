import java.lang.Math;
public class VisualControl
{
    // instance variables
    int maxNumber = 10;
    // instantiation
    private GameArena ga = new GameArena(1000,1000);
    private GraphData gd = new GraphData();
    private Ball[] ball = new Ball[maxNumber];
    private Line[] line = new Line[maxNumber];
    // methods
    public VisualControl(int n)
    {
        maxNumber = n;
    }
    public void open()
    {
        openData(maxNumber);
        openVisual();
    }
    private void openData(int n)
    {
        gd.setMaxNodes(n);
        for(int i = 0 ; i < gd.getMaxNodes();i++)
        {
            gd.addNode(i);
            if(i > 0)
            {
                gd.addEdge(i-1,i);
            }
        }
    }
    private void openVisual()
    {
        int xPosNew = 500;
        int yPosNew = 10;
        int xPosOld = xPosNew;
        int yPosOld = yPosNew;
        // balls = nodes
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(gd.getNodeValue(i) == 1)
            {
                ball[i] = new Ball(xPosNew,yPosNew,10,"red");

            }
            else if(gd.getNodeValue(i) == 2)
            {
                ball[i] = new Ball(xPosNew,yPosNew,10,"blue");

            }
            else if(gd.getNodeValue(i) == 3)
            {
                ball[i] = new Ball(xPosNew,yPosNew,10,"green");

            }
            else
            {
                ball[i] = new Ball(xPosNew,yPosNew,10,"yellow");
            }
            ga.addBall(ball[i]);
            xPosNew = (int)(Math.random()*((1000-1)+1))+1;
            yPosNew = yPosNew + 50;
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
