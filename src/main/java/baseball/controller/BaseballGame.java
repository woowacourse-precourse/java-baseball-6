package baseball.controller;

import baseball.application.NumberGenerator;
import baseball.domain.GameResult;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

    private final NumberGenerator numberGenerator;

    public void gameStart() {
        do {
            Numbers otherNumbers = numberGenerator.generateNumbers();

            playRound(otherNumbers);
        }
        while (checkRestart());
    }

    private static void playRound(Numbers otherNumbers) {
        while (true) {
            Numbers numbers = InputView.readUserNumbers();

            GameResult gameResult = numbers.compareWith(otherNumbers);

            ResultView.showResult(gameResult);

            if (gameResult.isStrikeOut()) {
                break;
            }
        }
    }

    private boolean checkRestart() {
        return InputView.readContinueOrExit();
    }

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
