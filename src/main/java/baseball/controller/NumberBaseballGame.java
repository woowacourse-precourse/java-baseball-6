package baseball.controller;

import baseball.model.*;
import baseball.util.DiffNumber;

import baseball.view.OutputView;
import java.util.List;

public class NumberBaseballGame {
  public void playGame() {
    ComputerNum computer = new ComputerNum();
    UserNum user = new UserNum();
    DiffNumber compare = new DiffNumber();
    RetryGame retry = new RetryGame();

    boolean restartGame = true;

    while(restartGame) {
      List<Integer> computerNumber = computer.ComputerNumber();

      String result = "";

      while(!result.equals("3스트라이크")) {
        result = compare.strikeAndBallCount(computerNumber, user.userNum());
        OutputView.printResult(result);
      }

      restartGame = retry.retryGame();
    }
  }
}
