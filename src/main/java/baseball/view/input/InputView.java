package baseball.view.input;

import baseball.model.number.PlayNumber;

public interface InputView {

    PlayNumber readPlayNumber();
    String readMorePlayAnswer();
}
