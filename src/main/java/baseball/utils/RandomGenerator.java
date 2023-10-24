package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int[] getRandomNumbers(int size, int start, int end) {
        if (end - start + 1 < size) {
            throw new IllegalArgumentException("범위가 크기보다 작습니다.");
        }
        return generateRandomNumber(size, start, end);
    }

    private static int[] generateRandomNumber(int size, int start, int end) {
        int[] numbers = new int[size];
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

    private static boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
