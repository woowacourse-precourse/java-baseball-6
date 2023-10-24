package baseball.domain.game;

import baseball.domain.ball.Balls;
import baseball.domain.result.Result;

public interface GameOperator {
    Balls batting();

    void round(Result result);

    boolean isContinue();
}
