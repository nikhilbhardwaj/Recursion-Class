public class TowersOfHanoi
{
  public static void MoveTower(int n,char src,char destn,char tmp)
  {
    if(n > 0)
    {
      MoveTower(n-1,src,tmp,destn);
      MoveDisk(n,destn);
      MoveTower(n-1,tmp,destn,src);
    }
  }

  public static void MoveDisk(int disk, char tower)
  {
    System.out.printf("Move Disk %d to %c.\n",disk,tower);
  }

  public static void main(String [] args)
  {
    int n = Integer.parseInt(args[0]);
    MoveTower(n,'S','D','T');
  }
}
