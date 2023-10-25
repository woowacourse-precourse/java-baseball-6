package baseball;

import java.util.List;

public class Calculator {
    private final static int MAX_LENGTH = 3;
    private static int ball = 0;
    private static int strike = 0;

    public static void calculateGameResult(List<Integer> myNumbers, List<Integer> randomNumbers) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            int myVal = myNumbers.get(i);
            int randomVal = randomNumbers.get(i);

            if (myVal == randomVal) {
                strike++;
                continue;
            }
            if (randomNumbers.contains(myVal)) {
                ball++;
            }
        }
    }

    public static void initializeFields() {
        ball = 0;
        strike = 0;
    }

    public static int getBall() {
        return ball;
    }

    public static int getStrike() {
        return strike;
    }
}
