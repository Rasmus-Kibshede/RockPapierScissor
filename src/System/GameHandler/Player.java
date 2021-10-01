package System.GameHandler;

import System.Choices;

public interface Player {

  Choices[] choices = Choices.values();

  String takeTurn();
}
