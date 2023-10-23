package baseball.domain;

import baseball.utils.Validate;
import camp.nextstep.edu.missionutils.Console;

public class Ball {
    static final int NUMBER_DIGIT = 3;
    int number;

    int getInputNumber() {
        number = Integer.parseInt(Console.readLine());

        if (!Validate.verifyTripleDigit(number) || !Validate.verifyEachDigitDuplicate(number) || !Validate.verifyEachDigitInRange(number)) {
            return number;
        } else {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }

    }

    int[] getDigitsArray(int number) {
        int[] intArrayNumber = new int[NUMBER_DIGIT];

        for (int i = NUMBER_DIGIT - 1; i >= 0; i--) {
            intArrayNumber[i] = number % 10;
            number /= 10;
        }

        return intArrayNumber;
    }
}
