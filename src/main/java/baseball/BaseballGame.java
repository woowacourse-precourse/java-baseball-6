package baseball;

import baseball.view.InputView;

import java.util.List;

public class BaseballGame {

    private final NumberGenerator numberGenerator;

    public void gameStart() {
        List<Integer> numbers = InputView.readUserNumbers();

        List<Integer> otherNumbers = numberGenerator.generateNumbers();

    }

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
