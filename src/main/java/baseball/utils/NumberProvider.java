package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberProvider {
    private static final int NUMBER_DIGIT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_DIGIT) {
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

    public static List<Integer> convertFrom(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
    }
}
