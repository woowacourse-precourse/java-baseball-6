package baseball.global.validator;

import baseball.global.constant.GameCode;
import baseball.global.constant.RuleValue;
import baseball.global.message.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.global.message.ExceptionMessage.*;

public class InputValidator {

    public void validateBaseballNumberInput(String playerInput){
        validateInputNumeric(playerInput);
        validateInputContainZero(playerInput);
        validateInputSize(playerInput);
        validateInputDistinct(playerInput);
    }

    public void validateGameCodeInput(String playerInput){
        validateInputNumeric(playerInput);
        validateIsExistGameCode(playerInput);
    }

    private void validateInputNumeric(String playerInput){
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC.getMessage());
        }
    }

    private void validateInputContainZero(String playerInput){
        if (playerInput.contains("0")){
            throw new IllegalArgumentException(INPUT_ZERO_UNAVAILABLE.getMessage());
        }
    }

    private void validateInputSize(String playerInput){
        if (playerInput.length() != RuleValue.BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException(INPUT_SIZE_MISMATCH.getMessage());
        }
    }

    private void validateInputDistinct(String playerInput){
        String[] seperatedString = playerInput.split("");
        Set<String> distinctStringSet = new HashSet<>(Arrays.asList(seperatedString));
        if(distinctStringSet.size() != playerInput.length()){
            throw new IllegalArgumentException(INPUT_NOT_DISTINCT.getMessage());
        }
    }

    private void validateIsExistGameCode(String playerInput){
        int integerInput = Integer.parseInt(playerInput);
        if(integerInput != GameCode.QUIT_CODE && integerInput != GameCode.RESTART_CODE){
            throw new IllegalArgumentException(INPUT_UNDEFINED.getMessage());
        }
    }
}
