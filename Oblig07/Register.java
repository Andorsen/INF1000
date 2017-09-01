/**
* Main program for storing and manipulating persons and their DVD's
*/

import java.util.*;
import java.io.*;

public class Register
{
  static Scanner in = new Scanner(System.in);
  static HashMap<String, Person> persons = new HashMap<>();

  public static void main(String[] args)
  {
    readFile();
    mainMenu();
    save();
  }
  /**
  * Main program loop
  */
  public static void mainMenu()
  {
    boolean quit = false;
    int choice;
    while(!quit)
    {
      try
      {
        printMenu();
        choice = Integer.parseInt(in.nextLine());
        if(choice == 1) addPerson();
        else if(choice == 2) addDvd();
        else if(choice == 3) loanDvd();
        else if(choice == 4) showPerson();
        else if(choice == 5) showOverview();
        else if(choice == 6) returnDvd();
        else if(choice == 0) quit = true;
      }catch(Exception e)
      {
        System.out.println("\nERROR: Illegal menu option, try again");
        e.printStackTrace();
      }
    }
  }
  /**
  * Prints the menu options
  */
  public static void printMenu()
  {
    System.out.println("");
    System.out.println("1. Add new Person");
    System.out.println("2. Add new DVD");
    System.out.println("3. Loan DVD");
    System.out.println("4. Show info for person");
    System.out.println("5. Show overview");
    System.out.println("6. Return loaned dvd to owner");
    System.out.println("0. Quit");
  }
  /**
  * Add a person to the list of not already registered
  */
  public static void addPerson()
  {
    System.out.printf("%nAdd new Person%nName: ");
    String name = in.nextLine().toLowerCase();
    boolean exist = persons.containsKey(name);

    System.out.printf("Person \"%s\" " + (exist ? "already exist%n" : "added!%n"), name);
    persons.put(name, (exist ? persons.get(name) : new Person(name)));
  }
  /**
  * Add a DVD to a person, if that person exist
  */
  public static void addDvd()
  {
    System.out.printf("%nAdd new DVD%nOwner of new DVD: ");
    String name = in.nextLine().toLowerCase();
    System.out.print("Title of new DVD: ");
    String title = in.nextLine().toLowerCase();
    if(persons.containsKey(name))
    {
      persons.get(name).addDvd(title);
    }else
    {
      System.out.printf("Person \"%s\" does not exist%n", name);
    }
  }
  /**
  * Loan a DVD, if owner and loaner exist,
  * if loaner and owner is not the same person,
  * and the DVD is not already loaned by someone else
  */
  public static void loanDvd()
  {
    System.out.println("\nLoan DVD");
    System.out.print("Name of owner: ");
    String owner = in.nextLine().toLowerCase();
    if(isRegisteredPerson(owner))
    {
      System.out.print("Name of loaner: ");
      String loaner = in.nextLine().toLowerCase();
      if(isRegisteredPerson(loaner))
      {
        if(!loaner.equals(owner))
        {
          System.out.print("Title of dvd: ");
          String title = in.nextLine().toLowerCase();
          if(persons.get(owner).ownsDvd(title))
          {
            persons.get(owner).lendDvd(title, persons.get(loaner));
          }else System.out.printf("Person \"%s\" does not own DVD: \"%s\"%n", owner, title);
        }else System.out.println("Cannot loan to self...");
      }else System.out.printf("Person \"%s\" does not exist%n", loaner);
    }else System.out.printf("Person \"%s\" does not exist%n", owner);
  }
  /**
  * Returns whether a given name is registered or not
  *
  * @param name the name to check
  * @return if person is registered or not
  */
  public static boolean isRegisteredPerson(String name)
  {
    return persons.containsKey(name);
  }
  /**
  * Try to read archive and establish datastructure
  */
  public static void readFile()
  {
    try
    {
      File f = new File("dvdarkiv.txt").isFile() ? new File("dvdarkiv.txt") : new File("archive.txt");
      Scanner fromFile = new Scanner(f);
      String read;
      while(fromFile.hasNextLine())
      {
        read = fromFile.nextLine().toLowerCase();
        if(!read.equals("-")) persons.put(read, new Person(read));
        else break;
      }
      while(fromFile.hasNextLine())
      {
        boolean newPerson = false;
        String owner = fromFile.nextLine().toLowerCase();
        read = fromFile.nextLine().toLowerCase();
        while(!read.equals("-"))
        {
          if(read.startsWith("*"))
          {
            String title = read.substring(1, read.length());
            String posesser = fromFile.nextLine().toLowerCase();
            persons.get(owner).addDvd(title);
            persons.get(owner).lendDvd(title, persons.get(posesser));
            persons.get(posesser).loanFromOther(persons.get(owner).getDvd(title));
          }else persons.get(owner).addDvd(read);
          read = fromFile.nextLine().toLowerCase();
        }
      }
    }catch(FileNotFoundException e)
    {
      System.out.printf("%nFile not Found%nStarting with empty archive!%n%n");
    }catch(Exception e)
    {
      System.out.println("Reached end of archive");
    }
  }
  /**
  * Save current data to File
  */
  public static void save()
  {
    try
    {
      ArrayList<String> toSave = new ArrayList<>();
      ArrayList<String> fromPerson;
      PrintWriter toFile = new PrintWriter(new File("archive.txt"));
      for(String s: persons.keySet()) toSave.add(s);

      for(String p: persons.keySet())
      {
        toSave.add("-");
        toSave.add(p);
        fromPerson = new ArrayList<>(persons.get(p).getDvds());
        for(String s: fromPerson) toSave.add(s);
      }
      for(String s: toSave) toFile.println(s);
      toFile.close();
    }catch(Exception e)
    {
      System.out.printf("Oops, something went wrong...");
      e.printStackTrace();
    }
  }
  /**
  * Display info for a given person
  * Display for all persons if name is given as "*"
  */
  public static void showPerson()
  {
    System.out.println("\nShow info for person, \"*\" for all");
    System.out.print("Name: ");
    String name = in.nextLine().toLowerCase();
    if(!name.equals("*"))
    {
      if(persons.containsKey(name)) persons.get(name).printInfo();
      else System.out.printf("Person \"%s\" does not exist%n");
    }else
    {
      System.out.println("Displaying all persons");
      for(String s: persons.keySet()) persons.get(s).printInfo();
    }
  }
  /**
  * Display brief overview for all persons
  */
  public static void showOverview()
  {
    for(String s: persons.keySet()) persons.get(s).printOverview();
  }
  /**
  * Return a loaned DVD to owner if loaner exist and DVD is loaned
  */
  public static void returnDvd()
  {
    System.out.println("\nReturn DVD to owner");
    System.out.print("Name of loaner: ");
    String loaner = in.nextLine().toLowerCase();
    if(isRegisteredPerson(loaner))
    {
      System.out.print("Title of dvd to return: ");
      String title = in.nextLine().toLowerCase();
      if(persons.get(loaner).hasLoaned(title))
      {
        persons.get(loaner).getLoaned(title).returnToOwner();
      }
      else System.out.printf("Person \"%s\" does not have dvd: \"%s\"%n", loaner, title);
    }
    else System.out.printf("Person \"%s\" does not exist%n", loaner);
  }
}
