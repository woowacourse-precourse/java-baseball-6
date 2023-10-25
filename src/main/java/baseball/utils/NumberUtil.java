package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtil {

    protected NumberUtil() {}
    public static boolean validNumberType(Object o) {
        if (o instanceof Integer) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validNumberRange(int min, int max, int value) {
        if (value >= min && value <= max) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }
        return true;
    }

    public static boolean validNumbersCount(List<Integer> numbers, int size) {
        if (numbers.size() == size) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static List<Integer> numberGenerator(int size) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            validArraysContainsNumber(numbers, randomNumber);
        }
        return numbers;
    }

    public static List<Integer> stringArrMapIntArr(List<String> numbers) {
        return numbers.stream()
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    private static void validArraysContainsNumber(List<Integer> numbers, int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
