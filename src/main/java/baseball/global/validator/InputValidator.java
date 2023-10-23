package baseball.global.validator;

import baseball.global.constant.RuleValue;
import baseball.global.message.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new IllegalArgumentException();
        }
    }

    private void validateInputSize(String playerInput){
        if (playerInput.length() != RuleValue.BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDistinct(String playerInput){
        String[] seperatedString = playerInput.split("");
        Set<String> distinctStringSet = new HashSet<>(Arrays.asList(seperatedString));
        if(distinctStringSet.size() != playerInput.length()){
            throw new IllegalArgumentException();
        }
    }
}
