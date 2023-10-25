package baseball.util;

public final class Validator {
    static public void checkValidEndGameInput(String input) {
        if (!input.matches("[1-2]")) { // 입력값이 1또는 2가 아니라면
            throw new IllegalArgumentException("사용자 입력 값은 1또는 2만 가능합니다!");
        }
    }

    static public void checkValidInput(String input) {
        if (!input.matches("[1-9]{3}")) { // 입력값이 각각 1에서 9 사이의 숫자로 이루어진 세 자리 수가 아니라면
            throw new IllegalArgumentException("사용자 입력 값은 1에서 9만 가능합니다!");
        }
    }
}
