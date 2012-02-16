public class Permutations
{
  private static void RecursivelyPermute(String soFar, String rest)
  {
    if(rest.equals(""))
    {
      System.out.println(soFar);
    }
    else
    {
      for(int i = 0; i < rest.length(); ++i)
      {
        String next = soFar + rest.charAt(i);
        String remaining = rest.substring(0,i) + rest.substring(i+1);
        RecursivelyPermute(next,remaining);
      }
    }
  }

  //wrapper function to call RecursivelyPermute
  public static void Permute(String str)
  {
    RecursivelyPermute("",str);
  }

  public static void main(String [] args)
  {
    if( args.length == 0 )
    {
      System.err.println("Pass the String you want permuted as the argument to this.");
    }
    else
    {
      Permute(args[0]);
    }
  }
}
