package baseball.model;

public class RestartValidator extends Validator {
    @Override
    public void validate(String input) {
        validateSize(input, 1);
        validateType(input, "[1-2]+");
    }
}
