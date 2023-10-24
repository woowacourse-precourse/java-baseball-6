package baseball;

import baseball.view.InputView;
import java.util.List;

public class GameController {

    private Balls createAnswerBalls() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        return Balls.of(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getNumbers();
        return Balls.of(numbers);
    }
}