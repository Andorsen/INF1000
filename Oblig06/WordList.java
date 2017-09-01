/*
store and manipulate words in a file
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class WordList
{
  //arraylist to store each word
  private ArrayList<Word> list = new ArrayList<>();
  //scanner to read file
  private Scanner fromFile;
  //constructor, create scanner, read file, and add to list
  public WordList(String fileName)throws Exception
  {
    fromFile = new Scanner(new File(fileName));

    while(fromFile.hasNextLine()) addWord(fromFile.nextLine());
  }//end constructor
  //@Param word: make lower case, add to list if not there, else increment
  private void addWord(String word)
  {
    String newWord = word.toLowerCase();
    if(getWord(newWord)==null) list.add(new Word(newWord));
    else getWord(newWord).increment();
  }//end addWord
  //if @Param word: is in list, return word, else return null
  private Word getWord(String word)
  {
    String find = word.toLowerCase();
    for(Word w: list) if(w.toString().equals(find)) return w;
    return null;
  }//end getWord
  //return number of unique words registered
  public int getNumberOfWords()
  {
    return list.size();
  }//end getNumberOfWords
  //return occurrences of @Param word, -1 if not in list
  public int getWordOccurrence(String word)
  {
    Word find = getWord(word);
    if(find==null) return -1;
    else return find.getOccurrence();
  }//end getWordOccurence
  //return the @Param a: n most common words.
  public Word[] mostCommon(int a)
  {
    Word[] mostCommon = new Word[a];
    int tempOccurrence = 0;
    for(int i = 0; i<mostCommon.length; i++)
    {
      for(Word w: list)
      {
        if(w.getOccurrence()>=tempOccurrence
        && !isInArray(w, mostCommon))
        {
          mostCommon[i] = w;
          tempOccurrence = w.getOccurrence();
        }
      }
      tempOccurrence = 0;
    }
    return mostCommon;
  }//end mostCommon5
  //return true if @Param word is in @Param array.
  private boolean isInArray(Word word, Word[] array)
  {
    for(Word w: array) if(w==word) return true;
    return false;
  }//end isInArray
  //return longest word.
  public Word getLongest()
  {
    Word longest = null;
    for(Word w: list)
    {
      if(longest==null) longest = w;
      else if(w.getLength()>longest.getLength()) longest = w;
    }
    return longest;
  }//end getLongest
  //return shortest word.
  public Word getShortest()
  {
    Word shortest = null;
    for(Word w: list)
    {
      if(shortest==null) shortest = w;
      else if(w.getLength()<shortest.getLength()) shortest = w;
    }
    return shortest;
  }//end getShortest
  //return word using most characters in file
  public Word getMostSpaceUsage()
  {
    Word usesMost = null;
    for(Word w: list)
    {
      if(usesMost==null) usesMost = w;
      else if(w.getSpaceUsage()>usesMost.getSpaceUsage()) usesMost = w;
    }
    return usesMost;
  }//end getMostSpaceUsage
}//end WordList
