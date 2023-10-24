package baseball;

import java.lang.reflect.Array;
import java.util.List;

public class CountChecker {
    private int ball;
    private int strike;

    public boolean count(String playerNumber, List<Integer> computerNumber) {
        for (int i = 0; i < 3; i++) {
            if (playerNumber.charAt(i) - '0' == computerNumber.get(i)) {
                strike += 1;
            } else if (computerNumber.contains(playerNumber.charAt(i) - '0')) {
                ball += 1;
            }
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (strike == 3) {
            return true;
        }
        return false;
    }
}
