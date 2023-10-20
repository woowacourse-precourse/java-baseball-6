package baseball.util;

public class Validation {

    private static final String NUMBER_REGEX = "^[1-9]$";
    private static final Integer INPUT_LENGTH = 3;

    public boolean validateNumber(String number) {
        if(isRightNumber(number))
            return true;
        throw new IllegalArgumentException("Error");
    }

    private boolean isRightNumber(String number) {
        return validateIsNumber(number) && validateIsRightLength(number);
    }

    private boolean validateIsNumber(String number) {
        if(number.matches(NUMBER_REGEX))
           return true;
        throw new IllegalArgumentException("숫자로 입력이 되어야 합니다!");
    }

    private boolean validateIsRightLength(String number) {
        if(number.length() == INPUT_LENGTH)
            return true;
        throw new IllegalArgumentException("입력 숫자의 길이는 3입니다!");
    }


}
