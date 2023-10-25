package baseball.controller;

import baseball.service.GameService;
import baseball.domain.Result;
import baseball.domain.BallNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

  private static final OutputView outputView = new OutputView();
  private static final InputView inputView = new InputView();
  private final GameService gameService = new GameService();

  public void startGame() {
    boolean isContinue = true;
    while (isContinue) {
      setGame();
      isContinue = playGame();
    }
    outputView.printEndGame();
  }

  public void setGame() {
    gameService.generateComputerNumber();
    outputView.printGameStart();
  }

  public boolean playGame() {
    while (true) {
      try {
        BallNumbers userNumber = inputView.readUserNumber();
        Result result = gameService.compare(userNumber);
        outputView.printResult(result);
        if (gameService.isGameWon(result)) {
          return askPlayAgain();
        }
      } catch (IllegalArgumentException e) {
        OutputView.printErrorMessage(e.getMessage());
        throw e;
      }
    }
  }

  private boolean askPlayAgain() {
    outputView.printGameWon();
    int choice = inputView.readPlayAgainChoice();
    return choice == 1;
  }
}
