package baseball.game.computer;

import java.util.List;
import java.util.Objects;

public class Computer {

    public GameResult compute(final List<Integer> targetNumbers, final List<Integer> numbers) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (Objects.equals(targetNumbers.get(i), numbers.get(i))) {
                strikeCount++;
            } else if (targetNumbers.contains(numbers.get(i))) {
                ballCount++;
            }
        }

        return new GameResult(ballCount, strikeCount);
    }
}
