package baseball.controller;

    import baseball.application.NumberGenerator;
import baseball.domain.GameResult;
import baseball.domain.Numbers;
import baseball.view.InputView;

public class BaseballGame {

    private final NumberGenerator numberGenerator;

    public void gameStart() {
        Numbers numbers = InputView.readUserNumbers();

        Numbers otherNumbers = numberGenerator.generateNumbers();

        GameResult gameResult = numbers.compareWith(otherNumbers);
    }

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
