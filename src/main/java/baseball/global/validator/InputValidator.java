package baseball.global.validator;

import baseball.global.constant.RuleValue;
import baseball.global.message.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.global.message.ExceptionMessage.*;

public class InputValidator {

    private void validateInput(String playerInput){
        validateInputNumeric(playerInput);
        validateInputSize(playerInput);
        validateInputDistinct(playerInput);
    }

    private void validateInputNumeric(String playerInput){
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC.getMessage());
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
}
