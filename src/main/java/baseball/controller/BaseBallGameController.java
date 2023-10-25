package baseball.controller;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.domain.BaseBallGame;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallGameController {

    private final InputView inputView;
    private final BaseBallGame baseBallGame;
    private final OutputView outputView;

    public BaseBallGameController(InputView inputView, BaseBallGame baseBallGame, OutputView outputView) {
        this.inputView = inputView;
        this.baseBallGame = baseBallGame;
        this.outputView = outputView;
    }

    public Score competeWith(List<Integer> answerNumbers) {
        Score gameResult;
        do {
            List<Integer> tryNumbers = inputView.inputTryNumber();
            gameResult = baseBallGame.createGameResult(tryNumbers, answerNumbers);
            outputView.printGameResult(gameResult.getName());
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(Score gameResult) {
        return gameResult != THREE_STRIKE;
    }
}
