package baseball.model;

import java.util.HashSet;
import java.util.Set;

public record PlayerNumbers(String playerInput) {
    public PlayerNumbers {
        isStringLengthThree (playerInput);
        isStringDigit (playerInput);
        isStringDuplicated (playerInput);

    }

    // String 지료형 상태로 검증
    private static void isStringLengthThree(String input) throws IllegalArgumentException {
        if (input.length () != 3) {
            throw new IllegalArgumentException ("[Error] 3자리 초과 입력");
        }
    }

    private static void isStringDigit(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length (); i++) {
            if (!Character.isDigit (input.charAt (i))) {
                throw new IllegalArgumentException ("[ERROR] 정수가 아닌 문자 입력");
            }
        }
    }

    private static void isStringDuplicated(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<> ();

        for (int i = 0; i < input.length (); i++) {
            set.add (input.charAt (i));
        }

        if (set.size () != input.length ()) {
            throw new IllegalArgumentException ("[ERROR] 중복된 수 입력");
        }
    }
}
