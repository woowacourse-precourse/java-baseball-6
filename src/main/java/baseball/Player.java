package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final List<Integer> guessNumbers;

    private Player(String guessNumber) {
        isDigits(guessNumber);
        isValidDigitLength(guessNumber);
        isUniqueDigits(guessNumber);
        isValidRange(guessNumber);
        this.guessNumbers = convertStringToIntegerList(guessNumber);
    }

    private static ArrayList<Integer> convertStringToIntegerList(String guessNumber) {
        ArrayList<Integer> list = new ArrayList<>();
        for (char number : guessNumber.toCharArray()) {
            list.add(Character.getNumericValue(number));
        }
        return list;
    }

    public static Player from(String guessNumber) {
        return new Player(guessNumber);
    }

    private static void isValidRange(String guessNumber) {
        for (char number : guessNumber.toCharArray()) {
            if (number == '0') {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력이 가능합니다.");
            }
        }
    }

    private static void isDigits(String guessNumber) {
        for (char number : guessNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
            }
        }
    }

    private static void isUniqueDigits(String guessNumber) {
        Set<Character> duplicateSet = new HashSet<>();
        for (char number : guessNumber.toCharArray()) {
            duplicateSet.add(number);
        }
        if (duplicateSet.size() != guessNumber.length()) {
            throw new IllegalArgumentException("중복 된 숫자는 입력할 수 없습니다.");
        }
    }

    private static void isValidDigitLength(String guessNumber) {
        final int VALID_LENGTH = 3;
        if (guessNumber.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("세 자리의 숫자만 입력이 가능합니다.");
        }
    }
}
