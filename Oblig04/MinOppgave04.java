/*
Hang man
Get random word from list of words
guess the word, character by character
draw the dude, hang the dude
*/
import java.util.*;
import java.io.*;

public class MinOppgave04
{
  public static void main(String[] args)
  {
    //actual word to guess
    String solution = getSolution();
    //current word, statrs blank
    String current = fillBlanks(solution);
    //sentinel for main game loop
    boolean done = false;
    //scaner for user input
    Scanner in = new Scanner(System.in);
    //placeholder for guessed char
    char guess;
    //counter for each wrong guess
    int counter = 0;
    //track used letters
    String usedLetters = "";

    System.out.println("Guess the word! or hang the dude...");
    System.out.println("Length: "+solution.length());
    while(!done)
    {
      printDude(counter);
      //print guessed latters and word so far, prompt for next char
      System.out.println("Used letters: "+usedLetters);
      System.out.print(current+" Your guess: ");
      guess = in.nextLine().charAt(0);
      usedLetters += guess;
      //if guess not in solution, count wrong guess
      if(solution.indexOf(guess)<0) counter++;
      //add guessed letter to word
      current = updateCurrent(solution, current, guess);
      //if word is correctly guessed, or too many tries, end loop
      if(current.equals(solution)||counter>9) done = true;
    }
    printDude(counter);
    if(counter<=9)System.out.println("dude not dead!");
    System.out.println("Answer was: \""+solution+"\"");
  }//end main
//return word to solve
  private static String getSolution()
  {
    //list to store words
    ArrayList<String> words = new ArrayList<>();
    //random to get random word
    Random rng = new Random();
    try
    {
      //create scanner to read from file
      Scanner fromFile = new Scanner(new File("Possiblewords.txt"));
      //while still data in file, add words
      while(fromFile.hasNextLine()) words.add(fromFile.nextLine());
      //if list not empty return random word
      System.out.println(words.size()+" - number of words");
      if(words.size()>0) return words.get(rng.nextInt(words.size()));
      else System.out.println("List is empty!");
    }catch(FileNotFoundException e)
    {
      System.out.println("File not found!");
      e.printStackTrace();
    }
    return "";
  }//end getSolution
//update teh current word
  private static String updateCurrent(String a, String b, char c)
  {
    //placeholder for updated word
    String updated = "";
    //add guessed char to word, if it exist
    for(int i = 0; i<a.length(); i++)
    {
      if(a.charAt(i)==c) updated += a.charAt(i);
      else updated += b.charAt(i);
    }
    //return updated word
    return updated;
  }//end updatecurrent
//return string filled with "*"
  private static String fillBlanks(String a)
  {
    String toReturn = "";
    for(int i = 0; i<a.length(); i++)
    {
      if(a.charAt(i)=='-') toReturn += '-';
      else toReturn += "*";
    }
    return toReturn;
  }//end fillBlanks
  //print the dude for hanging
  private static void printDude(int a)
  {
    System.out.println("\n\n\n\n");
    if(a>9)System.out.println("    rip dude...  He dead now!");
    if(a>8)System.out.println("    II========");
    if(a>7)System.out.println("    II  /    |");
    if(a>6)System.out.println("    II /     |");
    if(a>5)System.out.println("    II/      0");
    if(a>4)System.out.println("    II     /\\ /\\");
    if(a>3)System.out.println("    II    / ( ) \\");
    if(a>2)System.out.println("    II      / \\");
    if(a>1)System.out.println("    II      I I");
    if(a>0)System.out.println("    II     _I I_");
    System.out.println("    II");
    System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvv");
  }//end printDude
}//end MinOppgave04
