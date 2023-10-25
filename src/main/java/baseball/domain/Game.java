package baseball.domain;

import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;
import baseball.utils.Constants;

public class Game {

  public void gameStart() {
    boolean isGameEnd = false;

    OutputHandler.printGameStartMessage();

    Number computer = new Number();
    Number player = new Number();
    computer.generateComputerNumbers();

    while (!isGameEnd) {
      OutputHandler.printNumberInputMessage();
      player.changePlayerNumbers(InputHandler.inputGuessNumbers());
      isGameEnd = computer.compareWithPlayerNumbers(player.getNumbers());
      if (isGameEnd) {
        OutputHandler.printGameEndMessage();
        isGameEnd = gameRestartOrEnd(computer);
      }
    }

  }

  private boolean gameRestartOrEnd(Number computer) {
    String inputNumber = InputHandler.inputExitNumbers();
    if (inputNumber.equals(Constants.GAME_RESTART)) {
      computer.generateComputerNumbers();
      return false;
    }
    return true;
  }
}
