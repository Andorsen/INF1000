/*
Hang man
Get random word from list of words
guess the word, character by character
draw the dude, hang the dude

or let the AI play for you
*/
import java.util.*;
import java.io.*;

public class MinOppgave05
{
  //This is the actual assignment, trying to solve the previous assignment
  static WordFinder aiPlayer;

  public static void main(String[] args) throws InterruptedException
  {
    while(true){
    //actual word to guess
    String solution = getSolution();
    //current word, statrs blank
    String current = fillBlanks(solution);
    //placeholder for guessed char
    char guess;
    //counter for each wrong guess
    int counter = 0;
    //sentinel for main game loop
    boolean done = false;
    //track used letters
    String usedLetters = "";

    //Create AI player(actual oblig05)
    aiPlayer = new WordFinder("PossibleWords.txt", solution.length());
    //auto-include dashes "-" for the ai
    if(solution.indexOf('-')<0) aiPlayer.excludeCharacter('-');
    else aiPlayer.addCharacter('-');

    System.out.println("Guess the word! or hang the dude...");
    System.out.println("Length: "+solution.length());
    do
    {
      //printDude(counter);
      alternateDude(counter);
      //print guessed latters and word so far, prompt for next char
      System.out.println(current+"\nYour guess: ");
      dramaticEffect();
      guess = aiPlayer.sugestChar();
      Thread.sleep(800);
      usedLetters += guess;
      //if guess not in solution, count wrong guess
      if(solution.indexOf(guess)<0) counter++;
      //add guessed letter to word
      current = updateCurrent(solution, current, guess);
      //if word is correctly guessed, or too many tries, end loop
      if(current.equals(solution)||counter>man.length) done = true;
    }while(!done);
    //printDude(counter);
    alternateDude(counter);
    if(counter<=man.length)System.out.println("dude not dead!");
    System.out.println("Answer was: \""+solution+"\"");
    Thread.sleep(7000);
  }
  }//end main
//return word to solve
  private static String getSolution()
  {
    //list to store words
    ArrayList<String> words = new ArrayList<>();
    //random to get random word
    Random rng = new Random();
    Scanner fromFile;
    try
    {
      //create scanner to read from file
      fromFile = new Scanner(new File("PossibleWords.txt"));
      //while still data in file, add words
      while(fromFile.hasNextLine()) words.add(fromFile.nextLine());
      //if list not empty return random word
      System.out.println(words.size()+" - number of words");
      if(words.size()>0) return words.get(rng.nextInt(words.size()));
      else System.out.println("List is empty!");
      fromFile.close();
    }catch(FileNotFoundException e)
    {
      System.out.println("File not found!");
      e.printStackTrace();
    }
    return "";
  }//end getSolution
//update teh current word(solution, current, guess)
  private static String updateCurrent(String a, String b, char c) throws InterruptedException
  {
    //placeholder for updated word
    String updated = "";
    boolean wasValid = false;
    //add guessed char to word, if it exist
    for(int i = 0; i<a.length(); i++)
    {
      if(a.charAt(i)==c)
      {
        updated += a.charAt(i);
        wasValid = true;
      }else updated += b.charAt(i);
    }
    if(wasValid) aiPlayer.addCharacter(c);
    else aiPlayer.excludeCharacter(c);
    Thread.sleep(500);
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
  final static String[][] man = {{"    II========"," He Dead Nao!"},
                                 {"    II  / ","   |  Rip Dude..?"},
                                 {"    II /  ","   |"},
                                 {"    II/   ","   0"},
                                 {"    II    "," /\\ /\\"},
                                 {"    II    ","/ ( ) \\"},
                                 {"    II    ","  / \\"},
                                 {"    II    ","  I I"},
                                 {"    II    "," _I I_"} };

  private static void alternateDude(int a)
  {
    StringBuilder sb = new StringBuilder();
    sb.append("\n\n\n\n\n\n\n\n\n");

    for(int b = 0; b < man.length; b++)
    {
      sb.append(man[b][0]);
      if((man.length-b)<=a)
      {
        sb.append(man[b][1]);
        if(b==a&&a==man.length-1) sb.append(" Last Chance!");
      }
      sb.append("\n");
    }
    sb.append("    II\n");
    sb.append("vvvvvvvvvvvvvvvvvvvvvvvvvvv");
    System.out.println(sb.toString());
  }
//slow down the AI for dramatic effect in the terminal
  private static void dramaticEffect() throws InterruptedException
  {
    System.out.print("AI is tinking...");
    Thread.sleep(200);
    System.out.print("  AI is smart...");
    Thread.sleep(300);
    System.out.println("  AI can has character...");
    Thread.sleep(700);
  }//end dramaticEffect
}//end MinOppgave04
