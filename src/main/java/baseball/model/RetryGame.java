package baseball.model;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class RetryGame {
  public boolean retryGame() {
    OutputView.printGameSetMessage();
    OutputView.printRetryMessage();

    char answer = InputView.setRetryNumber().charAt(0);

    if(answer == '1') {
      return true;
    }

    return false;
  }
}
