package baseball.controller;

import baseball.domain.BallNumbers;
import baseball.domain.GameResult;
import baseball.domain.RandomBallNumberGenerator;
import baseball.view.OutputView;

import static baseball.util.NumberConst.THREE_STRIKE;

public class GameController {
    private final OutputView outputView;
    private final InputFormatter inputFormatter;
    private final RandomBallNumberGenerator randomBallNumberGenerator;

    public GameController(OutputView outputView, InputFormatter inputFormatter, RandomBallNumberGenerator randomBallNumberGenerator) {
        this.outputView = outputView;
        this.inputFormatter = inputFormatter;
        this.randomBallNumberGenerator = randomBallNumberGenerator;
    }

    public void start() {
        start(true);
    }

    public void start(boolean isFreshStart) {
        printStartMsgIfFreshStart(isFreshStart);
        BallNumbers answerBallNumbers = randomBallNumberGenerator.generateAnswerNumbers();
        compareNumbers(answerBallNumbers);
        restartOrNot();
    }

    private void restartOrNot() {
        if (inputFormatter.wantRestart()) {
            start(false);
        }
    }

    private void printStartMsgIfFreshStart(boolean isFreshStart) {
        if (isFreshStart) {
            outputView.printGameStartMsg();
        }
    }

    private void compareNumbers(BallNumbers answerBallNumbers) {
        while (true) {
            BallNumbers userBallNumbers = getUserBallNumbers();
            GameResult gameResult = GameResult.of(answerBallNumbers, userBallNumbers);
            outputView.printGameResult(gameResult);
            if (gameResult.getStrikeCount() == THREE_STRIKE) {
                outputView.printGameOverMsg();
                break;
            }
        }
    }

    public BallNumbers getUserBallNumbers() {
        outputView.inputNumberMsg();
        return inputFormatter.createUserBallNumbers();
    }
}
