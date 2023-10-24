package baseball.validators;

public class QuitCommandValidator implements Validator {

    private static final String CONTINUE_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    @Override
    public void validate(String userInput) {
        if (!userInput.equals(CONTINUE_COMMAND) || !userInput.equals(EXIT_COMMAND)) {
            throw (new IllegalArgumentException("1번 혹은 2번을 입력하세요."));
        }
    }
}
