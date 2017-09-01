//print array of scores as grades
public class Alternativ2
{
  public static void main(String[] args)
  {
    //array of scores for grading, student id == pos in array
    int[] scores = {-2,0,15,16,17,18,22,23,30,31,35,36,40,41};
    skrivKarakterprotokoll(scores);
  }//end main

  //loop through array and print id number(position in array) and grade
  static void skrivKarakterprotokoll(int[] poeng)
  {
    for(int i = 0; i<poeng.length; i++)
    {
      System.out.println("Kandidatnummer: "+i);
      System.out.println("Karakter: "+getGrade(poeng[i])+"\n");
    }
  }//end skrivKarakterprotokoll

  //Return grade for @Param a: score
  static String getGrade(int a)
  {
    if(a<0||a>40) return "Ugyldig verdi for poeng. Ingen karakter satt";
    else if(a<16) return "F";
    else if(a<18) return "E";
    else if(a<23) return "D";
    else if(a<31) return "C";
    else if(a<36) return "B";
    else return "A";
  }//end getGrade
}//end Alternativ2
