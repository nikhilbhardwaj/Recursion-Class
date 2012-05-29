import java.util.*;

public class Permutations
{
  private static void RecursivelyPermute(String soFar, String rest,List<String> permutations)
  {
    if(rest.equals(""))
    {
      permutations.add(soFar);
    }
    else
    {
      for(int i = 0; i < rest.length(); ++i)
      {
        String next = soFar + rest.charAt(i);
        String remaining = rest.substring(0,i) + rest.substring(i+1);
        RecursivelyPermute(next,remaining,permutations);
      }
    }
  }

  //wrapper function to return a list containing all the permutations from RecursivelyPermute
  public static List<String> Permute(String str)
  {
    List<String> permutations = new ArrayList<String>();
    RecursivelyPermute("",str,permutations);
    return permutations;
  }

  public static void main(String [] args)
  {
    if( args.length == 0 )
    {
      System.err.println("Pass the String you want permuted as the argument to this.");
    }
    else
    {
      Iterator it = Permute(args[0]).iterator();
      while(it.hasNext())
      {
        System.out.println(it.next());
      }
    }
  }
}
