package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int NUMBER_LENGTH = 3;
    private static final String WRONG_LENGTH_MESSAGE = "숫자 세 자리를 입력하세요.";
    private static final String WRONG_RANGE_MESSAGE = "1 ~ 9 사이의 숫자를 입력하세요.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "서로 다른 세 자리의 숫자를 입력하세요.";
    private static final char START_NUMBER = '1';
    private static final char END_NUMBER = '9';

    public List<Integer> checkValidation(String numbers) {
        if (!isCorrectLength(numbers)) {
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        } else if (!isDigit(numbers)) {
            throw new IllegalArgumentException(WRONG_RANGE_MESSAGE);
        } else if (!isDifferentNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }

        List<Integer> result = new ArrayList<>();
        for (char c: numbers.toCharArray()){
            result.add(c - '0');
        }
        return result;
    }

    public boolean isCorrectLength(String numbers){
        return numbers.length() == NUMBER_LENGTH;
    }

    public boolean isDigit(String numbers){
        for (int i = 0; i < numbers.length(); i++) {
            if (!isCorrectRange(numbers.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isCorrectRange(char number){
        return number >= START_NUMBER && number <= END_NUMBER;
    }

    public boolean isDifferentNumbers(String numbers){
        Set<Character> set = new HashSet<>();
        for (char c: numbers.toCharArray()){
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
