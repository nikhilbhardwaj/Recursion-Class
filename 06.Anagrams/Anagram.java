public class Anagram
{
  /* This is just the skeleton for searching for anagrams
   * The Dictionary interface works but it's a horrid implementation,
   * it should be noted that this is just for understanding the concepts.
   */


  private static void RecursivelyPermute(String soFar, String rest)
  throws Exception
  {
    if(rest.equals(""))
    {
		EnglishWords dictionary = new EnglishWords();
		if(dictionary.hasWord(soFar))
		{
			System.out.println("The anagram is " +soFar);
			System.exit(0);
		}

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
  throws Exception
  {
    RecursivelyPermute("",str);
  }

  public static void main(String [] args)
  throws Exception
  {
    if( args.length == 0 )
    {
      System.err.println("Pass the String you want to check for anagram as the argument to this.");
    }
    else
    {
      Permute(args[0]);
    }
  }
}
