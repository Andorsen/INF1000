/*
Send an array of strings to a method that displays it to terminal
*/

public class MinOppgave02
{
  public static void main(String[] args)
  {
    //Setup and fill array of Strings
    String[] sendThis = new String[]{"This", "has", "been", "sent"};
    //Send array to method for printing
    printArray(sendThis);
  }//end main
  //Print @Param a: an array of Strings, to terminal
  static void printArray(String[] a)
  {
    //for each element of type String in array a, print String s to terminal
    for(String s : a)
    {
      System.out.println(s);
    }
  }//end printArray
}//end MinOppgave02
