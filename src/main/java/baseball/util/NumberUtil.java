package baseball.util;

import java.util.ArrayList;
import java.util.List;

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
}
