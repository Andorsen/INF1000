/*
fill array with data from file
print average temp
*/

import java.util.*;
import java.io.*;

public class Temperatur
{
  public static void main(String[] args)
  {
    //array with temperatures
    double[] temperatures = new double[12];
    //try to read from file, catch FileNotFoundException
    try
    {
      Scanner in = new Scanner(new File("temps.txt"));
      //fill array from file
      for(int i = 0; i<temperatures.length; i++)
      {
        //temps listed as ints, cast to double for ease of manipulating later
        temperatures[i] = (double)in.nextInt();
      }
      //add all elements in array, get total to find average
      double total = 0;
      for(double a: temperatures)
      {
        total += a;
      }
      //print average temp tp terminal
      System.out.printf("Average temp: %.2f%n", (total/temperatures.length));
    }catch(FileNotFoundException e)
    {
      //catch FileNotFoundException, print file not found and exit
      System.out.println("File not found");
      e.printStackTrace();
    }
  }//end main
}//end Temperaturn
