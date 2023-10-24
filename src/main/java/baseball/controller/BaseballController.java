package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.service.BaseballService;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class BaseballController {

    /**
     * 초기 게임 세팅
     */
    public void init() throws InvalidInputException {
        BaseballService service = new BaseballService();

        ConsoleOutput.init();
        service.init();

        ConsoleOutput.requestInput();
        ConsoleInput.readDigitNumber(3);


    }
}
