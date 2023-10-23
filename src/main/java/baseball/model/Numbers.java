package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> values;

    public Numbers(List<Integer> values) {
        this.values = values;
    }

    public int countStrike(Numbers other) {
        return (int) IntStream.range(0, this.values.size())
                .filter(i -> this.values.get(i).equals(other.values.get(i)))
                .count();
    }

    public int countBall(Numbers other) {
        int totalMatch = (int) other.values.stream()
                .filter(this.values::contains)
                .count();
        return totalMatch - countStrike(other);
    }
}
