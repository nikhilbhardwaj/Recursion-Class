import java.util.*;

public class Subsets
{
  private static void RecursiveSubsets(List<String> list, String soFar, String rest)
  {
    if(rest.equals(""))
    {
      list.add(soFar);
      System.out.println(soFar);
    }
    else
    {
      String remaining = rest.substring(1);
      //include the element
      RecursiveSubsets(list, soFar + rest.charAt(0), remaining);
      //exclude the element
      RecursiveSubsets(list, soFar, remaining);
    }
  }

  public static List<String> getSubsetList(String str)
  {
    List<String> subsets = new ArrayList<String>();
    RecursiveSubsets(subsets,"",str);
    return subsets;
  }

  public static void main(String [] args)
  {
    List<String> allSubsets = getSubsetList(args[0]);
    System.out.println("Total Subsets returned : " + allSubsets.size());
  }
}
