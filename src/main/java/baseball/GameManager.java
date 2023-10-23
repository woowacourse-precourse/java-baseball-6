package baseball;

import baseball.view.OutputView;
import java.util.List;

public class GameManager {
    private BaseBalls generatedNumber;
    private final BallScore BALL = BallScore.BALL;
    private final BallScore STRIKE = BallScore.STRIKE;

    public GameManager() {
        OutputView.printStartMessage();
        generatedNumber = new BaseBalls(new BallNumberGenerator().generateBallNumber());
    }

}
