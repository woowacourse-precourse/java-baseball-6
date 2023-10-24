package baseball.controller;

import static baseball.utility.Constants.NUMBER_LIMIT_LENGTH;

public class InputException {
    public InputException(){}

    private String input;
    private boolean isValidNumber;

    public boolean judgeValidNumber(String input){
        this.input = input;

        if(!judgeNumberLengthThree()){
            throw new IllegalArgumentException();
        }

        isValidNumber = true;
        return isValidNumber;
    }

    private boolean judgeNumberLengthThree(){
        if(input.length() == NUMBER_LIMIT_LENGTH){
            return true;
        }
        return false;
    }
}
