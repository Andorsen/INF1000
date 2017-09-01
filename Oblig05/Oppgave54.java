public class Oppgave54
{
  public static void main(String[] args)
  {
    int maxEmployees = 6;
    Isbod isbod = new Isbod(maxEmployees);

    isbod.hire("Ola");
    isbod.hire("Trine");
    isbod.hire("Onyxia");
    isbod.hire("Gruglefot");
    isbod.hire("Teamplayer");
    isbod.hire("Haterz");
    isbod.hire("TheNewGuy");
    isbod.fireLastEmployee();
    isbod.hire("TheNewGuy");
    isbod.fireLastEmployee();
    isbod.fireLastEmployee();
    isbod.fireLastEmployee();
    isbod.hire("Neo");
    isbod.hire("Jesus");
    isbod.hire("The YipYips");
    isbod.printAllStaff();
  }
}
