package baseball.model;

public class ContinueOrExit {
    private static final int CONTINUE = 1;
    private static final int EXIT = 2;

    private int userInput;

    public ContinueOrExit(int userInput) {
        validate(userInput);
        this.userInput = userInput;
    }

    private void validate(int userInput) {
        if (!(userInput == CONTINUE) && !(userInput == EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
