package baseball.controller;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.domain.Score;
import baseball.service.BaseBallGameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallGameController {

    private final InputView inputView;
    private final BaseBallGameService baseBallGameService;
    private final OutputView outputView;

    public BaseBallGameController(InputView inputView, BaseBallGameService baseBallGameService, OutputView outputView) {
        this.inputView = inputView;
        this.baseBallGameService = baseBallGameService;
        this.outputView = outputView;
    }

    public Score competeWith(List<Integer> answerNumbers) {
        Score gameResult;
        do {
            List<Integer> tryNumbers = inputView.inputTryNumber();
            gameResult = baseBallGameService.createGameResult(tryNumbers, answerNumbers);
            outputView.printGameResult(gameResult.getName());
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(Score gameResult) {
        return gameResult != THREE_STRIKE;
    }
}
