package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
    private int[] targetNumber;

    public BaseballModel() {
        //생성자에서는 난수를 생성하지 않도록 변경
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
