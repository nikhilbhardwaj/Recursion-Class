import java.awt.*;
import java.applet.*;

public class HelloApplets extends Applet
{
  //the class variables
  Color redColor, bgColor;

  public void init()
  {
    redColor = Color.red;
    bgColor = Color.green;

    setBackground(bgColor);
  }

  public void paint(Graphics g)
  {
    g.setColor(redColor);
    g.setFont(new Font("Times",Font.BOLD,32));
    g.drawString("Hello Applets!",10,40);
  }
}
