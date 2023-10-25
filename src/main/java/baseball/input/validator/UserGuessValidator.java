package baseball.input.validator;

import static baseball.constant.GameConstant.*;
import static baseball.view.ErrorMessage.*;

public class UserGuessValidator implements Validator {

    @Override
    public void validate(String userInput) {
        validateNotNull(userInput);
        validateIsInteger(userInput);
        validateLength(userInput);
        validateNoDuplicate(userInput);
    }

    public void validateNotNull(String userInput){
        if(userInput.isEmpty())
            throw new IllegalArgumentException(INVALID_NULL.getMessage());
    }

    public void validateIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            throw new IllegalArgumentException(INVALID_INTEGER.getMessage());
        }
    }

    public void validateNoDuplicate(String userInput){
        boolean hasDuplicateCharacters = userInput.chars().distinct().count()!=userInput.length();
        if (hasDuplicateCharacters)
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
    }

    public void validateLength(String userInput){
        boolean isInCorrectLength = userInput.length()!= GAME_DIGIT.getValue();
        if (isInCorrectLength){
            throw new IllegalArgumentException(
                    WRONG_DIGIT.formatMessage(GAME_DIGIT.getValue()));
        }
    }
}
