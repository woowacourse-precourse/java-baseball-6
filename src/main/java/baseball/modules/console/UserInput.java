package baseball.modules.console;

import java.util.Objects;

public abstract class UserInput {

    private final String input;

    public UserInput(final String input) {
        validate(input);
        this.input = input;
    }

    abstract void validate(final String input);

    public String getInput() {
        return input;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInput userInput = (UserInput) o;
        return Objects.equals(input, userInput.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "input='" + input + '\'' +
                '}';
    }
}
