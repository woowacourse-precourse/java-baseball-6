package baseball.controller;

import static baseball.util.ConstantUtil.WRONG_INPUT;

import java.util.HashMap;
import java.util.Map;

public class ExceptionController {

    /*
    예외처리
    1. 3자리 숫자이내
    2. 숫자만
    3. 모두 다른수
     */
    public void validateInput(String input) {
        validateSizeOfNumberLimit(input);
        validateIsNumber(input);
        validateIsDifferentNumber(input);
    }

    public void validateInputOneOrTwo(String input) {
        if(input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException(WRONG_INPUT);
    }

    private void validateSizeOfNumberLimit(String input) {
        if(input.length()!=3){
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private void validateIsNumber(String input) {
        for(char c: input.toCharArray()) {
            if(!Character.isDigit(c) || c== '0') {
                throw new IllegalArgumentException(WRONG_INPUT);
            }
        }
    }

    private void validateIsDifferentNumber(String input) {
        Map<Character, Boolean> map = new HashMap<>();

        for(char c : input.toCharArray()) {
            if(map.get(c)!=null) {
                throw new IllegalArgumentException(WRONG_INPUT);
            }
            map.put(c, true);
        }
    }
}
