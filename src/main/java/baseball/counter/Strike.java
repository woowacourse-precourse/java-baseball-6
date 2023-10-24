package baseball.counter;

import java.util.stream.IntStream;

public class Strike {
    public static int countStrike(String answer, String input) {
        return IntStream.range(0, 3).map(i -> answer.charAt(i) == input.charAt(i) ? 1 : 0).sum();
    }
}
