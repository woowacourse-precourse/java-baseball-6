package baseball.input;

import static baseball.game.constant.GameConstant.*;
import static baseball.view.ErrorMessage.*;

public class InputValidator {

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

    public void validateChoice(String userInput) {
        int parsedInput = Integer.parseInt(userInput);
        boolean isInvalidChoice = (parsedInput != RESTART_CHOICE.getValue()) && (parsedInput != END_CHOICE.getValue());
        if (isInvalidChoice) {
            throw new IllegalArgumentException(
                    INVALID_CHOICE.formatMessage(RESTART_CHOICE.getValue(), END_CHOICE.getValue()));
        }
    }
}