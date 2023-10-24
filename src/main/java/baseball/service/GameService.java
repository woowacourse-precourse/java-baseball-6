package baseball.service;

import baseball.domain.Balls;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import java.util.List;

public class GameService {
    public Balls createAnswerBalls() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        return Balls.of(numbers);
    }

    public Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getNumbers();
        return Balls.of(numbers);
    }
}
