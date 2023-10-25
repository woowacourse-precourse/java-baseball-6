package baseball.model.input;

public class RestartOrExitInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 1;
    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";
    private static final String INVALID_CHARACTER = "1 또는 2의 입력이 아닙니다.";
    private static final String INVALID_LENGTH = "입력이 1자리가 아닙니다.";

    public RestartOrExitInput(String input) {
        super(input);
        validate();
    }

    @Override
    protected void validate() {
        checkInputLength();
        checkInputCommand();
    }

    private void checkInputLength() {
        if (input.length() != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    private void checkInputCommand() {
        if (!(RESTART_GAME.equals(input)) && !(EXIT_GAME.equals(input))) {
            throw new IllegalArgumentException(INVALID_CHARACTER);
        }
    }

    public boolean isExitInput() {
        return EXIT_GAME.equals(input);
    }
}
