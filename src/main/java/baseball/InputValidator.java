package baseball;

import java.util.HashSet;
import java.util.Set;

public final class InputValidator {
    private InputValidator() {
    }

    public static void checkPlayerNumber(String input) {
        Set<Character> counter = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("게임종료");
            }
            counter.add(c);
        }
        if (counter.size() != 3 || input.length() != 3) {
            throw new IllegalArgumentException("게임 종료");
        }


    }

    public static void checkRestartResponse(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("게임 종료");
        }
    }
}
