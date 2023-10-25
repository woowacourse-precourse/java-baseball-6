package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public static int[] getRandomNumbers(int size, int start, int end) {
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbersList.add(getUniqueRandomNumber(numbersList, start, end));
        }

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = numbersList.get(i);
        }

        return numbers;
    }

    private static int getUniqueRandomNumber(List<Integer> numbers, int start, int end) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        while (!isUnique(numbers, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }
        return randomNumber;
    }

    private static Boolean isUnique(List<Integer> numbers, int randomNumber) {
        return !numbers.contains(randomNumber);
    }
}


