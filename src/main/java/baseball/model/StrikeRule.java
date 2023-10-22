package baseball.model;

import java.util.stream.IntStream;

public class StrikeRule implements GameRule {

    @Override
    public int calculate(final int hitter, final int pitcher) {
        String hitterValue = String.valueOf(hitter);
        String pitcherValue = String.valueOf(pitcher);

        String[] hitterNumbers = hitterValue.split("");
        String[] pitcherNumbers = pitcherValue.split("");

        return (int) IntStream.range(0, hitterNumbers.length)
                .filter(i -> hitterNumbers[i].equals(pitcherNumbers[i]))
                .count();
    }
}
