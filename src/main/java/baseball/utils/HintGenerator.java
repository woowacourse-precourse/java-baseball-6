package baseball.utils;

import baseball.model.Hint;
import baseball.model.Numbers;
import java.util.stream.IntStream;

public class HintGenerator {

    private static final int INITIAL_INDEX = 0;
    private static final int LAST_INDEX = 3;

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
                .filter(index ->
                        !computer.equalsAt(player.valueAt(index), index)
                                && computer.contains(player.valueAt(index)))
                .count();
    }
}
