package baseball.controller;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class NumberCheck {

    public boolean isThreeLetters(String input_Number) {
        return input_Number.length() == 3;
    }

    public boolean isDifferentNumbers(String input_Number) {
        Set<Character> charSet = new HashSet<>();

        for (char c : input_Number.toCharArray()) {
            charSet.add(c);
        }

        return charSet.size() == 3;
    }

    public boolean isBetween1to9(char checkChar) {
        return checkChar >= '1' && checkChar <= '9';
    }

    public boolean isNum(String input_Number) {
        for (int i = 0; i < input_Number.length(); i++) {
            if (!isBetween1to9(input_Number.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> toValidateData(String inputNumber) {
        if (!isThreeLetters(inputNumber)) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        } else if (!isNum(inputNumber)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } else if (!isDifferentNumbers(inputNumber)) {
            throw new IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.");
        }

        return makeStrtoInt(inputNumber);
    }

    public List<Integer> makeStrtoInt(String inputNumber) {
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char c = inputNumber.charAt(i);
            if (Character.isDigit(c)) {
                intList.add(Character.getNumericValue(c));
            }
        }

        return intList;
    }
}
