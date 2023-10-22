package baseball.controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.util.NumberConst.THREE_STRIKE;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final RandomBallNumberGenerator randomBallNumberGenerator;

    public GameController(OutputView outputView, InputView inputView, RandomBallNumberGenerator randomBallNumberGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomBallNumberGenerator = randomBallNumberGenerator;
    }

    public void start() {
        start(true);
    }

    public void start(boolean isFreshStart) {
        if (isFreshStart) {
            outputView.printGameStartMsg();
        }
        BallNumbers answerBallNumbers = getAnswerBallNumbers();
        compareNumbers(answerBallNumbers);
        restartOrNot();
    }

    private void restartOrNot() {
        String userChoice = inputView.readLine();
        RestartDTO restartDTO = new RestartDTO(userChoice);
        if (restartDTO.wantRestart()) {
            start(false);
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

    private BallNumbers getAnswerBallNumbers() {
        List<Integer> answerNumberList = randomBallNumberGenerator.generateAnswerNumbers();
        return BallNumbers.from(answerNumberList);
    }

    public BallNumbers getUserBallNumbers() {
        outputView.inputNumberMsg();
        String ballNumbersStr = inputView.readLine();
        BallNumbersDTO ballNumbersDTO = new BallNumbersDTO(ballNumbersStr);
        List<Integer> userBallNumberList = ballNumbersDTO.getNumberList();
        return BallNumbers.from(userBallNumberList);
    }
}
