package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Validator;

public class GameController {
    public GameController() {}

    public Numbers convertToNumbers(String values){
        return new Numbers(values);
    }
    public boolean isContinue(String input){
        Validator validator=new Validator();
        validator.validateContinue(input);

        return isOne(input);
    }

    private boolean isOne(String input){
        return input.equals("1");
    }
}
