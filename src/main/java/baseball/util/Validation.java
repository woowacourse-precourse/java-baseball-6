package baseball.util;

public class Validation {

    private static final String NUMBER_REGEX = "^[1-9]*$";
    private static final Integer INPUT_LENGTH = 3;

    public String validateNumber(String number) {
        checkRightNumber(number);
        return number;
    }

    private void checkRightNumber(String number) {
        validateIsNumber(number);
        validateIsRightLength(number);
    }

    private void validateIsNumber(String number) {
        if(!number.matches(NUMBER_REGEX))
           throw new IllegalArgumentException("숫자로 입력이 되어야 합니다!");
    }

    private void validateIsRightLength(String number) {
        if(number.length() != INPUT_LENGTH)
            throw new IllegalArgumentException("입력 숫자의 길이는 3입니다!");
    }


}
