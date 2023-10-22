package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class BaseballModel {
    private int[] targetNumber;

    public BaseballModel() {
        generateRandomNumber();
    }

    public void generateRandomNumber() {
        targetNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (containsNumber(targetNumber, randomNumber));
            targetNumber[i] = randomNumber;
        }
    }

    private boolean containsNumber(int[] array, int number) {
        for (int item : array) {
            if (item == number) {
                return true;
            }
        }
        return false;
    }

    public int[] getTargetNumber() {
        return targetNumber;
    }

}
