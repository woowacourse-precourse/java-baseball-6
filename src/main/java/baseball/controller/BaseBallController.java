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
        List<Integer> computerNumbers = NumberGenerator.createComputerNumbers();
        while (true) {
            outputView.printUserInputMessage();
            String inputUserNumbers = inputView.inputUserNumber();
            Score score = baseballService.calculateGameScore(inputUserNumbers, computerNumbers);
            outputView.printScore(score);
            if (score.isAnswer()) {
                outputView.printGameOver();
                outputView.printGameRestartMessage();
                String restartOption = inputView.inputRestartOption();
                if (restartOption.equals("1")) {
                    computerNumbers = NumberGenerator.createComputerNumbers();
                    continue;
                }
                if (restartOption.equals("2")) {
                    break;
                }
            }
        }
    }
}
