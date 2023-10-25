package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.service.BaseballService;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

import java.util.List;

public class BaseballController {

    private BaseballService service;

    public BaseballController(BaseballService service) {
        this.service = service;
    }

    /**
     * 초기 게임 세팅
     */
    public void init() {
        ConsoleOutput.init();
        service.init();
    }

    /**
     * 게임 시작
     */
    public void startGame() throws InvalidInputException {
        do{
            while (true){
                ConsoleOutput.requestInput();
                List<Integer> user = ConsoleInput.readDigitNumber(3);

                if (service.checkVictory(user)) {
                    ConsoleOutput.displayVictory();
                    break;
                }
                ConsoleOutput.displayHint(service.getHint(user));
            }
            ConsoleOutput.requestRestart();
        }while (ConsoleInput.readDigitNumber(1).get(0) == 1);
    }
}
