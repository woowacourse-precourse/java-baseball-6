package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {
    private final String playerInput;

    public PlayerNumbers(String playerInput) {
        isStringLengthValid(playerInput);
        isStringDigit(playerInput);
        isStringDuplicated(playerInput);

        this.playerInput = playerInput;
    }
    List<Integer> player = new ArrayList<>();

    public String getPlayerInput() {

        return playerInput;
    }

    // String 지료형 상태로 검증
    private static void isStringLengthValid(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("오류: 입력값 3자리수 초과");
        }
    }

    private static void isStringDigit(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("오류: 정수가 아닌 수");
            }
        }
    }

    private static void isStringDuplicated(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("오류: 중복된 수");
        }
    }
}
