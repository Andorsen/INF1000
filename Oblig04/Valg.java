/*
count votes
print winner
*/

import java.util.*;
import java.io.*;

public class Valg
{
  public static void main(String[] args)
  {
    //map to store all parties
    HashMap<String, Party> parties = new HashMap<>();

    //try to get votes from file, catch FileNotFoundException
    try
    {
      Scanner in = new Scanner(new File("stemmer.txt"));

      //store total votes
      int totalVotes = 0;
      while(in.hasNextLine())
      {
        //string to temporarily store line in file
        String temp = in.nextLine();
        totalVotes++;
        //if party already in list, add vote for party
        if(parties.containsKey(temp)) parties.get(temp).addVote();
        //else, add party to list of parties, and vote for party
        else
        {
          parties.put(temp, new Party(temp));
          parties.get(temp).addVote();
        }
      }
      //for each party, print votes and percentage of wotes
      //find party with most votes
      int mostVotes = 0;
      String winner = "";
      for(String s: parties.keySet())
      {
        System.out.printf("%s: %d votes, %.1f%%%n", s,
        parties.get(s).getVotes(), (double)parties.get(s).getVotes()/totalVotes*100);
        if(parties.get(s).getVotes()>0) winner = s;
      }
      System.out.println("\nTotal votes: "+totalVotes);
      System.out.println("Winner is: "+winner);
    }catch(FileNotFoundException e)
    {
      System.out.println("File not found!");
    }
  }//end main
}//end Valg
