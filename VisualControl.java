public class VisualControl
{
    private GameArena ga = new GameArena(600,600);
    private GraphData gd = new GraphData();
    private Ball[] ball = new Ball[10];

    public void open()
    {
        openData();
        openVisual();
    }
    private void openData()
    {
        for(int i = 0 ; i < 10;i++)
        {
            gd.addNode(i);
        }
    }
    private void openVisual()
    {
        for(int i = 0 ; i < gd.getNumberNodes() ; i++)
        {
            if(gd.getNodeValue(i) == 1)
            {
                ball[i] = new Ball(i*10+50,250,10,"red");

            }
            else if(gd.getNodeValue(i) == 2)
            {
                ball[i] = new Ball(i*10+50,250,10,"blue");

            }
            else if(gd.getNodeValue(i) == 3)
            {
                ball[i] = new Ball(i*10+50,250,10,"green");

            }
            else
            {
                ball[i] = new Ball(i*10+50,250,10,"yellow");

            }
            ga.addBall(ball[i]);
        }
        while(true)
        {
            ga.update();
        }
    }
}
