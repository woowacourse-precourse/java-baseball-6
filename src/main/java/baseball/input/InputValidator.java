package baseball.input;

import baseball.game.constant.GameConstant;
import baseball.view.ErrorMessage;

public class InputValidator {

    public void validateNotNull(String userInput){
        if(userInput.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.INVALID_NULL.getMessage());
    }

    public void validateIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    public void validateNoDuplicate(String userInput){
        if (userInput.chars().distinct().count()!=userInput.length())
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    public void validateLength(String userInput){
        if (userInput.length()!= GameConstant.GAME_DIGIT.getValue())
            throw new IllegalArgumentException(
                    ErrorMessage.WRONG_DIGIT.formatMessage(GameConstant.GAME_DIGIT.getValue()));
    }

    public void validateChoice(String userInput){
        int parsedInput = Integer.parseInt(userInput);
        if (!(parsedInput==GameConstant.RESTART_CHOICE.getValue()
                || parsedInput==GameConstant.END_CHOICE.getValue()))
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_CHOICE.formatMessage(GameConstant.RESTART_CHOICE.getValue(),GameConstant.END_CHOICE.getValue()));
    }
}