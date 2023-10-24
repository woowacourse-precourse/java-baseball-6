package baseball.controller;

import baseball.domain.model.BaseballNumber;
import baseball.domain.service.NumberBaseBallGame;
import baseball.domain.service.RoundEvaluationResult;
import baseball.view.NumberBaseballGameInputView;
import baseball.view.NumberBaseballGameOutputView;

public class NumberBaseballGameController {

    private final NumberBaseballGameInputView inputView;
    private final NumberBaseballGameOutputView outputView;
    private final NumberBaseBallGame numberBaseBallGame;

    public NumberBaseballGameController(NumberBaseballGameInputView inputView, NumberBaseballGameOutputView outputView,
                                        NumberBaseBallGame numberBaseballgame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberBaseBallGame = numberBaseballgame;
    }

    public void playGame() {
        outputView.printStartGameMessage();
        RoundEvaluationResult result;
        do {
            result = playRound();
            if (result.isgameOver()) {
                handleGameOver(result);
            }
        } while (!result.isExit());
    }

    private RoundEvaluationResult playRound() {
        outputView.printNumberInputRequest();
        BaseballNumber baseballNumber = inputView.readUserInput();
        RoundEvaluationResult result = numberBaseBallGame.evaluateRound(baseballNumber);
        outputView.printScoreSummary(result.getEvaluationMessage());
        return result;
    }

    private void handleGameOver(RoundEvaluationResult result) {
        outputView.printGameOverMessage();
        result.eveluateRestart(inputView.readRestartResponseInput());
        numberBaseBallGame.initRandomNumber();
    }
}
