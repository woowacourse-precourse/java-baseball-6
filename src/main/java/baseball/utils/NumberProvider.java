package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberProvider {
    private static final int NUMBER_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addNumber(numbers, number);
        }
        return numbers;
    }

    private static void addNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
