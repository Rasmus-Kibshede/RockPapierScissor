package UI;

import java.util.Scanner;

public class UI {
  private final Scanner SCAN = new Scanner(System.in);
  private final Helping HELPING = new Helping(SCAN);

  public int getInt() {
    int i = SCAN.nextInt();
    SCAN.nextLine();
    return i;
  }

  public int getIntWMessage(String message) {
    System.out.print(message);
    return SCAN.nextInt();
  }

  public void displayStringLine() {
    System.out.println();
  }

  public void displayStringLine(String message) {
    System.out.println(message);
  }

  public void displayStringNoLine(String message) {
    System.out.print(message);
  }

  public void displayStringColor(String color, String message) {
    System.out.println(HELPING.colorText(color, message));
  }

  public String getStringColor(String color, String message){
    return HELPING.colorText(color, message);
  }

  public void displayStringColorDesign(String color, String message){
    displayStringColor(color, message);
    displayStringLine();
    displayStringLine("----------------------------------");
  }

  public boolean hasNextInt(){
    return SCAN.hasNextInt();
  }

  public void nextLine(){
    SCAN.nextLine();
  }
}
