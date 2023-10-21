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
        outputView.startMention();
        service.initComputer();
        Result result = null;
        do {
            String inputtedNumbers = inputView.inputNumbers();
            result = service.calculateResult(inputtedNumbers);
            outputView.printResult(result);
        } while (!result.isAllStrike());
        outputView.gameOverMention();
        willContinue();
    }

    private void willContinue() {
        String answerString = inputView.inputIfContinue();
        ContinueAnswer continueAnswer = service.generateContinueAnswer(answerString);
        if (continueAnswer.ifContinue()) {
            run();
        }
    }
}
