package baseball.ui;

import baseball.result.BallCountResult;

public interface PrintResultMessage extends PrintMessage {

  void print(BallCountResult ballCountResult);

}
