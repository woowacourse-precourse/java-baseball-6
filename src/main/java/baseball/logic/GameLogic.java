package baseball.logic;

import java.util.List;

public class GameLogic {
    public static int checkStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int checkBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (!userNumber.get(i).equals(computerNumber.get(i)) && computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}

