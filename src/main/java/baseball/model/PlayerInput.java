package baseball.model;

public class PlayerInput {
    public static final String EMPTY_INPUT = "입력이 없습니다.";
    protected final String input;

    public PlayerInput(String input) {
        this.input = input;
        validate();
    }

    protected void validate() {
        if (input == null) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }
}
