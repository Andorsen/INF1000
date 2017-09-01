/*convert an int to binary.
Use the % operator and concatonate into a String,
make sure the resulting binary number is not reversed*/
public class MinOppgave03
{
  public static void main(String[] args)
  {
    int baseTenNumber = 10; //number to convert
    int temp = baseTenNumber;
    String convertedNumber = "";//resulting string of bits

    //convert to binary
    do
    {
      //get first bit
      convertedNumber = (temp%2) + convertedNumber;//+= would invert
      //divide by 2 prepare for next bit
      temp = temp/2;
    }while(temp>0);//do/while in case baseTenNumber is 0
    //Print resulting String of bits to terminal
    System.out.println(baseTenNumber+" in binary: "+convertedNumber);
  }//end main
}//end MinOppgave03
