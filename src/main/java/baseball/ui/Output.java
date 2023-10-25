package baseball.ui;

import baseball.model.BallCounter;

public interface Output {

    void print(Message message);

    void print(BallCounter message);
}
