public class SelfArc
{
    private Ball[] ball = new Ball[2];

    private double xPosition;           // The X coordinate of this Self Arc
    private double yPosition;           // The Y coordinate of this Self Arc
    private double size;                // The diameter of this Self Arc
    private String colour;              // The colour of this Self Arc

    
    /**
     * Obtains the 3 lines that make up the arrow
     * @param n returns the specific ball
     * @return Line[] representing the arrow head
     */
    public Ball getBallsFromSelfArc(int n) {
        return ball[n];
    }
    
    /**
     * Obtains the current position of this Ball.
     * @return the X coordinate of this Ball within the GameArena.
     */
    public double getXPosition()
    {
        return xPosition;
    }
    
    /**
     * Obtains the current position of this Ball.
     * @return the Y coordinate of this Ball within the GameArena.
     */
    public double getYPosition()
    {
        return yPosition;
    }
    
    /**
     * Moves the current position of this Ball to the given co-ordinates
     * @param x the new x co-ordinate of this Ball
     */
    public void setXPosition(double x)
    {
        this.xPosition = x;
    }
    
    /**
     * Moves the current position of this Ball to the given co-ordinates
     * @param y the new y co-ordinate of this Ball
     */
    public void setYPosition(double y)
    {
        this.yPosition = y;
    }
    
    /**
     * Obtains the size of this Ball.
     * @return the diameter of this Ball,in pixels.
     */
    public double getSize()
    {
        return size;
    }
    
    /**
     * Changes the size of this Ball to the given value.
     * @param s The new size of the Ball.
     */
    public void setSize(double s)
    {
        size = s;
    }
    
    /**
     * Obtains the colour of this Ball.
     * @return a textual description of the colour of this Ball.
     */
    public String getColour()
    {
        return colour;
    }

    
    /**
     * Changes the colour of this Ball to the given value.
     *
     * @param c The new colour of this Ball.
     * <BR><BR>
     * Permissable values are 8 bit hexadecimal RGB values in the format #RRGGBB. e.g.
     * Pure red is "#FF0000"   <BR>
     * Pure green is "#00FF00" <BR>
     * Pure blue is "#0000FF"  <BR>
     * <BR>
     * Alternativley, named colours are also allowed for the following list. e.g. "AQUA" :
     * <BR><BR>
     * ALICEBLUE ANTIQUEWHITE AQUA AQUAMARINE AZURE BEIGE BISQUE BLACK BLANCHEDALMOND BLUE BLUEVIOLET BROWN BURLYWOOD CADETBLUE CHARTREUSE CHOCOLATE CORAL
     * CORNFLOWERBLUE CORNSILK CRIMSON CYAN DARKBLUE DARKCYAN DARKGOLDENROD DARKGRAY DARKGREEN DARKGREY DARKKHAKI DARKMAGENTA DARKOLIVEGREEN DARKORANGE DARKORCHID
     * DARKRED DARKSALMON DARKSEAGREEN DARKSLATEBLUE DARKSLATEGRAY DARKSLATEGREY DARKTURQUOISE DARKVIOLET DEEPPINK DEEPSKYBLUE DIMGRAY DIMGREY DODGERBLUE FIREBRICK
     * FLORALWHITE FORESTGREEN FUCHSIA GAINSBORO GHOSTWHITE GOLD GOLDENROD GRAY GREEN GREENYELLOW GREY HONEYDEW HOTPINK INDIANRED INDIGO IVORY KHAKI LAVENDER LAVENDERBLUSH
     * LAWNGREEN LEMONCHIFFON LIGHTBLUE LIGHTCORAL LIGHTCYAN LIGHTGOLDENRODYELLOW LIGHTGRAY LIGHTGREEN LIGHTGREY LIGHTPINK LIGHTSALMON LIGHTSEAGREEN LIGHTSKYBLUE LIGHTSLATEGRAY
     * LIGHTSLATEGREY LIGHTSTEELBLUE LIGHTYELLOW LIME LIMEGREEN LINEN MAGENTA MAROON MEDIUMAQUAMARINE MEDIUMBLUE MEDIUMORCHID MEDIUMPURPLE MEDIUMSEAGREEN MEDIUMSLATEBLUE
     * MEDIUMSPRINGGREEN MEDIUMTURQUOISE MEDIUMVIOLETRED MIDNIGHTBLUE MINTCREAM MISTYROSE MOCCASIN NAVAJOWHITE NAVY OLDLACE OLIVE OLIVEDRAB ORANGE ORANGERED ORCHID
     * PALEGOLDENROD PALEGREEN PALETURQUOISE PALEVIOLETRED PAPAYAWHIP PEACHPUFF PERU PINK PLUM POWDERBLUE PURPLE RED ROSYBROWN ROYALBLUE SADDLEBROWN SALMON SANDYBROWN
     * SEAGREEN SEASHELL SIENNA SILVER SKYBLUE SLATEBLUE SLATEGRAY SLATEGREY SNOW SPRINGGREEN STEELBLUE TAN TEAL THISTLE TOMATO TURQUOISE VIOLET WHEAT WHITE
     * WHITESMOKE YELLOW YELLOWGREEN.
     *
     */
    
    public void setColour(String c)
    {
        colour = c;
    }


    /**
     *
     * Constructor. Create a new instance of a Ball.
     *
     * @param x The X co-ordinate in the GameArena where this Ball will initially be located.
     * @param y The Y co-ordinate in the GameArena where this Ball will initially be located.
     * @param diameter The size (diameter) of the Ball in pixels.
     * @param col. The colour of the Ball. @see setColour for a description of permissable colours.
     *
     */
    public SelfArc(double x, double y, double diameter, String col)
    {
        xPosition = x;
        yPosition = y;
        size = diameter;
        colour = col;
        

        ball[0] = new Ball(xPosition,yPosition,size*1.3,colour);
        ball[1] = new Ball(xPosition,yPosition,size,"black");
    }
}
