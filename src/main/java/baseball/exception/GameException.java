package baseball.exception;

public class GameException {

    public static void inputExceptionChecker(String input){
        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
