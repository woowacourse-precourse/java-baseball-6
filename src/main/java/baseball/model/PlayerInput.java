package baseball.model;

public abstract class PlayerInput {
    protected final String input;

    public PlayerInput(String input) {
        this.input = input;
    }

    abstract protected void validate();
}
