/*
Used in Valg.java
store votes for Party
*/

public class Party
{
  private String name;
  private int votes;

  public Party(String a)
  {
    name = a;
    votes = 0;
  }//end Constructor
  //return name of party
  public String getName()
  {
    return name;
  }
  //add vote to party
  public void addVote()
  {
    votes++;
  }
  //return number of votes for party
  public int getVotes()
  {
    return votes;
  }
}//end Party
