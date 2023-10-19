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
        final int ballCount = calculateBallCount(computerBaseballs, userBaseballs, strikeCount);

        return new RoundResult(strikeCount, ballCount);
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

    private static int calculateBallCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs,
            final int strikeCount
    ) {
        return getContainedElementsCount(computerBaseballs, userBaseballs) - strikeCount;
    }

    private static int getContainedElementsCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        return (int) userBaseballs.stream()
                .filter(computerBaseballs::contains)
                .count();
    }
}
