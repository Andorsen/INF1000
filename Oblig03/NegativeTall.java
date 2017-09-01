/*count and replace negative integers in an array,
new value is it's position in the array*/
public class NegativeTall
{
  public static void main(String[] args)
  {
    //array setup
    int[] intArray = {1, 4, 5, -2, -4, 6, 10, 3, -2};

    //print initial array
    printArray(intArray);

    //replace values
    intArray = replaceNegative(intArray);

    //print the array again to see new values
    printArray(intArray);
  }//end main

  //print an array to terminal, count and print number of negative values
  public static void printArray(int[] a)
  {
    int negativeCount = 0;//store number of negative values
    System.out.println("\nAll values in array:");
    for(int i = 0; i<a.length; i++)
    {
      if(a[i]<0) negativeCount++; //if an element is negetive, add to count
      System.out.println(a[i]); //print value
    }
    //print number of negative values
    System.out.println("Number of negative values in array: "+negativeCount+"\n");
  }//end printArray

  //replace elements with negative values with the element's position in array
  public static int[] replaceNegative(int[] a)
  {
    //loop through array
    for(int i = 0; i<a.length; i++)
    {
      //if element is negative(less than 0)
      if(a[i]<0)
      {
        //print value and position, set position as new value
        System.out.print("Negative value: "+a[i]+" ");
        System.out.println("Position in array: "+i+" New value: "+i);
        a[i] = i;
      }
    }
    return a;//return processed array
  }//end replaceNegative
}//end NegativeTall
