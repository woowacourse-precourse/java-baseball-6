package baseball.controller;

import baseball.domain.Numbers;

public class GameController {
    public GameController(){
    }

    public Numbers convertToNumbers(String values){
        return new Numbers(values);
    }

    public void validateOption(String input){
        validateSize(input);
        validateType(input);
    }

    private void validateSize(String input){
        if(input.length()!=1){
            throw new IllegalArgumentException("값이 1자리여야 합니다.");
        }
    }

    private void validateType(String input){
        if (!input.matches("[1-2]+")){
            throw new IllegalArgumentException("값은 1 또는 2이어야 합니다.");
        }
    }

    public boolean isContinue(String input){
        validateOption(input);

        return input.equals("1");
    }

}
