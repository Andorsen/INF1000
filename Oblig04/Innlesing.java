/*
create list of words from File
search for spesific word and print number of occurrences
*/

import java.util.*;
import java.io.*;

public class Innlesing
{
  public static void main(String[] args)
  {
    //Create list to store words
    ArrayList<String> textList = new ArrayList<String>();
    try
    {
      //try to create scanner for file and user input
      Scanner fromFile = new Scanner(new File("winnie.txt"));
      Scanner in = new Scanner(System.in);
      //fill list with words from file
      while(fromFile.hasNextLine()) textList.add(fromFile.nextLine());
      //get userdefined word to search for
      System.out.print("Type word to search for: ");
      String searchFor = in.nextLine();

      //search for given word
      int counter = 0;
      for(String s : textList)
      {
        if(s.equals(searchFor)) counter++;
      }
      //print occurrences for given word to terminal
      System.out.printf("\"%s\" found: %d times.", searchFor, counter);
    }catch(FileNotFoundException e)
    {
      System.out.println("File not found");
      e.printStackTrace();
    }
  }//end main
}//end Innlesing
