package baseball.view;

import baseball.model.PlayNumber;

public interface InputView {

    PlayNumber readPlayNumber();
    int readMoreAnswer();
}
