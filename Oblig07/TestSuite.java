/**
* Test suite for oblig 07
*/

public class TestSuite
{

  public static void main(String[] args)
  {
    String name1 = "firstPerson";
    String name2 = "secondPerson";
    String name3 = "thirdPerson";
    Person p1 = new Person(name1);
    Person p2 = new Person(name2);
    Person p3 = new Person(name3);
    System.out.println("Testing names: ");
    System.out.println(assertName(name1, p1) ? "Pass" : "Fail");
    System.out.println(assertName(name2, p2) ? "Pass" : "Fail");
    System.out.println(assertName(name3, p3) ? "Pass" : "Fail");

    System.out.println("\nTesting owned dvds:");
    String t1 = "title one";
    String t2 = "title two";
    p1.addDvd(t1);
    p2.addDvd(t2);
    DVD d1 = p1.getDvd(t1);
    DVD d2 = p2.getDvd(t2);
    System.out.println(assertOwnsDvd(t1, p1) ? "Pass" : "Fail");
    System.out.println(assertOwnsDvd(t2, p2) ? "Pass" : "Fail");
    System.out.println(assertOwnsDvd(t1, p2) ? "Fail" : "Pass");
    System.out.println(assertOwnsDvd(t2, p1) ? "Fail" : "Pass");
    System.out.println(assertOwnsDvd(t1, p3) ? "Fail" : "Pass");

    System.out.println("\nTesting DVD loaning:");
    p1.lendDvd(t1, p3);
    p2.lendDvd(t2, p3);
    System.out.println(assertHasLoaned(t1, p1) ? "Fail" : "Pass");
    System.out.println(assertHasLoaned(t2, p1) ? "Fail" : "Pass");
    System.out.println(assertHasLoaned(t1, p2) ? "Fail" : "Pass");
    System.out.println(assertHasLoaned(t2, p2) ? "Fail" : "Pass");
    System.out.println(assertHasLoaned(t1, p3) ? "Pass" : "Fail");
    System.out.println(assertHasLoaned(t2, p3) ? "Pass" : "Fail");

    System.out.println("\nTesting DVD instance variables and return method:");
    System.out.println(assertDvdVars(d1, p1, p1) ? "Fail" : "Pass");
    System.out.println(assertDvdVars(d2, p2, p2) ? "Fail" : "Pass");
    System.out.println(assertDvdVars(d1, p1, p3) ? "Pass" : "Fail");
    System.out.println(assertDvdVars(d2, p2, p3) ? "Pass" : "Fail");
    d1.returnToOwner();
    d2.returnToOwner();
    System.out.println(assertDvdVars(d1, p1, p1) ? "Pass" : "Fail");
    System.out.println(assertDvdVars(d2, p2, p2) ? "Pass" : "Fail");
    System.out.println(assertDvdVars(d1, p1, p3) ? "Fail" : "Pass");

  }
  static boolean assertDvdVars(DVD d, Person owner, Person posesser)
  {
    boolean pass = true;
    if(!(d.getOwner()==owner)) pass = false;
    if(!(d.getPosesser()==posesser)) pass = false;
    return pass;
  }
  static boolean assertHasLoaned(String title, Person pers)
  {
    return pers.hasLoaned(title);
  }
  static boolean assertName(String name, Person pers)
  {
    return pers.getName().equals(name);
  }
  static boolean assertOwnsDvd(String title, Person pers)
  {
    return pers.ownsDvd(title);
  }
}
