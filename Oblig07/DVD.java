/**
* Manage DVD's
* Store title, owner and posesser
*
*/

public class DVD
{
  private String title;
  private Person owner;
  private Person posesser;

  /**
  * Constructor for DVD
  * @param newTitle the title of this new DVD
  * @param newOwner the Person object that owns the new dvd
  */
  public DVD(String newTitle, Person newOwner)
  {
    title = newTitle;
    owner = newOwner;
    posesser = owner;
  }
  /**
  * @return title of this DVD
  */
  public String getTitle()
  {
    return title;
  }
  /**
  * @return the Person set as owner for this DVD
  */
  public Person getOwner()
  {
    return owner;
  }
  /**
  * @return the person set as posesser for this DVD
  */
  public Person getPosesser()
  {
    return posesser;
  }
  /**
  * Sets the posesser for this DVD
  * @param name The Person object to set as posesser
  */
  public void setPosesser(Person name)
  {
    posesser = name;
  }
  /**
  * removes this DVD from posessers list of loaned DVDs
  * removes this DVD from owners list of DVDs loaned to others
  * Sets the owner of this DVD as posesser
  */
  public void returnToOwner()
  {
    posesser.returnTitle(title);
    owner.dvdReturned(title);
    setPosesser(owner);
  }
  /**
  * @return true if owner of this DVD is also the posesser, else false
  */
  public boolean posessedByOwner()
  {
    return owner.equals(posesser);
  }
}
