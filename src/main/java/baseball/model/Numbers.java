package baseball.model;

import baseball.model.numberstrategy.NumberSelectionStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> values;

    private Numbers(List<Integer> values) {
        this.values = values;
    }

    public static Numbers createNumbersFrom(NumberSelectionStrategy numberSelectionStrategy) {
        return new Numbers(numberSelectionStrategy.createNumbers());
    }

    public GameResult calculateResult(Numbers other) {
        int strikeCount = countStrikes(other);
        int ballCount = countTotalMatches(other) - strikeCount;
        return new GameResult(ballCount, strikeCount);
    }

    private int countStrikes(Numbers other) {
        return (int) IntStream.range(0, values.size())
                .filter(i -> getValueAt(i).equals(other.getValueAt(i)))
                .count();
    }

    private int countTotalMatches(Numbers other) {
        return (int) this.values.stream()
                .filter(other::contains)
                .count();
    }

    public Integer getValueAt(int index) {
        return values.get(index);
    }

    public boolean contains(Integer value) {
        return values.contains(value);
    }
}
