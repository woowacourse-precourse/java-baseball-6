package baseball.domain;

import static baseball.constant.GameConstants.MAX_NUMBER_LENGTH;

import java.util.List;
import java.util.stream.IntStream;

public class GameRules {
    private GameRules() {
    }

    public static int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) userNumber.stream()
                .filter(computerNumber::contains)
                .count();
    }

    public static int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        return (int) IntStream.range(0, MAX_NUMBER_LENGTH)
                .filter(i -> userNumber.get(i).equals(computerNumber.get(i)))
                .count();
    }

    public static boolean isUserWin(int strike) {
        return strike == MAX_NUMBER_LENGTH;
    }
}
