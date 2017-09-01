public class Oblig06
{
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    System.out.printf("Started%n");
    try
    {
      WordList wordList = new WordList("scarlet.txt");
      System.out.printf("Number of unique Words: %d%n", wordList.getNumberOfWords());
      System.out.printf("Occurences of %s: %d%n", "Watson", wordList.getWordOccurrence("Watson"));
      System.out.printf("Occurences of %s: %d%n", "elementary", wordList.getWordOccurrence("elementary"));
      System.out.printf("Longest word: %s%n", wordList.getLongest().toString());
      System.out.printf("Shortest word: %s%n", wordList.getShortest().toString());
      System.out.printf("Uses the most characters in file: %s%n", wordList.getMostSpaceUsage().toString());

      int number = 5;
      System.out.printf("The %d most common words:%n", number);
      Word[] toPrint = wordList.mostCommon(number);
      for(Word w: toPrint) System.out.println(w.toString());
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    System.out.printf("Time to complete: %.0fms%n", System.currentTimeMillis()-start);
  }
}
