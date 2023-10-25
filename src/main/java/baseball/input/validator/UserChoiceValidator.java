package baseball.input.validator;

import static baseball.constant.GameConstant.*;
import static baseball.view.ErrorMessage.*;

public class UserChoiceValidator implements Validator {

    @Override
    public void validate(String userInput) {
        validateNotNull(userInput);
        validateIsInteger(userInput);
        validateChoice(userInput);
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

    public void validateChoice(String userInput) {
        int parsedInput = Integer.parseInt(userInput);
        boolean isInvalidChoice = (parsedInput != RESTART_CHOICE.getValue()) && (parsedInput != END_CHOICE.getValue());
        if (isInvalidChoice) {
            throw new IllegalArgumentException(
                    INVALID_CHOICE.formatMessage(RESTART_CHOICE.getValue(), END_CHOICE.getValue()));
        }
    }
}