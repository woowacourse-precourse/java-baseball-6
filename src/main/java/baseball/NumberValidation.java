package baseball;

import java.util.List;

public class NumberValidation {

    public int getStrikeNumber(List randomNumber, String inputNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            strike += getStrike((int)randomNumber.get(index), inputNumber.charAt(index));
        }
        return strike;
    }

    private int getStrike(int randomNumber, char inputNumber) {
        if (randomNumber == Character.getNumericValue(inputNumber))
            return 1;
        return 0;
    }

    public int getBallNumber(List randomNumber, String inputNumber) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            ball += getBall(randomNumber, index, inputNumber.charAt(index));
        }
        return ball;
    }

    // strike 검사를 또 하는 것이 이상하다
    private int getBall(List randomNumber, int compareIndex, char inputNumber) {
        int number = Character.getNumericValue(inputNumber);
        if (getStrike((int)randomNumber.get(compareIndex), inputNumber) == 1)
            return 0;
        for (int index = 0; index < 3; index++) {
            if ((int)randomNumber.get(index) == number) {
                return 1;
            }
        }
        return 0;
    }
}
