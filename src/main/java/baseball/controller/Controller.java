package baseball.controller;

import baseball.domain.ContinueAnswer;
import baseball.domain.Result;
import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Service service = new Service();

    public void run() {
        while (true) {
            outputView.startMention();
            service.initComputer();
            gamePlay();
            outputView.gameOverMention();
            if (!willContinue()) break;
        }
    }

    private void gamePlay() {
        Result result;
        do {
            String inputtedNumbers = inputView.inputNumbers();
            result = service.calculateResult(inputtedNumbers);
            outputView.printResult(result);
        } while (!result.isAllStrike());
    }

    private boolean willContinue() {
        String answerString = inputView.inputIfContinue();
        ContinueAnswer continueAnswer = service.generateContinueAnswer(answerString);
        return continueAnswer.ifContinue();
    }
}