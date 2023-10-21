package baseball;

import java.util.List;

public class NumberValidation {

    public int[] getResult(int[] randomNumber, int[] inputNumber) {
        int result[] = new int[2];
        result[0] = getBallCount(randomNumber, inputNumber);
        result[1] = getStrikeCount(randomNumber, inputNumber);
        return result;
    }

    private int getBallCount(int[] randomNumber, int[] inputNumber) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber[index] != inputNumber[index]){
                ball += getBall(randomNumber, inputNumber[index]);
            }
        }
        return ball;
    }

    private int getBall(int[] randomNumber, int inputNumber) {
        for (int index = 0; index < 3; index++) {
            if (randomNumber[index] == inputNumber) {
                return 1;
            }
        }
        return 0;
    }

    private int getStrikeCount(int[] randomNumber, int[] inputNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber[index] == inputNumber[index]) {
                strike++;
            }
        }
        return strike;
    }
}
