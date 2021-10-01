package UI;

import java.util.Locale;
import java.util.Scanner;

public class Helping {

  //----------------------------------------- Fields ------------------------------------------
  private final Scanner scan;

  public Helping(Scanner scan) {
    this.scan = scan;
  }

  //----------------------------------------- Colors ------------------------------------------
  public String colorText(String colorIndex, String text) {
    // ANSI codes
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_CYAN = "\u001B[36m";
    // final String ANSI_WHITE = "\u001B[37m";
    // final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";

    String color = switch (convertStringToAllLowerCase(colorIndex)) {
      case "red" -> ANSI_RED;
      case "yellow" -> ANSI_YELLOW;
      case "purple" -> ANSI_PURPLE;
      case "blue" -> ANSI_BLUE;
      case "green" -> ANSI_GREEN;
      case "cyan" -> ANSI_CYAN;
      default -> ANSI_RESET;
    };

    return color + text + ANSI_RESET;
  }

  public String colorText(String colorIndex, int text) {
    // ANSI codes
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_CYAN = "\u001B[36m";
    // final String ANSI_WHITE = "\u001B[37m";
    // final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";

    String color = switch (convertStringToAllLowerCase(colorIndex)) {
      case "red" -> ANSI_RED;
      case "yellow" -> ANSI_YELLOW;
      case "purple" -> ANSI_PURPLE;
      case "blue" -> ANSI_BLUE;
      case "green" -> ANSI_GREEN;
      case "cyan" -> ANSI_CYAN;
      default -> ANSI_RESET;
    };

    return color + text + ANSI_RESET;
  }

  public String colorText(String colorIndex, double text) {
    // ANSI codes
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_CYAN = "\u001B[36m";
    // final String ANSI_WHITE = "\u001B[37m";
    // final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";

    String color = switch (convertStringToAllLowerCase(colorIndex)) {
      case "red" -> ANSI_RED;
      case "yellow" -> ANSI_YELLOW;
      case "purple" -> ANSI_PURPLE;
      case "blue" -> ANSI_BLUE;
      case "green" -> ANSI_GREEN;
      case "cyan" -> ANSI_CYAN;
      default -> ANSI_RESET;
    };

    return color + text + ANSI_RESET;
  }


  //----------------------------------------- Validates ------------------------------------------
  public String validateString() {

    String text = scan.nextLine();

    while (!text.matches("([a-øA-Ø]+)")) {
      System.out.println(colorText("red", "Please enter a letter(s): "));
      text = scan.nextLine();
    }
    return text;
  }

  public int validateInt() {
    while (!scan.hasNextInt()) {
      System.out.print(colorText("red", "Please enter a number(s): "));
      scan.next();
    }
    int test = scan.nextInt();
    scan.nextLine(); // Gør jeg på grund af scanner bug
    return test;
  }


  public boolean isRangeValid(int range1, int range2){

    int choice = validateInt();

    boolean result = range1 <= choice && range2 >= choice;

    if (result){
      return true;
    }else {
      return false;
    }
  }

  public String convertStringToAllLowerCase(String text){
    return text.toLowerCase(Locale.ROOT);
  }

  public boolean booleanConverter(String checkString) {
    if (checkString.contains("yes")) {
      return true;
    } else if (checkString.contains("no")) {
      return false;
    } else {
      return false;
    }
  }

}
