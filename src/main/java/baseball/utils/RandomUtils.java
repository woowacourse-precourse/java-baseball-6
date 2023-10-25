package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static int[] getRandomNumbers(int min, int max, int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            int randomNumber = Randoms.pickNumberInRange(min, max);

            while (!isUnique(numbers, i, randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(min, max);
            }
            numbers[i] = randomNumber;
        }
        return numbers;
    }

    private static Boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int index = 0; index < i; index++) {
            if (randomNumber == numbers[index]) {
                return false;
            }
        }
        return true;
    }
}
