package System.GameHandler;

import java.util.Random;

public class Computer implements Player {

  private final Random RANDOM = new Random();

  @Override
  public String takeTurn() {
    final int RANDOM_CHOICE = RANDOM.nextInt(choices.length);
    return choices[RANDOM_CHOICE].toString();
  }
}
