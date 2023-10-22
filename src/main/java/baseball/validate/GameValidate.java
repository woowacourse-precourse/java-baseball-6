package baseball.validate;

import baseball.model.rule.BaseBallGameRule;
import java.util.List;
import java.util.Objects;

public class GameValidate extends BaseBallGameRule {
    public void checkGameRestartInput(Integer playerNumber) {
        if (Objects.equals(playerNumber, BASEBALL_GAME_RESTART)) {
            return;
        }
        if (Objects.equals(playerNumber, BASEBALL_GAME_FINISH)) {
            return;
        }
        throw new RuntimeException();
    }

    public void checkPlayerGuessNumbers(List<Integer> playerNumbers) {
        if (playerNumbers.size() != BASEBALL_MAX_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] : Wrong Size ");
        }
        for (Integer number : playerNumbers) {
            if (number < BASEBALL_MIN_VALUE || number > BASEBALL_MAX_VALUE) {
                throw new RuntimeException("[ERROR] : Wrong Number Range ");
            }
        }
    }
}
