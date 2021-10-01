package System.GameHandler;

import UI.UI;
import System.Choices;

/*
  Klassen skulle have været delt ud blandt andre klasser, men der var ikke tid til det, da der er prioteret anderledes.
  Metoder skulle også kåges ned, og deles ud.
 */

public class Game {

  //Computer settings
  private Player computerPlayer;
  private int computerPoints;
  private String computerChoice;
  private final String COMPUTER_COLOR = "purple";

  //Human settings
  private Player humanPlayer;
  private int humanPoints;
  private String humanChoice;
  private final String HUMAN_COLOR = "blue";

  //Other settings
  private Menu gameMenu;
  private int currentRound;
  private int bestOf;

  private UI ui;

  public Game(Player humanPlayer, Player computerPlayer, UI ui) {
    this.humanPlayer = new Human(ui);
    this.computerPlayer = new Computer();
    this.ui = ui;
  }

  public void run() {
    String[] menuChoices = {"Play", "Quit"};
    Menu menu = new Menu("Stone Paper Scissor", "Choice a menu number: ", menuChoices, ui);

    //TODO Use the menus readChoice method. Find a way
    String[] gameMenuChoices = {Choices.Rock.toString(), Choices.Paper.toString(), Choices.Scissor.toString()};
    gameMenu = new Menu("Weapon Menu", "Choose your weapon: ", gameMenuChoices, ui);

    boolean isRunning = true;

    while (isRunning) {
      menu.printMenu();

      switch (menu.readChoice()) {
        case 1 -> play();
        case 2 -> {
          ui.displayStringLine("Exiting...");
          isRunning = false;
        }
      }
    }
  }

  public void play() {
    humanPoints = 0;
    computerPoints = 0;

    bestOf = ui.getIntWMessage("Best of: ");
    final int ROUND_BREAK_FORMULA = ((bestOf / 2) + 1);
    boolean isRoundValid = true;

    for (int i = 0; i < bestOf && isRoundValid; i++) {
      currentRound = ((i) + 1);

      if (ROUND_BREAK_FORMULA == humanPoints || ROUND_BREAK_FORMULA == computerPoints) {
        isRoundValid = false;
      } else {
        findRoundWinner();
      }

    }

    displayFinalWinner();
  }

  public void playerChoices() {
    gameMenu.printMenu();

    humanChoice = humanPlayer.takeTurn();
    computerChoice = computerPlayer.takeTurn();

    displayChoices();

    ui.displayStringNoLine("Round counter: ");
    ui.displayStringLine("(" + currentRound + "/" + bestOf + ")");
  }

  public void displayChoices() {

    //Human color settings
    String choiceColorHuman = ui.getStringColor(HUMAN_COLOR, humanChoice);
    String colorHumanName = ui.getStringColor(HUMAN_COLOR, "Human");

    //Computer color settings
    String choiceColorHComputer = ui.getStringColor(COMPUTER_COLOR, computerChoice);
    String colorComputerName = ui.getStringColor(COMPUTER_COLOR, "Computer");

    ui.displayStringLine();
    ui.displayStringLine(colorHumanName + " Choice: " + choiceColorHuman);
    ui.displayStringLine(colorComputerName + " Choice: " + choiceColorHComputer);
  }

  public void findRoundWinner() {
    playerChoices();

    if (humanChoice.equals(computerChoice)) {

      ui.displayStringColor("yellow", "It's a draw, try again");
      findRoundWinner();

    } else if (checkWinner(humanChoice, computerChoice)) {

      humanPoints++;
      ui.displayStringColorDesign("green", "You won this round!");

    } else {

      computerPoints++;
      ui.displayStringColorDesign("red", "You lost this round!");

    }
  }

  public boolean checkWinner(String choiceHuman, String choiceComputer) {

    boolean rockBeatsScissor = choiceHuman.equals(Choices.Rock.toString()) && choiceComputer.equals(Choices.Scissor.toString());
    boolean scissorBeatsPaper = choiceHuman.equals(Choices.Scissor.toString()) && choiceComputer.equals(Choices.Paper.toString());
    boolean paperBeatsRock = choiceHuman.equals(Choices.Paper.toString()) && choiceComputer.equals(Choices.Rock.toString());

    if ((rockBeatsScissor) || (scissorBeatsPaper) || (paperBeatsRock)) {
      return true;
    }
    return false;
  }

  public void displayFinalWinner() {
    String result = "";
    String color = "";

    if (humanPoints > computerPoints) {
      result = "Human";
      color = HUMAN_COLOR;
    } else if (humanPoints < computerPoints) {
      result = "Computer";
      color = COMPUTER_COLOR;
    }

    ui.displayStringColor("cyan", "The winner is");
    ui.displayStringColorDesign(color, result);
  }


}
