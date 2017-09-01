/*
AI that will try to solve the hang man
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class WordFinder
{
  //list of possible words
  private ArrayList<String> validWords = new ArrayList<>();
  private Scanner fromFile;
  //length of word to solve
  private int wordLength;
  private String currentSolution = "";
  private String excludedChars = "";
  private String includedChars = "";

  //constructor @Param a: filename for list of solutions
  //@Param b: length of word to solve
  public WordFinder(String a, int b)
  {
    try
    {
      fromFile = new Scanner(new File(a));
      wordLength = b;
      //create current word as blank
      for(int i = 0; i<wordLength; i++) currentSolution+= "*";
      setup();
      printStatus();
    }catch(FileNotFoundException e)
    {
      System.out.println("ERROR: File \""+a+"\" not found");
      e.printStackTrace();
    }
  }//end Constructor
//load list of eligeble words, setup word solved so far
  private void setup()
  {
    String temp = "";
    //while file had more data
    while(fromFile.hasNextLine())
    {
      temp = fromFile.nextLine();
      //if word in file is same length as word to solve, add to list
      if(temp.length()==wordLength) validWords.add(temp);
    }
    fromFile.close();
  }//end setup
//add character to exclude list, update valid solutions
  public void excludeCharacter(char a)
  {
    if(excludedChars.indexOf(a)>=0) System.out.println("\""+a+"\" already excluded");
    else
    {
      excludedChars+= a;
      System.out.println("Excluding character: \""+a+"\"");
      update();
    }
  }//end excludeCharacter
//prune list of valid words
  private void update()
  {
    //instead of changing current list, make new list of only valid words
    ArrayList<String> updated = new ArrayList<>();
    for(String s:validWords) if(isValidWord(s)) updated.add(s);
    //replace old list with updated list
    validWords = updated;
    printStatus();
  }//end update
//return true if @Param a: is currently a valid word
  private boolean isValidWord(String a)
  {
    for(int i = 0; i<excludedChars.length(); i++)
    {
      //a is not valid if it contains a char from the excluded-list,
      if(a.indexOf(excludedChars.charAt(i))>=0) return false;
    }
    for(int i = 0; i<includedChars.length(); i++)
    {
      //a is not valid if a char from the included-list is not present in a
      if(a.indexOf(includedChars.charAt(i))<0) return false;
    }
    return true;
  }//end isValidWord
//print current status for solver
  private void printStatus()
  {/*
    System.out.println("");
    System.out.println("Current solution: \""+currentSolution+"\"");
    System.out.println("Included characters: \""+includedChars+"\"");
    System.out.println("Excluded characters: \""+excludedChars+"\"");
    System.out.println("Number of valid solutions: "+validWords.size());
    System.out.println("Sugested char: "+sugestChar());
    System.out.println("");*/
  }//end printStatus
//add @Param a: character to includedCars
  public void addCharacter(char a)
  {
    if(includedChars.indexOf(a)>=0) System.out.println("\""+a+"\" already included");
    else
    {
      includedChars+= a;
      System.out.println("Including character: \""+a+"\"");
      update();
    }
  }//end addCharacter
//return sugestion for next character
  public char sugestChar()
  {
    String sugestedChar = "";
    String triedChars = "";
    int highestCharVeight = 0;
    int tempVeight;
    //for all characters still valid, find char with with highest veight
    for(String s: validWords)
    {
      for(int i = 0; i<wordLength; i++)
      {
        if(excludedChars.indexOf(s.charAt(i))<0
        && includedChars.indexOf(s.charAt(i))<0
        && triedChars.indexOf(s.charAt(i))<0)
        {
          tempVeight = getCharVeight(s.charAt(i));
          triedChars+= s.charAt(i);
          if(tempVeight>highestCharVeight)
          {
            sugestedChar = "";
            highestCharVeight = tempVeight;
            sugestedChar+= s.charAt(i);
          }
        }
      }
    }
    System.out.println("AI AR SMART... AI CHOOOS: "+sugestedChar.charAt(0));
    return sugestedChar.charAt(0);
  }//end sugestChar
//return characters "veight"(words caontaining char)
  private int getCharVeight(char a)
  {
    int veight = 0;
    for(String s: validWords)
    {
      if(s.indexOf(a)>=0) veight++;
    }
    return veight;
  }//end getCharVeight
//print all remaining valid solutions
  public void printValid()
  {
    for(String s: validWords) System.out.println(s);
  }//end printValid
}//end WordFinder
