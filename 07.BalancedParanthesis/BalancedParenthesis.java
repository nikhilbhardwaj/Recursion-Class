public class BalancedParenthesis
{
  public static void Paranthesis(int n)
  {
    RecursiveParanthesis("",0,0,n);
  }

  private static void RecursiveParanthesis(String soFar, int open,
      int close, int n)
  {
    //Base case
    if(soFar.length() == 2 * n)
    {
      System.out.println(soFar);
    }
    else
    {
      if(open < n)
      {
        RecursiveParanthesis(soFar + "(", open + 1, close, n);
      }
      if(close < open)
      {
        RecursiveParanthesis(soFar + ")", open, close + 1, n);
      }
    }
  }

  public static void main(String [] args)
  {
    Paranthesis(Integer.parseInt(args[0]));
  }
}
