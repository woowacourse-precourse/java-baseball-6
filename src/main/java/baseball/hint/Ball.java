package baseball.hint;

import java.util.List;

import static java.util.stream.IntStream.range;

public class Ball implements Baseball {
    @Override
    public int compare(List<Integer> randomNumber, List<Integer> userNumber) {
        return (int) range(0, 3)
                .filter(n -> randomNumber.contains(userNumber.get(n)))
                .count();
    }
}
