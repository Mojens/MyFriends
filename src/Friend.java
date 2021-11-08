import java.io.*;
import java.util.Scanner;

public class Friend {

  private static int friendNumberCounter = 0;

  private String name;
  private String phone;
  private String eMail;
  private final String fileName;
  private int friendNumber;


  public Friend(String name, String phone, String eMail) {
    this.name = name;
    this.phone = phone;
    this.eMail = eMail;
    this.friendNumber = friendNumberCounter++;
    fileName = "ListOfFriends.txt";
  } //Konstruktør med parmetre

  public Friend() {

    fileName = "ListOfFriends.txt";
  } //Uden parmetre

  public String toString() {
    return "\nFriend index: " +friendNumber+ "\n" + "Name: " + name + "\n" +
        "Phone: " + phone + "\n" +
        "E-Mail: " + eMail + "\n";
  } //toString metode

  public void setPhone(String phone) {
    this.phone = phone;
  } //Setters og getters

  public void setName(String name) {
    this.name = name;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public String getName() {
    return name;
  }

  public String geteMail() {
    return eMail;
  }

  public String getPhone() {
    return phone;
  }

  public void showList() {
    System.out.println("-----------------------------------\n");
    System.out.println(Main.friendList);
    System.out.println("\n-----------------------------------\n");
    new Main().menuRun();
  } //Denne viser din nuværende ArrayListe

  public void enterNewFriend() {
    Scanner input = new Scanner(System.in);
    System.out.println("-----------------------------------\n");
    System.out.print("Type the name: ");
    setName(input.nextLine());
    System.out.print("Type the phonenumber: ");
    setPhone(input.nextLine());
    System.out.print("Type the E-Mail: ");
    seteMail(input.nextLine());
    Friend friend = new Friend(this.name, this.phone, this.eMail);
    Main.friendList.add(friend);

    System.out.println("\nYou have entered: ");
    System.out.println("name: " + getName());
    System.out.println("phonenumber: " + getPhone());
    System.out.println("E-Mail: " + geteMail());
    System.out.println("\n-----------------------------------\n");
    new Main().menuRun();
  } //Den her tilføjer kun Friend objektet til ArrayListen

  public void deleteFriend() {
    Scanner input = new Scanner(System.in);
    System.out.println("\n-----------------------------------\n");
    System.out.println("Every friend has a index number!");
    System.out.println("Which friend do you want to delete?");
    System.out.print("Type the index: ");
    int index = input.nextInt();
    Main.friendList.remove(index);
    System.out.println("Friend " + " Its now deleted!");
    System.out.println("\n-----------------------------------\n");
    for (Friend friend : Main.friendList) {
      if (friendNumber!=0) {
        friendNumber--;
      }
    }
    new Main().menuRun();
  } //Den her sletter fra nuværende Session / ArrayListe

  public void saveList() throws IOException {
    PrintStream pr = new PrintStream(new File(fileName));
    for (Friend friend : Main.friendList){
      pr.println(Main.friendList.toString());
    }
    /*try (FileWriter fw = new FileWriter("ListOfFriends.txt", true); //Bruger FileWriter da jeg skal
         // Appende indholdet over til min fil uden at slette det forrige informationer
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
      out.println(Main.friendList);
    } catch (IOException e) {
      //exception handling left as an exercise for the reader
    }
    new Main().menuRun();

     */
    new Main().menuRun();
  } //Den her gemmer indholdet af Arraylisten ind i filen "ListOfFriends.txt"

  public void loadList() throws IOException {
    File fr = new File(fileName);
    Scanner scan = new Scanner(fr);
    while (scan.hasNextLine()) {
      String lines = scan.nextLine();
      System.out.println(lines);
    }
    new Main().menuRun();
  } //Denne indlæser din filer og viser hvad for nogle værdier du har gemt
}




