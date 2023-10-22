package baseball.model;

public class Restart {

    private static final int RESTART_MESSAGE_SIZE = 1;
    private final String input;

    public Restart(String input) {
        validateBlank(input);
        validateOptions(input);
        this.input = input;
    }

    private void validateBlank(String input) {
        if (input.length() != RESTART_MESSAGE_SIZE) {
            throw new IllegalArgumentException("입력값이 공백일 수 없습니다.");
        }
    }

    private void validateOptions(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("플레이어는 1이나 2 이외의 값을 입력할 수 없습니다.");
        }
    }
}
