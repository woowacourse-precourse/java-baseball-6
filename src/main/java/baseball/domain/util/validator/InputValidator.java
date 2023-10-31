package baseball.domain.util.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void checkThreeNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }
    }

    public static void checkOnlyCompositionNumber(String input) {
        for (char c : input.toCharArray()) {
            charIsNumber(c);
        }
    }

    public static void charIsNumber(char c) {
        if (c < '1' || c > '9') {
            throw new IllegalArgumentException("입력된 값은 1~9 사이의 숫자만 가능합니다.");
        }
    }

    public static void checkDuplicationNumber(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            charContain(uniqueNumbers, c);
            uniqueNumbers.add(c);
        }
    }

    public static void charContain(Set<Character> uniqueNumbers, char c) {
        if (uniqueNumbers.contains(c)) {
            throw new IllegalArgumentException("입력된 숫자에 중복된 값이 있습니다.");
        }
    }

    public static void checkOnlyTwoNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
