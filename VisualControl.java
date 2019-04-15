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
    private Text[] text = new Text[maxNumber];
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
            ball[i] = new Ball(xPosNew,yPosNew,20,gd.getNodeValue(i));
            text[i] = new Text(gd.getNodeValue(i),xPosNew,yPosNew,20,"white");
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
