/**
* Manage persons
* Store name, owned dvds, loaned dvds, and dvds loaned to others
*/

import java.util.*;

public class Person
{
  private String name;
  private HashMap<String, DVD> dvds = new HashMap<>();
  private HashMap<String, DVD> loaned = new HashMap<>();
  private HashMap<String, DVD> dvdsToOthers = new HashMap<>();

  /**
  * Constructor for Person
  *
  * @param newName name of new Person
  */
  public Person(String newName)
  {
    name = newName;
  }
  /**
  * @return the name of this person
  */
  public String getName()
  {
    return name;
  }
  /**
  * Adds a DVD owned by this person
  * @param title the title of the DVD to be added
  */
  public void addDvd(String title)
  {
    if(dvds.containsKey(title))
    {
      System.out.printf("%s already has dvd \"%s\"%n", name, title);
    }else
    {
      dvds.put(title, new DVD(title, this));
    }
  }
  /**
  * @param title the title of a DVD
  * @return whether the DVD is owned by this person
  */
  public boolean ownsDvd(String title)
  {
    return dvds.containsKey(title);
  }
  /**
  * Loan a DVD from this person to another
  * @param title the title of the DVD
  * @param loaner the person that loans the DVD
  */
  public void lendDvd(String title, Person loaner)
  {
    if(hasDvd(title))
    {
      dvds.get(title).setPosesser(loaner);
      loaner.loanFromOther(dvds.get(title));
      dvdsToOthers.put(title, dvds.get(title));
      System.out.printf("%s is now loaning %s from %s%n",
      loaner.getName(), title, this.name);
    }else System.out.printf("\"%s\" is already loaned to: %n",
    title, dvds.get(title).getPosesser().getName());
  }
  /**
  * @param title the title of a DVD
  * @return whether this person owns and currently posesses the DVD
  */
  private boolean hasDvd(String title)
  {
    return dvds.get(title).posessedByOwner();
  }
  /**
  * Returns a list of all DVD's owned by this person.
  * If a DVD is currently loaned by another,
  * mark the DVD and specify who posesses it
  * @return an ArrayList of titles
  */
  public ArrayList<String> getDvds()
  {
    ArrayList<String> list = new ArrayList<>();
    for(String s: dvds.keySet())
    {
      if(hasDvd(s)) list.add(s);
      else
      {
        list.add("*"+s);
        list.add(dvds.get(s).getPosesser().getName());
      }
    }
    return list;
  }
  /**
  * Display info for this person.
  * Owned DVD's and DVD's loaned from others
  */
  public void printInfo()
  {
    System.out.printf("%n*******%nDetails for: %s%n", name);
    System.out.println("Owned dvds:");
    if(dvds.isEmpty()) System.out.println("None");
    else
    {
      for(String s: dvds.keySet())
      {
        DVD d = dvds.get(s);
        System.out.printf(" - %s", d.getTitle());
        if(!d.posessedByOwner()) System.out.printf("  Loaned by: %s", d.getPosesser().getName());
        System.out.println("");
      }
    }
    System.out.println("Dvds loaned from others:");
    if(loaned.isEmpty()) System.out.println("None");
    else
    {
      for(String s: loaned.keySet())
      {
        DVD d = loaned.get(s);
        System.out.printf(" - %s%nLoaned from: %s%n",
        d.getTitle(), d.getOwner().getName());
      }
    }
  }
  /**
  * Display a short overview for this person
  * name, number of DVD's owned, loaned from others, and loaned to others
  */
  public void printOverview()
  {
    System.out.println("\n Name: "+name);
    System.out.println("Owned dvds: "+dvds.size());
    System.out.println("Dvds loaned by others: "+dvdsToOthers.size());
    System.out.println("Dvds loaned from others: "+loaned.size());
  }
  /*
  * Loan a DVD from another person
  * @param d the DVD to loan from other
  */
  public void loanFromOther(DVD d)
  {
    loaned.put(d.getTitle(), d);
  }
  /*
  * Returns an owned DVD
  * @param title the title of the DVD
  * @return the specified DVD
  */
  public DVD getDvd(String title)
  {
    return dvds.get(title);
  }
  /**
  * Return whether this person has loaned a given DVD
  * @param title the title of the DVD in question
  * @return whether the DVD is loaned by this person
  */
  public boolean hasLoaned(String title)
  {
    return loaned.containsKey(title);
  }
  /**
  * Returns a given loaned DVD
  * @param title the title of the DVD
  * @return the loaned DVD
  */
  public DVD getLoaned(String title)
  {
    return loaned.get(title);
  }
  /**
  * Remove a DVD from the list of DVD's this person has loaned
  * @param title the title of the DVD
  */
  public void returnTitle(String title)
  {
    loaned.remove(title);
  }
  /**
  * Remove a DVD from the list of DVD's this person has loaned to others
  * @param title the title of the DVD
  */
  public void dvdReturned(String title)
  {
    dvdsToOthers.remove(title);
  }
}
