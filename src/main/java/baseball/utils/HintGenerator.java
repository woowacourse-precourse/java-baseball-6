package baseball.utils;

import static baseball.constants.DigitConstants.INITIAL_INDEX;
import static baseball.constants.DigitConstants.LAST_INDEX;

import baseball.model.Hint;
import baseball.model.Numbers;
import java.util.stream.IntStream;

public class HintGenerator {
    public static Hint generate(Numbers computer, Numbers player) {
        return Hint.from(countStrike(computer, player), countBall(computer, player));
    }

    private static Integer countStrike(Numbers computer, Numbers player) {
        return (int) IntStream.range(INITIAL_INDEX, LAST_INDEX)
                .filter(index -> computer.equalsAt(player.valueAt(index), index))
                .count();
    }

    private static Integer countBall(Numbers computer, Numbers player) {
        return (int) IntStream.range(INITIAL_INDEX, LAST_INDEX)
                .filter(index -> (!computer.equalsAt(player.valueAt(index), index)
                        && computer.contains(player.valueAt(index))))
                .count();
    }
}
