package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.service.BaseballService;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

import java.util.List;

public class BaseballController {

    /**
     * 초기 게임 세팅
     */
    public void init() throws InvalidInputException {
        BaseballService service = new BaseballService();

        while (true){

            ConsoleOutput.init();
            service.init();

            ConsoleOutput.requestInput();
            List<Integer> user = ConsoleInput.readDigitNumber(3);

            if (service.checkVictory(user)) {
                break;
            }

            String hint = service.compareToComputer(user);
        }
    }
}
