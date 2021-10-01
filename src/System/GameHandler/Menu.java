package System.GameHandler;

import UI.UI;

public class Menu {

  private final String menuHeader;
  private final String menuLeadText;
  private final String[] menuItems;
  private final UI ui;

  public Menu(String menuHeader, String menuLeadText, String[] menuItems, UI ui) {
    this.menuHeader = menuHeader;
    this.menuLeadText = menuLeadText;
    this.menuItems = menuItems;
    this.ui = ui;
  }

  public void printMenu() {
    StringBuilder menuitemText = new StringBuilder();
    for (int i = 0; i < menuItems.length; i++) {
      String item = menuItems[i];
      menuitemText.append((i) + 1).append(". ").append(item).append("\n");
    }
    ui.displayStringNoLine("\n" + menuHeader + "\n" + menuitemText + "\n" + menuLeadText);
  }


  //TODO recode this method. if it's not a int, then display error and show menu options again
  public int readChoice() {
    boolean validChoice = false;
    int choice = -1;
    while (!validChoice) {

      //Checks if the choice is an integer
      if (ui.hasNextInt()) {
        choice = ui.getInt();
        ui.displayStringLine();

        //Checks if there is a menu item equals to the choice
        if (choice > 0 && choice <= menuItems.length) {
          validChoice = true;
        }else {
          ui.displayStringLine("Enter a valid menu choice");
        }
      } else {
        ui.nextLine();
      }
    }
    return choice;
  }
}
