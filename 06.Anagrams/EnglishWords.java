import java.io.*;

public class EnglishWords
{
  BufferedReader br;
  FileReader fin;

  public EnglishWords() throws Exception
  {
    fin = new FileReader("raw_dictionary.txt");
    br = new BufferedReader(fin);
  }

  public boolean hasWord(String word)
    throws IOException
  {
    String line;
    while( (line = br.readLine()) != null )
    {
      if(word.equals(line)){ return true; }
    }
    return false;
  }
}
