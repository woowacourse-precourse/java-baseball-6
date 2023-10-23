package baseball.validator;

public class UserAnswerInputValidator implements InputValidator{

    @Override
    public void validateInput(String input) {
        // 3자리가 아닌 값 입력시 IllegalArgumentException 발생
        keepLengthThree(input);

        //숫자가 아닌경우 IllegalArgumentException 발생
        keepDigit(input);

        //숫자의 범위가 1~9이 아니면 IllegalArgumentException 발생
        keepOneToNine(input);

        //서로 다른 숫자로 구성되지 않을경우 IllegalArgumentException 발생
        keepUnique(input);
    }

}
