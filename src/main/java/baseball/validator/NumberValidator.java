package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    private static final int MENU_COUNT = 2;

    public void validateInputNumber(String inputNumber, int numberCount) {
        if (inputNumber.length() != numberCount || hasDuplicateDigits(inputNumber) || isInteger(inputNumber) == false
                || containsZero(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMenu(String menu) {
        if (isInteger(menu) == false || Integer.parseInt(menu) > MENU_COUNT || Integer.parseInt(menu) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean containsZero(String str) {
        for (char c : str.toCharArray()) {
            if (c == '0') {
                return true; // 0을 발견하면 true를 반환
            }
        }
        return false; // 0을 발견하지 못하면 false를 반환
    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true; // 변환이 성공하면 정수로만 구성되어 있다고 판단
        } catch (NumberFormatException e) {
            return false; // 변환이 실패하면 정수로만 구성되어 있지 않다고 판단
        }
    }

    public static boolean hasDuplicateDigits(String number) {
        Set<Character> seen = new HashSet<>();

        for (char digit : number.toCharArray()) {
            if (seen.contains(digit)) {
                return true; // 중복된 자리수가 발견되면 true를 반환
            } else {
                seen.add(digit); // 중복이 아니면 집합에 자리수 추가
            }
        }

        return false; // 중복된 자리수가 없으면 false를 반환
    }
}
