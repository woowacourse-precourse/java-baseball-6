package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validate {
    public static void validateInput(String input) throws IllegalArgumentException {
        checkEmpty(input);
        checkCiphers(input);
        checkOverlappingNumber(input);
    }

    public static void restartEndValidateInput(String input) throws IllegalArgumentException {
        checkEmpty(input);
        if (!("1".equals(input) || "2".equals(input))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
    }

    public static void checkEmpty(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다");
        }
    }

    public static void checkCiphers(String input) throws IllegalArgumentException {
        if (input.length()!=3) {
            throw new IllegalArgumentException("자릿수가 틀렸습니다.");
        }
    }

    public static void checkOverlappingNumber(String input) throws IllegalArgumentException {

        Set<Character> set = new HashSet<>();
        for (int i=0;i<input.length();i++) {
            char character = input.charAt(i);
            set.add(character);
        }
        if (set.size()!=3) {
            throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
        }
    }
}