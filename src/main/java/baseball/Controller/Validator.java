package baseball.Controller;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private static final String PLEASE_INPUT_THREENUMBER = "3개의 수를 입력해야합니다";
    private static final String PLEASE_INPUT_NUMBER = "숫자만 입력해야 합니다";
    private static final String PLEASE_INPUT_NOT_DUPLICATION = "중복되지 않는 3개의 수를 입력해야합니다";
    private static final String PLEASE_INPUT_ONE_OR_TWO = "1혹은 2를 입력하세요";
    private static final String NUMBER_RANGE = "[0-9]+";
    private static final int INPUT_NUMBER_SIZE = 3;
    private static final int RESTART_GAME_NUMBER = 1;
    private static final int GAME_END_NUMBER = 2;

    public void validatePlayerInput(String playerInput) {
        String[] numbers = playerInput.replace(" ", "").split("");
        if (numbers.length != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException(PLEASE_INPUT_THREENUMBER);
        }
        for (String number : numbers) {
            if (!number.matches(NUMBER_RANGE)) {
                throw new IllegalArgumentException(PLEASE_INPUT_NUMBER);
            }
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(numbers));
        if (set.size() != 3) {
            throw new IllegalArgumentException(PLEASE_INPUT_NOT_DUPLICATION);
        }
    }


    public void validateGameEndInput(String endnumber){
        try{
            int n = Integer.parseInt(endnumber);
            if(n!=RESTART_GAME_NUMBER && n!=GAME_END_NUMBER)
                throw new IllegalArgumentException(PLEASE_INPUT_ONE_OR_TWO);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(PLEASE_INPUT_NUMBER);
        }
    }

}
