import java.util.Scanner;

public class LikeVerdier
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter integer for var C:");
    int c = Integer.parseInt(in.nextLine());
    System.out.print("Enter integer for car D:");
    int d = Integer.parseInt(in.nextLine());

    if(c==d)
    {
      System.out.println("C and D are equal");
    }else
    {
      System.out.println("C and D are not equal");
    }
  }
}
