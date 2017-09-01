import java.util.Scanner;

//Demonstrate use of array[]
public class FirstArray
{
  public static void main(String[] args)
  {
    //Declacre an array with room for 4 integers
    int[] theArray = new int[4];

    //fill theArray, value = position in array
    int pos = 0;//counter to keep track of position in the array
    while(pos<theArray.length)//while the position of the array is valid
    {
      theArray[pos] = pos;//add value of counter to position counter
      pos++;//increment position
    }

    theArray[0] = 1337; //first position in array
    theArray[(theArray.length-1)] = 1337;//last position in array

    Scanner in = new Scanner(System.in);
    //declare array with room for 5 Strings
    String[] secondArray = new String[5];
    //fill secondArray with Strings from user
    pos = 0;//reset position in array
    while(pos<secondArray.length)
    {
      System.out.print("A name: ");
      secondArray[pos] = in.nextLine();
      pos++;
    }
    //print theArray to terminal
    pos = 0;
    while(pos<theArray.length)
    {
      System.out.println(theArray[pos]);
      pos++;
    }
    //print secondArray to terminal
    pos = 0;
    while(pos<secondArray.length)
    {
      System.out.println(secondArray[pos]);
      pos++;
    }
  }//end main
}//end FirstArray
