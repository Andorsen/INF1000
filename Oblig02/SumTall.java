/*
sum all integers given by user until user give the value 0
*/

import java.util.Scanner;

public class SumTall
{
  public static void main(String[] args)
  {
    /*Create a scanner
    declare int to hold value from user
    declare int to keep track of the total sum
    declare boolean sentinel for loop*/
    Scanner in = new Scanner(System.in);
    int number;
    int sum = 0;
    boolean quit = false;

    while(!quit)//while not terminated by user
    {
      System.out.print("An int (0 to quit): ");
      number = Integer.parseInt(in.nextLine());//assign value from user
      sum += number;//update total sum
      if(number==0)//terminate loop if user gave value 0
      {
        quit = true;
      }
    }
    //print sum of all integers from user
    System.out.println("Sum of all numbers is: "+sum);
  }//end main
}//end SumTall
