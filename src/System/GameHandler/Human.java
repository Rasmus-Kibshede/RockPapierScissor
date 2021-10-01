package System.GameHandler;

import UI.UI;

public class Human implements Player {

  private UI ui;

  public Human(UI ui) {
    this.ui = ui;
  }

  @Override
  public String takeTurn() {
    final int CHOICE = (ui.getInt()-1);
    return choices[CHOICE].toString();
  }
}
