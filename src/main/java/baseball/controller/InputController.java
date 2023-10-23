package baseball.controller;


import baseball.entity.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
//리게임 값 유효성 검사
    public Input playerInput(boolean isInGame) {
        Input input = new Input(Console.readLine(), isInGame);
        input.validate();
        return input;
    }



}
