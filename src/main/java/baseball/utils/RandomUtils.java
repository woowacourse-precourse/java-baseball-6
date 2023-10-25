package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = getRandomNumberWithoutDuplication(numbers, start, end);
        }
        return numbers;
    }

    private static int getRandomNumberWithoutDuplication(int[] usedNumbers, int start, int end) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(start, end);
        } while (containsNumber(usedNumbers, randomNumber));

        return randomNumber;
    }

    private static boolean containsNumber(int[] numbers, int number) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
}
