package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.*;

public class GameValidator {
    public static void isThreeDigitNumber() {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidInteger() {
        for(int i = 0; i < inputNumber.length(); i++) {
            char ch = inputNumber.charAt(i);
            if (!Character.isDigit(ch) || ch == '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void hasDuplicateDigits() {
        List<Character> digitList = new ArrayList<>();
        for (char digit : inputNumber.toCharArray()) {
            digitList.add(digit);
        }

        Set<Character> digitSet = new HashSet<>(digitList);

        if (digitList.size() != digitSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidTerminationChoice() {
        if (!(restartOrEndFlag.equals(TERMINATE) || restartOrEndFlag.equals(RESTART))) {
            throw new IllegalArgumentException();
        }
    }
}
