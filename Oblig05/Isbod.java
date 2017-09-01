/*
keep track of and manipulate employees
*/


import java.util.ArrayList;

public class Isbod
{
  private static ArrayList<Employee> staff = new ArrayList<>();
  private final int MAX_EMPLOYEES;

  //constructor, specify maximum number of employees
  public Isbod(int a)
  {
    MAX_EMPLOYEES = a;
  }//end Constructor
//create new employee and add to staff
  public void hire(String a)
  {
    if(staff.size()<MAX_EMPLOYEES) staff.add(new Employee(a));
    else System.out.printf("Cannto hire person \"%s\", fire staff first!%n", a);
  }//end hire
  //fire last hired staf member
  public void fireLastEmployee()
  {
    //store employee to fire
    Employee killDude = null;
    //track seniority of employee
    int latest = 0;
    //find employee with the least seniority/highest id
    for(Employee e: staff)
    {
      if(e.getId()>latest)
      {
        killDude = e;
        latest = e.getId();
      }
    }
    if(killDude!=null)
    {
      System.out.printf("Assasinating %s, Employee ID: %d%n",
      killDude.getName(), killDude.getId());
      staff.remove(killDude);
    }
  }//end fireLastEmployee
  //print all staff to terminal, in order from first employed to last
  public void printAllStaff()
  {
    System.out.println("\n\nAll current staff\n");
    staff = sort(staff);
    for(Employee e: staff)
    {
      System.out.printf("Name: %s - ID: %d%n", e.getName(), e.getId());
    }
  }//end printAllStaff
  //sort array from first id to last, just in case
  private ArrayList<Employee> sort(ArrayList<Employee> a)
  {
    ArrayList<Employee> sorted = new ArrayList<>();
    for(int i = 0; i<Employee.getLastId(); i++)
    {
      for(Employee e: a)
      {
        if(e.getId()==i) sorted.add(e);
      }
    }
    return sorted;
  }//end sort
}//end Isbod
