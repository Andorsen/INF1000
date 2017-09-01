/*
class to represent words
*/

public class Word
{
  //store actual word
  private String theWord;
  //track number of times the word occurrs
  private int occurrence = 0;

  //constructor, set the word, and increment by one
  public Word(String text)
  {
    theWord = text;
    occurrence++;
  }//end constructor
  @Override
  //return the word as string
  public String toString()
  {
    return theWord;
  }//end toString
  //return number of occurences of word
  public int getOccurrence()
  {
    return occurrence;
  }//end getOccurrence
  //increment occurrence of word by one
  public void increment()
  {
    occurrence++;
  }//end increment
  //return length of word
  public int getLength()
  {
    return theWord.length();
  }//end getLength
  //return number of characters in the file this word is resposible for
  public int getSpaceUsage()
  {
    return theWord.length()*occurrence;
  }//end getSpaceUsage
}//end Word
