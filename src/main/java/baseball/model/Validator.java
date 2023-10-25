package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateUserInput(String input) {
        isInteger(input);
        isThreeDigits(input);
        int number = Integer.parseInt(input);
        isPositiveNumber(number);
        isNoDuplicatedNumbers(number);
    }


    public List<Integer> splitNumbersByDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        ;
        return digits;
    }

    private void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요.");
        }
    }

    private void isThreeDigits(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
    }

    private void isPositiveNumber(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException("양의 정수를 입력하세요.");
        }
    }

    private void isNoDuplicatedNumbers(int number) {
        List<Integer> arr = splitNumbersByDigits(number);
        Set<Integer> setOfArr = new HashSet<>();
        for (int num : arr) {
            setOfArr.add(num);
        }
        if (setOfArr.size() != 3) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }


}
