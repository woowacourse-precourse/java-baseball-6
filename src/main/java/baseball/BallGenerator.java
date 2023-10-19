package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
    public static String generateUniqueBaseballNumber() {
        int firstDigit = Randoms.pickNumberInRange(1, 9);

        int secondDigit = Randoms.pickNumberInRange(1, 9);
        while (firstDigit == secondDigit) {
            secondDigit = Randoms.pickNumberInRange(1, 9);
        }

        int thirdDigit = Randoms.pickNumberInRange(1, 9);
        while ((firstDigit == thirdDigit) || (secondDigit == thirdDigit)) {
            thirdDigit = Randoms.pickNumberInRange(1, 9);
        }

        return String.valueOf(firstDigit * 100 + secondDigit * 10 + thirdDigit);
    }
}
