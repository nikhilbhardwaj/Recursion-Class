import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Mondrains extends Canvas
{
  static Random rand;

  //default constructor to set up the housekeeping
  public Mondrains()
  {
    rand = new Random();
  }

  public static void main(String [] args)
  {
    Mondrains canvas = new Mondrains();
    JFrame frame = new JFrame("Nikhil's Art");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(canvas);
    frame.setVisible(true);
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
    g.setColor( RandomColor() );
    g.fillRect(x,y,w,h);
    //Make a choice between 0 1 and 2
    int choice = rand.nextInt(3);
    switch( choice )
    {
      case 0:
        //do nothing
        System.out.println("\tDoing Nothing");
        break;
      case 1:
        //divide vertically
        System.out.println("\tVertical Split");
        int midX = rand.nextInt(w);
        //Left Part
        DrawMondrain(g,x,y,midX,h);
        //Right part
        DrawMondrain(g,x + midX,y,w - midX,h);
        break;
      case 2:
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
