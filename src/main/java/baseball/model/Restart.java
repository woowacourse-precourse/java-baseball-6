package baseball.model;

public class Restart {

    private static final int RESTART_MESSAGE_SIZE = 1;
    private final String input;

    public Restart(String input) {
        validateBlank(input);
        this.input = input;
    }

    private static void validateBlank(String input) {
        if (input.length() != RESTART_MESSAGE_SIZE) {
            throw new IllegalArgumentException("입력값이 공백일 수 없습니다.");
        }
    }
}
