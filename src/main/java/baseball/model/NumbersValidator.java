package baseball.model;

public class NumbersValidator extends Validator {
    @Override
    public void validate(String numbers) {
        validateSize(numbers, 3);
        validateType(numbers, "[1-9]+");
        validateUnique(numbers);
    }
}
