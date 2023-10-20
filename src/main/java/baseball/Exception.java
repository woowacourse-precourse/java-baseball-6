package baseball;

import java.util.HashSet;

public class Exception {
    public static void checkException(char[] guess) {
        checkLength(guess.length);
        checkDub(guess);
    }

    private static void checkDub(char[] guess) {
        HashSet<Character> check = new HashSet<>();
        for (Character c : guess) {
            if (check.contains(c)) {
                throw new IllegalArgumentException();
            }
            check.add(c);
        }
    }

    private static void checkLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException();
        }
    }
}
