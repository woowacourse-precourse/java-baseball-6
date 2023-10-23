package baseball.model.rule;

import java.util.stream.IntStream;

public class StrikeRule implements GameRule {

    @Override
    public int calculate(final String computerNumber, final String userNumber) {
        String[] computerValues = computerNumber.split("");
        String[] userValues = userNumber.split("");

        return (int) IntStream.range(0, computerValues.length)
                .filter(i -> computerValues[i].equals(userValues[i]))
                .count();
    }
}
