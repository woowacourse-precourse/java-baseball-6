package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validateInput(String input) throws IllegalArgumentException {
        isLengthThree(input);
        isDuplicateNumber(input);
    }
    public static void isLengthThree(String input) throws IllegalArgumentException {
        if (input.length()!=3) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해 주세요");
        }
    }

    public static void isDuplicateNumber(String input) throws IllegalArgumentException {

        Set<Character> set = new HashSet<>();
        for (int i=0;i<input.length();i++) {
            char character = input.charAt(i);
            set.add(character);
        }
        if (set.size()!=3) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해 주세요");
        }
    }
}
