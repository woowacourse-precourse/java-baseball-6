package baseball.domain;

public class NumbersValidator extends Validator{
    @Override
    public void validate(String numbers){
        validateSize(numbers,3);
        validateType(numbers,"[0-9]+");
        validateUnique(numbers);
    }
}
