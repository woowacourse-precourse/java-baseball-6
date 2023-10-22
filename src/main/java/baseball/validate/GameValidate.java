package baseball.validate;

import baseball.model.rule.BaseBallGameRule;
import java.util.List;
import java.util.Objects;

public class GameValidate extends BaseBallGameRule {
    public void checkGameRestartInput(Integer number) {
        if (Objects.equals(number, BASEBALL_GAME_RESTART)) {
            return;
        }
        if (Objects.equals(number, BASEBALL_GAME_FINISH)) {
            return;
        }
        throw new RuntimeException();
    }

    public void checkPlayerGuessNumbers(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_MAX_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] : Wrong Size ");
        }
        for (Integer number : numbers) {
            if (number <= BASEBALL_MIN_VALUE || number >= BASEBALL_MAX_VALUE) {
                throw new RuntimeException("[ERROR] : Wrong Number Range ");
            }
        }
    }
}
