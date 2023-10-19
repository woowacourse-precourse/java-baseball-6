package baseball.controller;

import baseball.domain.GameResult;
import baseball.application.NumberGenerator;
import baseball.domain.Numbers;
import baseball.view.InputView;

public class BaseballGame {

    private final NumberGenerator numberGenerator;

    public void gameStart() {
        Numbers numbers = InputView.readUserNumbers();

        Numbers otherNumbers = numberGenerator.generateNumbers();

        GameResult gameResult = new GameResult();

    }

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
