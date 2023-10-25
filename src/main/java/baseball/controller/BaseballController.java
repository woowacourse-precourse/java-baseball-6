package baseball.controller;

import static baseball.domain.Restart.RESTART;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballReferee;
import baseball.domain.Hint;
import baseball.domain.HintResult;
import baseball.domain.RandomNumberFactory;
import baseball.domain.Restart;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {

    private final RandomNumberFactory randomNumberFactory;
    private final BaseballReferee baseballReferee;

    public BaseballController(RandomNumberFactory randomNumberFactory, BaseballReferee baseballReferee) {
        this.randomNumberFactory = randomNumberFactory;
        this.baseballReferee = baseballReferee;
    }

    public void run() {
        OutputView.startMessage();
        start();
    }

    private void start() {
        BaseballNumber computerNumbers = randomNumberFactory.generate();
        while (true) {
            BaseballNumber playerNumbers = generatePlayerNumbers();
            Hint hint = baseballReferee.compare(computerNumbers, playerNumbers);
            HintResult hintResult = new HintResult(hint);
            OutputView.printHint(hintResult);
            if (hint.isThreeStrike()) {
                OutputView.printGameOver();
                break;
            }
        }
        restartGame();
    }

    private BaseballNumber generatePlayerNumbers() {
        List<Integer> playerInputNumbers = InputView.readPlayerNumber();
        return new BaseballNumber(playerInputNumbers);
    }

    private void restartGame() {
        int gameCommand = InputView.readPlayerRestart();
        Restart restart = Restart.from(gameCommand);
        if (restart.equals(RESTART)) {
            start();
        }
    }
}
