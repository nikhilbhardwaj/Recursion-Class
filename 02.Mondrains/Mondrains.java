import java.awt.*;
import java.applet.*;
import java.util.Random;

public class Mondrains extends Applet
{
  static Random rand;

  //default constructor to set up the housekeeping
  public void init()
  {
    rand = new Random();
  }

  public void paint(Graphics g)
  {
    DrawMondrain(g,0,0,600,600);
  }

  private void DrawMondrain(Graphics g,int x, int y, int w, int h)
  {
    //don't draw when things get too small
    if( h < 10 || w < 10) return;

    //Paint the background with a random color
		//g.fillRect(
	//g.drawRect(x,y,w,h);
	g.setColor(Color.black);
    g.fillRect(x,y, w, h);

   g.setColor( RandomColor() );
	
    g.fillRect(x,y,w-1,h-1);
	
    //Make a choice between 0(inclusive) 5 exclusive
	
    int choice = rand.nextInt(5);
    switch( choice )
    {
      case 0:
		//do nothing
        System.out.println("\tDoing Nothing");
        break;
		
      case 1:
	  case 2:
	          //divide vertically
        System.out.println("\tVertical Split");
        int midX = rand.nextInt(w);
        //Left Part
        DrawMondrain(g,x,y,midX,h);
        //Right part
        DrawMondrain(g,x + midX,y,w - midX,h);
        break;
      case 3:
	  case 4:
	   //divide horizontally
        System.out.println("\tHorizontal Split");
        int midY = rand.nextInt(h);
        //top portion
        DrawMondrain(g, x,y,w,midY);
        //bottom Portion
        DrawMondrain(g, x, y + midY, w, h - midY);
        break;
        
		
    }
  }

  private Color RandomColor()
  {
    Color newColor =  new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    System.out.print(newColor.toString());
    return newColor;
  }
}
