package baseball.controller;

import java.util.regex.Pattern;

import static baseball.utility.Constants.VALID_NUMBER_PATTERN;

public class InputException {
    public InputException(){}

    private boolean isValidInput;

    public boolean judgeValidInput(String input){
        if(!judgeVaildNumber(input)){
            throw new IllegalArgumentException();
        }

        isValidInput = true;
        return isValidInput;
    }

    private boolean judgeVaildNumber(String input){ //정규표현식을 사용하여 3자리의 적합한 숫자로 이루어진 문자열인지 확인한다.
        boolean isValidNumber = Pattern.matches(VALID_NUMBER_PATTERN,input);
        return isValidNumber;
    }
}
