package baseball.validators;

public class RangeValidator implements Validator {

    @Override
    public void validate(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요");
            }
        }
    }
}
