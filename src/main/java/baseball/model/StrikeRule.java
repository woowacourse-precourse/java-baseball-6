package baseball.model;

import java.util.stream.IntStream;

public class StrikeRule implements GameRule {

    @Override
    public int calculate(final int computer, final int user) {
        String computerValue = String.valueOf(computer);
        String userValue = String.valueOf(user);

        String[] computerNumbers = computerValue.split("");
        String[] userNumbers = userValue.split("");

        return (int) IntStream.range(0, computerNumbers.length)
                .filter(i -> computerNumbers[i].equals(userNumbers[i]))
                .count();
    }
}
