package baseball;


import java.util.HashSet;
import java.util.Set;

class InputValidator {
    private static final int VALID_GAME_INPUT_SIZE = 3;
    private static final char RESTART_GAME = '1';
    private static final char END_GAME = '2';

    public static void validateGameInput(String input) {
        ensureCorrectLength(input);
        ensureValidCharacters(input);
        ensureNoDuplicateCharacters(input);
    }

    private static void ensureCorrectLength(String input) {
        if (input.length() != VALID_GAME_INPUT_SIZE) {
            throw new IllegalArgumentException("유저 입력은 3자리여야 합니다.");
        }
    }

    private static void ensureValidCharacters(String input) {
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("입력은 숫자 1~9만 들어올 수 있습니다.");
            }
        }
    }

    private static void ensureNoDuplicateCharacters(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (inputSet.contains(ch)) {
                throw new IllegalArgumentException("입력은 중복될 수 없습니다.");
            }
            inputSet.add(ch);
        }
    }

    public static void validateRestartOrEndInput(String input) {
        if (input.length() != 1 || (input.charAt(0) != RESTART_GAME && input.charAt(0) != END_GAME)) {
            throw new IllegalArgumentException("입력은 1(재시작) 혹은 2(종료)만 들어올 수 있습니다.");
        }
    }
}