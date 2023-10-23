package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> values;

    public Numbers(List<Integer> values) {
        this.values = values;
    }

    public GameResult calculateResult(Numbers other) {
        int strikeCount = countStrikes(other);
        int ballCount = countBalls(other, strikeCount);
        return new GameResult(ballCount, strikeCount);
    }

    private int countStrikes(Numbers other) {
        return (int) IntStream.range(0, this.values.size())
                .filter(i -> this.values.get(i).equals(other.values.get(i)))
                .count();
    }

    private int countBalls(Numbers other, int strikeCount) {
        long totalMatchedValues = other.values.stream()
                .filter(this.values::contains)
                .count();
        return (int) totalMatchedValues - strikeCount;
    }
}
