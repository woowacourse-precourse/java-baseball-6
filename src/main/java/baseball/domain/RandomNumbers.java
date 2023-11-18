package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {

    public static int[] getGameNumbers(int size) {
        int[] computerNumber = new int[3];

        for (int i = 0; i < size; i++) {
            computerNumber[i] = getUniqueRandomNumber(computerNumber, i);
        }
        return computerNumber;
    }

    private static int getUniqueRandomNumber(int[] computerNumber, int i) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (!isUnique(computerNumber, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] computerNumber, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (computerNumber[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
