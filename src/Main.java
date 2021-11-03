import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static ArrayList<Friend> friendList = new ArrayList<>();

  public static void main(String[] args) {
    new Main().menuRun();
  }

  public void menuRun() {
    String[] menuItem = new String[10]; //Her laver vi 10 tomme pladser for Strings da Quit skal være på 9 og indeks starter fra 0 skal den være på 10 tomme pladser

    menuItem[1] = "Show list of friends"; //Her siger vi hvad hver array indeholder på indek 1
    menuItem[2] = "Enter new friend"; //indeks 2
    menuItem[3] = "Delete friend"; //indeks 3
    menuItem[4] = "Save list";
    menuItem[5] = "Load list";
    menuItem[9] = "QUIT"; //indeks 9

    Menu menu = new Menu("MENU", "Choose option: ", menuItem); //Bruger konstruktøren med de 3 parametre
    menu.printMenu();

    int choice = menu.readChoice(); //Her laver vi metoden om til en variablen som vi kalder for choice som altså er "input"
    boolean checkChoice; //Denne boolean skal jeg bruge til at lave en do while loop fordi den skal blive ved med at spøge hvis man skriver et andet tal end 1,2,3,9.
    // fordi i readChoice() så tjekker den kun om det en integer der bliver indtastet men ikke om det er den rigtige af dem.
    do {
      switch (choice) { //Laver en switch som kontroller brugerens input
        case 1:
          System.out.println("You chose 'Show list of friends'"); //Hvis bruger har skrevet 1 vil den sige dette
          new Friend().showList();
          checkChoice = true;
          break;
        case 2:
          System.out.println("You chose 'Enter new friend'"); // Hvis bruger har skrevet 2 vil den sige dette
          new Friend().enterNewFriend();
          checkChoice = true;
          break;
        case 3:
          System.out.println("You chose 'Delete friend'"); // Hvis bruger har skrevet 3 vil den sige dette
          new Friend().deleteFriend();
          checkChoice = true;
          break;
        case 4:
          System.out.println("You chose 'Save list'");
          try {
            new Friend().saveList();
          } catch (IOException e) {
            e.printStackTrace();
          }
          checkChoice = true;
          break;
        case 5:
          System.out.println("You chose 'Load list'");
          try {
            new Friend().loadList();
          } catch (IOException e) {
            e.printStackTrace();
          }
          checkChoice = true;
          break;
        case 9:
          System.out.println("You chose 'QUIT'"); //Hvis bruger har skrevet 9 vil den sige dette
          checkChoice = true;
          break;

        default: // alt andet er forkert input
          System.out.println("\nIt has to be between 1,2,3 or 9");
          System.out.println("Try again");
          menu.printMenu(); //så skal den printe menuen igen
          choice = menu.readChoice(); //så skal den køre denne metode igen
          checkChoice = false; // her er den så false fordi så betyder det man har tastet et andet integer end 1,2,3 eller 9.
      }
    } while (!checkChoice); //Den skal blive ved med at loop så længe den er false altså en integer som ikke er 1,2,3 eller 9
  }
}
