import java.awt.*;
import java.applet.*;

public class SierpinskiTriangles extends Applet
{
  int xCoordinate, yCoordinate, width, height;
  public void init()
  {
    xCoordinate = 300;
    yCoordinate = 50;
    width = 500;
    height = 400;
  }

  public void paint(Graphics g)
  {
    DrawFractal(g,xCoordinate,yCoordinate,width,height);
  }

  public void DrawFractal(Graphics g,int x, int y, int w, int h)
  {
    DrawingHelper.DrawTriangle(g,x,y,w,h);
    // Add some delay to make it more fun
    try{ Thread.sleep(10); }
    catch( InterruptedException ex ){ System.err.println("Mummy!!, I can't Sleep."); }

    if( h < 2 || w < 2) return;
    int halfH = (int) (h/2);
    int halfW = (int) (w/2);
    //Top triangle
    DrawFractal(g, x, y, halfW, halfH);
    //Left triangle
    DrawFractal(g, x - halfW/2 , y + halfH , halfW, halfH);
    //Right triangle
    DrawFractal(g, x + halfW/2, y + halfH, halfW, halfH);
  }
}
