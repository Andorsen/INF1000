import java.util.Scanner;

public class Metoder
{
  static Scanner in = new Scanner(System.in);
  static String name;
  static String city;

  public static void main(String[] args)
  {
    greetUser();
    greetUser();
    greetUser();

    in.close();
  }
  static void greetUser(){
    System.out.print("Name: ");
    name = in.nextLine();
    System.out.print("City: ");
    city = in.nextLine();

    System.out.println("Hello " + name + ", from " + city);
  }
}
