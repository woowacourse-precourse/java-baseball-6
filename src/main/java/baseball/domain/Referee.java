package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Referee {
    private Referee() {
    }

    public static RoundResult judge(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        final int strikeCount = calculateStrikeCount(computerBaseballs, userBaseballs);
        return null;
    }

    private static int calculateStrikeCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        return (int) IntStream.range(0, Baseball.TOTAL_COUNT)
                .filter(index -> isExactlyMatch(computerBaseballs, userBaseballs, index))
                .count();
    }

    private static boolean isExactlyMatch(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs,
            final int index
    ) {
        return computerBaseballs.get(index).equals(userBaseballs.get(index));
    }
}
