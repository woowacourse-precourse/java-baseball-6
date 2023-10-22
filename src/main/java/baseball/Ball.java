package baseball;

import java.util.List;

public class Ball {
    Integer value;
    public Ball(String ball) {
        this.value = Integer.parseInt(ball);
    }

    public Ball(List<Integer> numbers) {
        value = 0;
        for (Integer number : numbers) {
            value += number;
            value *= 10;
        }
        value /= 10;
    }

    public int getMatchCount(final int number) {
        int matched = 0;
        int ballValue = value;

        while (ballValue > 0) {
            if (ballValue % 10 == number) {
                matched++;
            }
            ballValue /= 10;
        }
        return matched;
    }
}
