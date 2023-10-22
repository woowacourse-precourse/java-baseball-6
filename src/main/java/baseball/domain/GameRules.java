package baseball.domain;

import static baseball.constant.GameConstants.MAX_NUMBER_LENGTH;

import java.util.List;

public class GameRules {
    public static int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public static int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static boolean isUserWin(int strike) {
        return strike == MAX_NUMBER_LENGTH;
    }
}
