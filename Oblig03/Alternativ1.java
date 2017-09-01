//print some string n times

public class Alternativ1
{
  public static void main(String[] args)
  {
    skrivTekster("Print 4 times!", 4);
    skrivTekster("Print this one 8 times!", 8);
  }//end main

  /*print @Param tekst @Param antall times
  For every 3rd print-statement, add an extra newline
  if(number of times printed is divisible by 3) extra newline
  */
  static void skrivTekster(String tekst, int antall)
  {
    //for as many times as antall
    for(int i = 0; i<antall; i++)
    {
      System.out.println(tekst);
      if((i+1)%3==0)//i+1, if i==2 print for 3rd time
      {
        System.out.print("\n");//add extra newline in terminal
      }
    }
    System.out.println("");
  }//end skrivTekster
}//end Alternativ1
