package baseball.matcher;

import java.util.List;
import baseball.game.Baseball;

public class BaseballNumberMatcher {

    private static final int INITIAL_COUNT = 0;

    public Baseball matchNumbers(List<Integer> inputNumbers, List<Integer> randomNumbers) {
        int strike = INITIAL_COUNT;
        int ball = INITIAL_COUNT;

        for (int i = 0; i < inputNumbers.size(); i++) {
            if (inputNumbers.get(i).equals(randomNumbers.get(i))) {
                strike++;
            } else if (randomNumbers.contains(inputNumbers.get(i))) {
                ball++;
            }
        }

        return new Baseball(strike, ball);
    }
}
