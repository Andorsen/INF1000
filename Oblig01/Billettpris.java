import java.util.Scanner;

public class Billettpris
{
  public static void main(String[] args)
  {
    final double TICKETPRICE = 50; // regular ticket price
    final int DISCOUNTAGEOLD = 67; //age above but not included are discounted
    final int DISCOUNTAGEYOUG = 12; //age below but not included are discounted
    final double DISCOUNTMODIFIER = 0.5; //modifier for discounted prices

    Scanner in = new Scanner(System.in);
    System.out.println("Estimate ticket price");
    System.out.print("Enter age:");
    int age = Integer.parseInt(in.nextLine());

    if(age>67 || age<12)
    {
      double actualPrice = TICKETPRICE * DISCOUNTMODIFIER;
      System.out.println("You are eligible for age discount.");
      System.out.println("Price is: " + actualPrice + " NOK");
    }else
    {
      System.out.println("Not eligible for age discount");
      System.out.println("Normal price is: " + TICKETPRICE + " NOK");
    }
  }
}
