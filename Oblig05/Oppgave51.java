/*
tester for Bil
run as "Oppgave51 -debug" for debug mode
*/

public class Oppgave51
{
  static boolean debug = false;

  public static void main(String[] args)
  {
    //check for run arguments
    for(String s: args) if(s.equals("-debug")) debug = true;
    if(debug) printTest();
  }//end main
  //debugger
  public static void printTest()
  {
    Bil bil = new Bil(0.06, 60, debug);
    System.out.println(bil.driveDistance(1600));
    System.out.println(bil.driveDistance(40));
    System.out.println(bil.driveDistance(40));
    bil.printStats();
    System.out.println(bil.driveDistance(800));
    bil.printStats();
    System.out.println(bil.driveDistance(500));
    System.out.println(bil.fillTank(500));
    bil.printStats();
    System.out.println(bil.fillTank(20));
    System.out.println(bil.driveDistance(100));
    bil.printStats();
  }//end printTest
}//end Oppgave51
