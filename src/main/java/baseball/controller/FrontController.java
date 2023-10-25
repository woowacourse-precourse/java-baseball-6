package baseball.controller;

import static baseball.domain.Score.THREE_STRIKE;

import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class FrontController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseBallGameController controller;

    public FrontController(InputView inputView, OutputView outputView, BaseBallGameController controller) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controller = controller;
    }

    public List<Integer> createAnswerNumber() {
        return controller.createAnswerNumber();
    }

    public Score gameStart(List<Integer> answerNumbers) {
        Score gameResult;

        do {
            List<Integer> tryNumbers = inputView.inputTryNumber();
            gameResult = controller.competeWith(tryNumbers, answerNumbers);
            outputView.printGameResult(gameResult.getName());
        } while (notThreeStrike(gameResult));
        return gameResult;
    }

    private boolean notThreeStrike(Score gameResult) {
        return gameResult != THREE_STRIKE;
    }
}
