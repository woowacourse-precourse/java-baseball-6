package baseball.input;

import static baseball.constant.GameConstant.*;
import static baseball.view.message.ErrorMessage.*;

public class InputValidator{

    public void validateUserGuess(String userInput) {
        validateNotNull(userInput);
        validateIsInteger(userInput);
        validateLength(userInput);
        validateNoDuplicate(userInput);
    }

    public void validateUserChoice(String userInput) {
        validateNotNull(userInput);
        validateIsInteger(userInput);
        validateChoice(userInput);
    }

    private void validateNotNull(String userInput){
        if(userInput.isEmpty())
            throw new IllegalArgumentException(INVALID_NULL.getMessage());
    }

    private void validateIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            throw new IllegalArgumentException(INVALID_INTEGER.getMessage());
        }
    }

    private void validateNoDuplicate(String userInput){
        boolean hasDuplicateCharacters = userInput.chars().distinct().count()!=userInput.length();
        if (hasDuplicateCharacters)
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
    }

    private void validateLength(String userInput){
        boolean isInCorrectLength = userInput.length()!= GAME_DIGIT.getValue();
        if (isInCorrectLength){
            throw new IllegalArgumentException(
                    WRONG_DIGIT.formatMessage(GAME_DIGIT.getValue()));
        }
    }

    private void validateChoice(String userInput) {
        int parsedInput = Integer.parseInt(userInput);
        boolean isInvalidChoice = (parsedInput != RESTART_CHOICE.getValue()) && (parsedInput != END_CHOICE.getValue());
        if (isInvalidChoice) {
            throw new IllegalArgumentException(
                    INVALID_CHOICE.formatMessage(RESTART_CHOICE.getValue(), END_CHOICE.getValue()));
        }
    }

}
