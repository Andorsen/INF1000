import java.util.Scanner;

public class Beslutninger
{
  public static void main (String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your age:");
    int age = Integer.parseInt(in.nextLine());

    if(age<18)
    {
      System.out.println("You are not of legal age");
    }else
    {
      System.out.println("You are of legal age");
    }
  }
}
