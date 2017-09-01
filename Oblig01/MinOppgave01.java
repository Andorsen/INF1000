/*
Lag et program der brukeren må gjette på et heltall mellom 1 og 100.
Programmet skal si ifra om brukeren må gjette høyere eller lavere
*/

import java.util.Scanner;
import java.util.Random;

public class MinOppgave01{
  public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    Random rng = new Random();
    int target = rng.nextInt(100);
    boolean correctAnswer = false;
    int guess;

    while(!correctAnswer)
    {
      System.out.print("Guess integer:");
      guess = Integer.parseInt(in.nextLine());
      if(guess==target)
      {
        System.out.println("Correct! Target was: "+target);
        correctAnswer = true;
      }else if(guess<target)
      {
        System.out.println("Up!");
      }else if(guess>target)
      {
        System.out.println("Down!");
      }
    }
  }
}
