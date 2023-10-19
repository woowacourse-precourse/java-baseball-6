package baseball;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.view.InputView;

import java.util.List;

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
