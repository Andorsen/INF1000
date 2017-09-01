/*
radom return values*/

import java.util.Scanner;

public class Kalkulator
{
  public static void main(String[] args)
  {
    //verify returnvalues, true/false
    System.out.println("3+4=7 "+(addition(3, 4)==7));
    System.out.println("5-2=3 "+(subtract(5, 2)==3));
    System.out.println("10/3=3 "+(divideIntegers(10, 3)==3)+" if only integers");
    System.out.println("10/3=3 "+(divide(10, 3)==3));//expected: false
  }//end main
  //return sum of @Param: a, b
  static int addition(int a, int b)
  {
    return a+b;
  }//end addition
  //return a minus b
  static int subtract(int a, int b)
  {
    return a-b;
  }//end subtract
  //return the int of a divided by b
  static int divideIntegers(int a, int b)
  {
    return a/b;
  }//end divideIntegers
  //return a divided by b
  static double divide(double a, double b)
  {
    return a/b;
  }//end divide
}//end EnkelKalkulator
