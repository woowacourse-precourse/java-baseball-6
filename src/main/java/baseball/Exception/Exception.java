package baseball.Exception;

public class Exception {
    public static void checkException(char[] guess) {
        checkLength(guess.length);
        checkDub(guess);
    }

    private static void checkDub(char[] guess) {
        StringBuilder sb = new StringBuilder();
        for (char c : guess) {
            if (sb.indexOf(String.valueOf(c)) != -1) {
                throw new IllegalArgumentException();
            }
            sb.append(c);
        }
    }

    private static void checkLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException();
        }
    }
}
