package baseball.model.input;

public abstract class PlayerInput {
    protected final String input;

    public PlayerInput(String input) {
        this.input = input;
        validate();
    }

    protected abstract void validate();
}
