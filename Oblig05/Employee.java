/*
Store information for each employee
*/

public class Employee
{
  //static counter for assigning unique id to each employee
  private static int assignId = 0;
  //employee name
  private final String name;
  //unique id for employee
  private final int employeeId;

  public Employee(String a)
  {
    name = a;
    employeeId = assignId;
    assignId++;
    System.out.printf("New employee - Name: %s, ID: %d%n", name, employeeId);
  }//end Constructor
  //return name
  public String getName()
  {
    return name;
  }
  //return employeeId
  public int getId()
  {
    return employeeId;
  }
  //return lastEmployeeId
  public static int getLastId()
  {
    return assignId;
  }
}//end Employee
