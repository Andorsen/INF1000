/*
Simulate a generic car
*/

public class Bil
{
  private boolean debug;//check for debug mode
  private final double LPKM;//efficiency
  private final int FUELCAPACITY;//max fuel
  private double fuel;//current fuel levels
  private int odometer;// duh, total distance the car has driven

  //constructor Bil, a: efficiency(liters per Km),b:  max fuel capacity
  //c: debug mode
  public Bil(double a, int b, boolean c)
  {
    debug = c;//set debug mode
    if(debug) System.out.printf("*DEBUGMODE*%nNew Car - L/Km:%.2f MaxFuel:%d", a, b);
    LPKM = a;
    FUELCAPACITY = b;
    //assume car is new from factory, with full tank
    fuel = b;
    odometer = 0;
  }//end constructor
  //drive distance if sufficient fuel
  public boolean driveDistance(int a)
  {
    if(debug) System.out.printf("%nDrive: %d ", a);
    if(a<getCurrentReach())
    {
      odometer+= a;
      fuel-= (LPKM*a);
      return true;
    }else return false;
  }//end driveDistance
  //fill tank if sufficient capacity
  public boolean fillTank(double a)
  {
    if(debug) System.out.printf("%nFill tank: %.2f ", a);
    if((FUELCAPACITY-fuel)>a)
    {
      fuel+= a;
      return true;
    }else return false;
  }//end fillTank
  //return reach in km given current fuel levels
  public int getCurrentReach()
  {
    return (int)(fuel/LPKM);
  }//end getCurrentReach
  //return total distance driven in Km
  public int getOdometer()
  {
    return odometer;
  }//end getOdometer
  //return current fuel levels in L
  public double getFuelLevels()
  {
    return fuel;
  }//end getFuelLevels
  //print stats for debugger
  public void printStats()
  {
    System.out.println("\nOdometer: "+odometer);
    System.out.println("Current reach: "+getCurrentReach());
    System.out.printf("Fuel levels: %.2f%n", fuel);
  }//end printStats
}//end Bil
