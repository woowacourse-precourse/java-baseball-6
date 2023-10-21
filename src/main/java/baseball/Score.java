package baseball;

import java.util.List;
import java.util.Objects;

public class Score {
    public static Integer countStrike(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                strike += 1;
            }
        }

        return strike;
    }

    public static Integer countBall(List<Integer> playerNumber, List<Integer> computerNumber) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(playerNumber.get(i), computerNumber.get(i)) && computerNumber.contains(playerNumber.get(i))) {
                ball += 1;
            }
        }

        return ball;
    }

    public static void printGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d볼\n", ball);
        }
    }
}
