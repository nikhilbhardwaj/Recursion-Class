import java.util.*;

public class Problem31
{
  static int totalCombos = 0;
  static int [] denominations = {1, 2, 5, 10, 20, 50, 100, 200};

  private static LinkedList<Integer> constructCandidates(LinkedList<Integer> partialSolution,int target)
  {
    LinkedList<Integer> validCandidates = new LinkedList<Integer>();
    //Introduced so as to avoid double counting
    int minVal = 0;
    if(partialSolution.size() > 0)
    {
      minVal = partialSolution.getLast();
    }
    for(int i : denominations)
    {
      if(i <= target && i >= minVal)
      {
        validCandidates.add(i);
      }
    }
    return validCandidates;
  }

  private static boolean isSolution(List<Integer> partialSolution, int target)
  {
    if(target == 0) return true;
    else return false;
  }

  private static void processSolution(List<Integer> solution)
  {
    //We just need the number of combinations
    ++totalCombos;
    //To display these combinations all we need is to process the passed in solution
  }

  private static void backtrack(LinkedList<Integer> partialSolution, int target)
  {
    if(isSolution(partialSolution,target))
    {
      processSolution(partialSolution);
    }
    else
    {
      // System.out.println("Current target = " + target);
      LinkedList<Integer> candidates = constructCandidates(partialSolution,target);
      for(Integer c : candidates)
      {
        partialSolution.add(c);
        backtrack(partialSolution, target - c);
        partialSolution.removeLast();
      }
    }
  }

  public static void main(String [] args)
  {
    LinkedList<Integer> partialSolution = new LinkedList<Integer>();
    backtrack(partialSolution,200);
    System.out.println("Total Combinations : " + totalCombos);
  }
}
