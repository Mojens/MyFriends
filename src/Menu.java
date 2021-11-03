import java.util.Scanner;

public class Menu {

  String menuHeader;
  String leadText;
  String[] menuItems;

  public Menu(String menuHeader, String leadText, String[] menuItems) { //Laver konstruktør med de 3 forskellige parametre.
    // Jeg ved det en konstruktør da det en "metode" der hedder det samme som klassen.
    this.menuHeader = menuHeader; // her initialiserer jeg attributterne.
    this.leadText = leadText;// her initialiserer jeg attributterne.
    this.menuItems = menuItems;// her initialiserer jeg attributterne.
  }

  public void printMenu() {
    System.out.println(menuHeader); //Printer menuHeader, som vi ikke ved hvad er endnu
    // men vi laver i MenuTest igennem konstruktøren
    //Da vi nu skal printe en array så vil det være oplagt at lave en for loop med hvor i er som indeks
    for (int i = 0; i < menuItems.length; i++) { //loopen skal kører indtil arrayens
      // længde som vi ikke har sagt hvad er endnu
      if (menuItems[i] != null) { //Hvis det der kommer ud af arrayen med indeks i ikke er null så skal den....
        //Siger null da det er ligesom at sige 0 bare i string sprog
        System.out.print(i + ". ");
        System.out.println(menuItems[i]);
      }
    }
    System.out.print(leadText); //Printer leadtext, som vi ikke ved hvad er endnu men vi laver i MenuTest igennem konstruktøren
  }

  public int readChoice() {
    Scanner input = new Scanner(System.in);
    while (!input.hasNextInt()) { //Hvis inputtet ikke er en int
      System.out.println("\nIt has to be between 1,2,3 or 9"); //Så skal den sige dette
      System.out.println("Try again"); // og dette.
      System.out.println(menuHeader);
      //Det forneden er endelig ligesom den samme som vi lave i printMenu metoden.
      //Man kunne teknisk godt istedet for at skrive alt denne kode igen bare skrive metoden istedet?
      for (int i = 0; i < menuItems.length; i++) { //og lave for loppen for arraysne
        if (menuItems[i] != null) {//DEN SKAL IKKE PRINTE TOMME ARRAYS UD ALTSÅ "NULL"
          System.out.print(i + ". "); //Her er hvad den skal printe hvis alt andet end gyldig integer bliver tastet ind.
          System.out.println(menuItems[i]);
        }
      }
      System.out.print(leadText); //Så skal den printe lead texten igen
      input.nextLine(); //Så kan brugeren taste igen
    }
    return input.nextInt(); //Den returner inputtet når det er en gyldig integer
  }
}
