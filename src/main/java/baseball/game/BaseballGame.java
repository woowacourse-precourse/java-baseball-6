package baseball.game;

import baseball.domain.BallHint;
import baseball.domain.BallInput;
import baseball.domain.RandomNumber;

public class BaseballGame {
    private final RandomNumber randomNumber;
    private final BallHint ballHint;
    private final BallInput ballInput;

    public BaseballGame() {
        this.randomNumber = new RandomNumber();
        this.ballHint = new BallHint();
        this.ballInput = new BallInput();
    }

}
