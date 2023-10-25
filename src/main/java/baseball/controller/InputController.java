package baseball.controller;


import baseball.entity.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
    //입력을 받고, 유효성 검사를 호출하는 부분
    public Input playerInput(boolean isInGame) {
        Input input = new Input(Console.readLine(), isInGame);
        input.validate();
        return input;
    }



}
