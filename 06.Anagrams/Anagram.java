public class Anagram
{
  /* This is just the skeleton for searching for anagrams
   * The Dictionary interface works but it's a horrid implementation,
   * it should be noted that this is just for understanding the concepts.
   */

  public static void main(String [] args)
    throws Exception
  {
    EnglishWords dictionary = new EnglishWords();
    System.out.println(dictionary.hasWord("abacus"));
  }
}
