package baseball.user.input;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    /**
     * 세 개의 숫자가 아니라면 IllegalArgumentException 발생
     */
    public void checkThreeNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 1~9 사이의 숫자인지 확인
     */
    public void checkOnlyCompositionNumber(String input) {
        for (char c : input.toCharArray()) {
            charIsNumber(c);
        }
    }

    /**
     * 1~9 사이의 숫자가 아니면 IllegalArgumentException 발생
     */
    public void charIsNumber(char c) {
        if (c < '1' || c > '9') {
            throw new IllegalArgumentException("입력된 값은 1~9 사이의 숫자만 가능합니다.");
        }
    }

    /**
     * 중복된 숫자 있는지 확인
     */
    public void checkDuplicationNumber(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            charContain(uniqueNumbers, c);
            uniqueNumbers.add(c);
        }
    }

    /**
     * 문자를 포함하고 있다면 IllegalArgumentException 발생
     */
    public void charContain(Set<Character> uniqueNumbers, char c) {
        if (uniqueNumbers.contains(c)) {
            throw new IllegalArgumentException("입력된 숫자에 중복된 값이 있습니다.");
        }
    }

    /**
     * 1 또는 2가 아니라면 IllegalArgumentException 발생
     */
    public void checkOnlyTwoNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
