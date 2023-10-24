package baseball.controller;

import baseball.service.BaseballService;
import baseball.utils.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Score;
import java.util.List;

public class BaseBallController {

    private final BaseballService baseballService;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(BaseballService baseballService, InputView inputView, OutputView outputView) {
        this.baseballService = baseballService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStartMessage();
        do {
            playGame();
            outputView.printGameOver();
            outputView.printGameRestartMessage();
        } while (inputView.inputRestartOption());
    }

    private void playGame() {
        List<Integer> computerNumbers = NumberGenerator.createComputerNumbers();
        boolean isGameOvered;
        do {
            outputView.printUserInputMessage();
            String inputUserNumbers = inputView.inputUserNumber();
            Score score = baseballService.calculateGameScore(inputUserNumbers, computerNumbers);
            outputView.printScore(score);
            isGameOvered = !score.isAnswer();
        } while (isGameOvered);
    }
}
