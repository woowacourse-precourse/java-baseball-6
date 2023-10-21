package baseball.controller;

import baseball.view.OutputView;
import java.util.List;

public class BaseBallController {
    private int ballCount;
    private int strikeCount;
    private boolean is3strike;
    private List<Integer> answerNumbers;

    private static final OutputView outputView = new OutputView();

    private void InitGame() {
        this.ballCount = 0;
        this.strikeCount = 0;
        is3strike = false;

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        answerNumbers = randomNumberGenerator.GenerateRandomNumber();
    }

    public void startBaseBallGame() {
        outputView.printGameStartMessage();
        runGame();
    }
    
}
