package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 9;
    private static final int THIRD_PLACE = 1;
    private static final int SECOND_PLACE = 10;
    private static final int FIRST_PLACE = 100;

    public static String generateUniqueBaseballNumber() {
        int firstDigit = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);

        int secondDigit = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
        while (firstDigit == secondDigit) {
            secondDigit = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
        }

        int thirdDigit = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
        while ((firstDigit == thirdDigit) || (secondDigit == thirdDigit)) {
            thirdDigit = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
        }

        return String.valueOf(firstDigit * FIRST_PLACE + secondDigit * SECOND_PLACE + thirdDigit * THIRD_PLACE);
    }
}
