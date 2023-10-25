package baseball.model;

import baseball.view.InputView;
import baseball.view.OutputView;

public class RetryGame {
  public boolean retryGame() {
    OutputView.printGameSetMessage();
    OutputView.printRetryMessage();

    char answer = InputView.setRetryNumber().charAt(0);

    return answer == '1';
  }
}
