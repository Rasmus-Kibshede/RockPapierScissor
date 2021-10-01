package System;

import System.GameHandler.Computer;
import System.GameHandler.Game;
import System.GameHandler.Human;
import UI.UI;

public class Main {
  public static void main(String[] args) {
    UI ui = new UI();
    new Game(new Human(ui), new Computer(), ui).run();
  }
}
