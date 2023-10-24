package global.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int[] getNumbers(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int getUniqueRandomNumber(int[] numbers, int start, int end, int i) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        while (!isUnique(numbers, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
