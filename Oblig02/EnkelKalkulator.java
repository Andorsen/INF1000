/*
Print sum, diff and product of two user defined integers
*/
import java.util.Scanner;

public class EnkelKalkulator
{
  public static void main(String[] args)
  {
    //Create Scanner and declare two ints, get the values from user
    Scanner in = new Scanner(System.in);
    System.out.println("Need two ints");
    System.out.print("int a: ");
    int a = Integer.parseInt(in.nextLine());
    System.out.print("int b: ");
    int b = Integer.parseInt(in.nextLine());
    displaySum(a,b);
    displayDiff(a, b);
    displayProduct(a, b);
  }//end main
  //print sum of @Param: a, b
  static void displaySum(int a, int b)
  {
    System.out.println("\n"+a+"+"+b+" is: "+(a+b));
  }//end displaySum
  //print difference between a and b
  static void displayDiff(int a, int b)
  {
    System.out.println("\n"+a+"-"+b+" is: "+(a-b));
    //if a is less than b, also print absolute difference
    if(a<b)
    {
      System.out.println("Absolute difference is: "+((a-b)*-1));
    }
  }//end displayDiff
  //print the product of a and b
  static void displayProduct(int a, int b)
  {
    System.out.println("\n"+a+"*"+b+" is: "+a*b);
  }//end DisplayProduct
}//end EnkelKalkulator
