package baseball.util;

public final class Validator {
    static public void checkValidEndGameInput(String input) {
        if (!input.matches("[1-2]")) {
            throw new IllegalArgumentException("사용자 입력 값은 1또는 2만 가능합니다!");
        }
    }

    static public void checkValidInput(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("사용자 입력 값은 1에서 9만 가능합니다!");
        }
    }
}
