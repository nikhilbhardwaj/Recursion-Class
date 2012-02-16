import java.awt.*;

/*
 * Its best to learn the java way than to fight it.
 */
public class DrawingHelper
{
  public static void DrawTriangle(Graphics g, int x, int y, int w, int h)
  {
    //Draw the three lines to make us a nice triangle
    g.drawLine(x,y,(x-w/2),(y+h));
    g.drawLine(x,y,(x+w/2),(y+h));
    g.drawLine((x-w/2),y+h,(x+w/2),y+h);
  }
}
