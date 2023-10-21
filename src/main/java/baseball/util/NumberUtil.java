package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberUtil {
    public static List<Integer> converStringToList(String numberString) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numberString.length(); i++) {
            numberList.add(Character.getNumericValue(numberString.charAt(i)));
        }

        return numberList;
    }

    protected static void validateEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    protected static void validateLength(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리이어야 합니다.");
        }
    }

    protected static void validateNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
            }
        }
    }

    protected static void validateSign(String number) {
        if (number.charAt(0) == '-') {
            throw new IllegalArgumentException("입력값은 양의 정수이어야 합니다.");
        }
    }

    protected static void validateRange(String number) {
        List<Integer> numberList = NumberUtil.converStringToList(number);

        for (int integerNum : numberList) {
            if (integerNum < 1 || integerNum > 9) {
                throw new IllegalArgumentException("입력되는 각 숫자는 1 이상 9 이하의 정수로 이루어져야 합니다.");
            }
        }
    }

    protected static void validateUnique(String number) {
        Set<Character> numberSet = new HashSet<>();
        for (char digit : number.toCharArray()) {
            if (numberSet.contains(digit)) {
                throw new IllegalArgumentException("입력되는 각 숫자는 서로 다른 숫자이어야 합니다.");
            }
            numberSet.add(digit);
        }
    }
}
