package baseball.controller;

import baseball.domain.Numbers;

public class GameController {

    public GameController(){

    }

    public Numbers convertToNumbers(String values){
        return new Numbers(values);
    }
}
